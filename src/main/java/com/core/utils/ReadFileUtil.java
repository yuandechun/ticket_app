package com.core.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ReadFileUtil {

    public static StringBuffer readFileByLine(String dirPath){
        StringBuffer result = new StringBuffer();
        File file = new File(dirPath);
        if (!file.exists()){
           return null;
        }else {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String str = null;
                while ((str = reader.readLine()) != null) {
                    result.append(str + " ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
