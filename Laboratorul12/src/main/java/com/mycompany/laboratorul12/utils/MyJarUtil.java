/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul12.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class MyJarUtil {

    public static final String PATH_TO_JAR_COMMAND = "C:\\Program Files\\Java\\jdk-11.0.10\\bin\\jar.exe";

    private static String[] getContents(String path) {
        try {
            ProcessBuilder command = new ProcessBuilder(PATH_TO_JAR_COMMAND, "tf", path);
            Process p = command.start();
            p.waitFor();
            InputStream in = p.getInputStream();
            String content = new String(in.readAllBytes());
            String[] tokens = content.split("\r\n");
            return tokens;
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public static List<String> getClassFilesFromJar(String path) {
        if (!path.endsWith(".jar")) {
            return null;
        }
        String[] tokens = getContents(path);
        List<String> classFiles = new ArrayList<>();
        for (String token : tokens) {
            if (token.endsWith(".class")) {
                classFiles.add(token);
            }
        }
        return classFiles;
    }
}
