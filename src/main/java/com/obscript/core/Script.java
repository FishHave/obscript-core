package com.obscript.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Script implements ObscriptElement{
    public static final String TAG_IMPORT = "import";
    public static final String TAG_FUNCTIONS = "functions";
    private List<String> imports;
    private List<Function> functions;
    public Script(JsonObject object) {
        if(check(object)) {
            imports = getImports(object.get(TAG_IMPORT).getAsJsonArray());
            functions = getFunctions(object.get(TAG_FUNCTIONS).getAsJsonArray());
        }
    }
    private List<String> getImports(JsonArray array) {
        List<String> imports = new ArrayList<>();
        for (JsonElement element : array) {
            if(element.isJsonPrimitive()) {
                imports.add(element.getAsString());
            }
        }
        return imports;
    }
    private List<Function> getFunctions(JsonArray array) {

    }

    @Override
    public boolean check(JsonElement element) {
        if(element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();
            return object.has(TAG_IMPORT)  && object.has(TAG_FUNCTIONS);
        }
        return false;
    }
}
