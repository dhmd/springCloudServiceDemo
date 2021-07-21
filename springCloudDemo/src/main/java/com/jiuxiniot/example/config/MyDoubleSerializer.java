package com.jiuxiniot.example.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MyDoubleSerializer implements JsonSerializer<Double> {
    @Override
    public JsonElement serialize(Double src, Type type, JsonSerializationContext jsonSerializationContext) {
        if (src == src.longValue())
            return new JsonPrimitive(src.longValue());
        return new JsonPrimitive(src);
    }
}
