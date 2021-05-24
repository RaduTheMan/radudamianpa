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
    public Report(Class<?> classObj)
    {
        obtainTitle(classObj);
        obtainSuperClass(classObj);
        obtainConstructors(classObj);
        obtainFields(classObj);
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
        var fields = classObj.getFields();
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        appendTitleAndSuperClass(stringBuilder);
        appendConstructors(stringBuilder);
        appendFields(stringBuilder);
        return stringBuilder.toString();
    }
    
    
}
