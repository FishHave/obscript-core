package com.obscript.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Function {
    public static Function findMainFunction(JsonArray functions){
        for(int i = 0;i < functions.size();i++) {
            if(functions.get(i).getAsJsonObject().get("name").getAsString().equals("main")){
                return new Function(functions.get(i).getAsJsonObject());
            }
        }
        return null;
    }
    public Function(JsonObject object) {

    }
}
