/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

/**
 *
 * @author Radu
 */
public class MyTestFramework {
    
    public static final String PATH_TO_JAR_COMMAND = "C:\\Program Files\\Java\\jdk-11.0.10\\bin\\jar.exe";
    
    public static final List<String> ACCEPTED_TYPES = Arrays.asList(new String[] {"int", "String"});
    
    private void redirectStdInput(String inputFile)
    {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(inputFile);
            System.setIn(inputStream);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
    private Class<?> isClass(String classPath, String sufix)
    {
        Class<?> classObj = null;
        File path = new File(classPath);
        
        if(path.exists())
        {
            try {

                MyClassLoader classLoader = new MyClassLoader();
                URL url = path.toURI().toURL();
                classLoader.addURL(url);
                classObj = classLoader.loadClass(sufix);
                return classObj;
                
            } catch (MalformedURLException | ClassNotFoundException | NoClassDefFoundError ex) {
                return null;
            }
        }
        
        return null;
    }
    
    private Class<?> tryToLoadClass(String classStr)
    {
        String slash = "\\";
        int index = classStr.lastIndexOf("\\");
        if(index == -1)
        {
            index = classStr.lastIndexOf("/");
            slash = "/";
        }
        if (index == -1)
            return null;
        String className = classStr.substring(index+1);
        StringBuilder prefix = new StringBuilder(classStr.substring(0, index));
        if(!className.endsWith(".class"))
            return null;
        className = className.replace(".class", "");
        System.out.println("prefix: " + prefix);
        System.out.println("className: " + className);
        String[] tokens = prefix.toString().split(Pattern.quote(slash));
        StringBuilder sufix = new StringBuilder(className);
        var classObj = isClass(prefix.toString(), sufix.toString());
        if(classObj != null)
            return classObj;
        
        for(int i=tokens.length-1; i>=0; --i)
        {
           sufix.insert(0, tokens[i] + ".");
           int indexToken = prefix.lastIndexOf(tokens[i]);
           prefix.delete(indexToken, prefix.capacity());
           classObj = isClass(prefix.toString(), sufix.toString());
           if(classObj != null)
               return classObj;
        }
        return null;
    }
    

    
    private Object instantiateObject(Class <?> classObj)
    {
        var constructors = classObj.getConstructors();
        for(var constructor : constructors)
        {
            int nrParameters = constructor.getParameterCount();
            
                try {
                    if(nrParameters == 0)
                        return constructor.newInstance();
                    else
                    {
                        var types = constructor.getParameterTypes();
                        List<Object> parametersValues = new ArrayList<>(); 
                        for(var type : types)
                        {
                            String typeStr = type.getSimpleName();
                            if(!ACCEPTED_TYPES.contains(typeStr))
                                break;
                            if(typeStr.equals("String"))
                                parametersValues.add(MyRandomUtil.generateStringValue(10));
                            else
                                parametersValues.add(MyRandomUtil.generateIntegerValue(1, 10));
                        }
                        if(parametersValues.size() == nrParameters)
                            return constructor.newInstance(parametersValues.toArray());
                    }
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.err.println(ex);
            }
        }
        return null;
        
    }
    
    private void invokeTestMethods(Class<?> classObj)
    {
        Object myInstance = instantiateObject(classObj); 
        var methods = classObj.getMethods();
        for(var method : methods)
        {
            if(method.isAnnotationPresent(Test.class))
            {
                var parameters = method.getParameterTypes();
                try{
                if(parameters.length == 0)
                    method.invoke(myInstance);
                else
                {
                    List<Object> parametersValues = new ArrayList<>(); 
                    for(var parameter : parameters )
                    {
                        String typeStr = parameter.getSimpleName();
                        if (!ACCEPTED_TYPES.contains(typeStr)) {
                            break;
                        }
                        if (typeStr.equals("String"))
                            parametersValues.add(MyRandomUtil.generateStringValue(10));
                        else
                            parametersValues.add(MyRandomUtil.generateIntegerValue(1, 10));
                    }
                    if(parametersValues.size() == parameters.length)
                        method.invoke(myInstance, parametersValues.toArray());
                }
                } catch (Throwable ex) {
                        System.err.println(ex.getCause());
                }
            }
        }
    }
    
    
    public void beginTest(String inputFile)
    {
        redirectStdInput(inputFile);
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) 
        {
            String classStr = scanner.nextLine();
            System.out.println("Full path: " + classStr);
            if(classStr.endsWith(".class"))
            {
                var classObj = tryToLoadClass(classStr);
                if(classObj != null)
                {
                    for (Method m : classObj.getMethods())
                    {
                        if(m.isAnnotationPresent(Test.class))
                        try {
                            m.invoke(null);
                        } catch (Throwable ex) {
                            System.err.println(ex.getCause());
                        }
                    }
                }
            }
            else if(classStr.endsWith(".jar"))
            {
              ProcessBuilder command = new ProcessBuilder(PATH_TO_JAR_COMMAND, "tf", classStr);
                try {
                    Process p = command.start();
                    p.waitFor();
                    InputStream in = p.getInputStream();
                    String content = new String (in.readAllBytes());
                    String[] tokens = content.split("\r\n");
                    
                    for(String token : tokens)
                    {
                        if(token.endsWith(".class"))
                        {
                            token = token.replace(".class", "");
                            token = token.replace("/", ".");
                            var classObj = isClass(classStr,token);
                            if(classObj != null)
                            {
                               Report report = new Report(classObj);
                               System.out.println(report);
                               System.out.println("Invokers:");
                               invokeTestMethods(classObj);
                            }
                            
                            
                        }
                    }
                    
                } catch (IOException | InterruptedException ex) {
                    System.err.println(ex);
                }
              
            }
            else
                System.out.printf("ERROR: this path '%s' is not a .jar or .class file\n",classStr);
        }
        
    }
}
