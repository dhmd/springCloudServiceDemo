package com.jiuxiniot.example.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.jiuxiniot.example.constant.DateConst;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLocalTimeDeSerializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateConst.yyyy_MM_dd_HH_mm_ss);
        return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), fmt);
    }
}
