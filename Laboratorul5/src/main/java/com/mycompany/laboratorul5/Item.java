/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.nio.file.Path;
import java.io.File;
import java.io.Serializable;
import java.util.Map;
/**
 *
 * @author Radu
 */
public abstract class Item implements Serializable {
    protected String name;
    protected String pathStr;
    public File getFile()
    {
        return Path.of(pathStr).toFile();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathStr() {
        return pathStr;
    }

    public void setPathStr(String pathStr) {
        this.pathStr = pathStr;
    }
    
    public abstract boolean isSong();
    public abstract boolean isMovie();
    public abstract Map<String,String> getAttrMap();
    public abstract String getInstanceType();
    
    
    
    
}
