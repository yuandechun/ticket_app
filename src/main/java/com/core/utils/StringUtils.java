package com.core.utils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String processVariables(String content, Map queryModel) {
        if (content.isEmpty()) {
            return content;
        }
        Pattern quoteRegex = Pattern.compile("\\$\\w*\\$");
        Matcher quoteRegexMatcher = quoteRegex.matcher(content);
        while (quoteRegexMatcher.find()) {
            if (quoteRegexMatcher.group().length() > 1) {
                String variableName = quoteRegexMatcher.group().substring(1, quoteRegexMatcher.group().length() - 1);
                content = content.replace("$" + variableName + "$", (String) queryModel.get(variableName));
            }
        }
        return content;
    }

    public static String processSqlVariables(String content, Map queryModel) {
        if (content.isEmpty()) {
            return content;
        }
        Pattern quoteRegex = Pattern.compile("\\$\\w*\\$");
        Matcher quoteRegexMatcher = quoteRegex.matcher(content);
        while (quoteRegexMatcher.find()) {
            if (quoteRegexMatcher.group().length() > 1) {
                String variableName = quoteRegexMatcher.group().substring(1, quoteRegexMatcher.group().length() - 1);
                if (queryModel.get(variableName) instanceof List) {
                    List variableValue = (List) queryModel.get(variableName);
                    StringBuffer newValue = new StringBuffer();
                    for (Object value : variableValue) {
                        newValue.append("\'" + value + "\'" + ",");
                    }
                    content = content.replace("$" + variableName + "$", newValue.toString().substring(0,newValue.length()-1));
                } else if (queryModel.get(variableName) instanceof String){
                    content = content.replace("$" + variableName + "$", (String) queryModel.get(variableName));
                }
            }
        }
        return content;
    }
}
