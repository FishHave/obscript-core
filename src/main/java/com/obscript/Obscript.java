package com.obscript;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Obscript {
    public static void main(String[] args) {
        File file = new File(args[0]);
        String script = readFile(file);
        JsonObject object = JsonParser.parseString(script).getAsJsonObject();
    }
    private static String readFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            int count;
            char[] ch = new char[1024];
            StringBuilder builder = new StringBuilder();
            while((count = reader.read(ch)) != -1) {
                builder.append(new String(ch, 0, count));
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
