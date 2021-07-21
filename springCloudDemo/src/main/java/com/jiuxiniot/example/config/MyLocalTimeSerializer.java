package com.jiuxiniot.example.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.jiuxiniot.example.constant.DateConst;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLocalTimeSerializer implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime date, Type type, JsonSerializationContext jsonSerializationContext) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DateConst.yyyy_MM_dd_HH_mm_ss);
        return new JsonPrimitive(df.format(date));
    }
}
