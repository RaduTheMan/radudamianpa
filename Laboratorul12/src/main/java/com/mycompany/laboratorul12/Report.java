/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul12;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class Report {
    private String className;
    private String superClassName;
    private List<List<String>> constructorsParameters = new ArrayList<>();
    private List<String> fieldsStr = new ArrayList<>();
    private List<String> methodsStr = new ArrayList<>();
    public Report(Class<?> classObj)
    {
        obtainTitle(classObj);
        obtainSuperClass(classObj);
        obtainConstructors(classObj);
        obtainFields(classObj);
        obtainMethods(classObj);
    }
    
    private void obtainTitle(Class<?> classObj)
    {
        className = Modifier.toString(classObj.getModifiers()) +
                " class " + classObj.getSimpleName(); 
    }
    private void appendTitleAndSuperClass(StringBuilder stringBuilder)
    {
        stringBuilder.append("----\n").append(className);
        if(superClassName != null)
            stringBuilder.append(" extends ").append(superClassName);
    }
    
    private void obtainSuperClass(Class<?> classObj)
    {
        var superClassObj = classObj.getSuperclass();
        if(superClassObj != null)
        {
            superClassName = superClassObj.getSimpleName();
        }
    }
    
    
    private void obtainConstructors(Class<?> classObj)
    {
        var constructors = classObj.getConstructors();
        for(var constructor : constructors)
        {
              var types = constructor.getParameterTypes();
              List <String> typesStr = new ArrayList<>();
              for(var type : types)
              {
                  typesStr.add(type.getSimpleName());
              }
            constructorsParameters.add(typesStr);
        }
    }
    
    private void appendConstructors(StringBuilder stringBuilder)
    {
        stringBuilder.append("\n Constructors: \n");
        for(var constructorParameters : constructorsParameters)
        {
            stringBuilder.append(className).append("( ");
            for(var parameter : constructorParameters)
            {
                 stringBuilder.append(parameter).append(", ");
            }
            stringBuilder.append(")\n");
            
        }
    }
    
    private void obtainFields(Class<?> classObj)
    {
        var fields = classObj.getDeclaredFields();
        for(var field : fields)
        {
            String modifierStr = Modifier.toString(field.getModifiers());
            fieldsStr.add(modifierStr + " " + field.getType().getSimpleName()
                    + " " + field.getName());
        }
        
    }
    
    private void appendFields(StringBuilder stringBuilder)
    {
        stringBuilder.append("Fields: \n");
        for(var fieldStr : fieldsStr)
        {
            stringBuilder.append(fieldStr + "\n");
        }
    }
    
    private void obtainMethods(Class<?> classObj)
    {
        var methods = classObj.getDeclaredMethods();
        for(var method : methods)
        {
            String modifierStr = Modifier.toString(method.getModifiers());
            StringBuilder stringBuilder = new StringBuilder(modifierStr + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "( ");
            var types = method.getParameterTypes();
            for(var type : types)
            {
                stringBuilder.append(type.getSimpleName()).append(", ");
            }
            stringBuilder.append(" )");
            methodsStr.add(stringBuilder.toString());
            
        }
    }
    
    private void appendMethods(StringBuilder stringBuilder)
    {
        stringBuilder.append("Methods: \n");
        for(var methodStr : methodsStr)
        {
            stringBuilder.append(methodStr + "\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        appendTitleAndSuperClass(stringBuilder);
        appendConstructors(stringBuilder);
        appendFields(stringBuilder);
        appendMethods(stringBuilder);
        return stringBuilder.toString();
    }
    
    
}
