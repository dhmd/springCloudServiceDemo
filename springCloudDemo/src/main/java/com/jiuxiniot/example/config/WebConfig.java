package com.jiuxiniot.example.config;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public Gson gson() {
        final GsonBuilder builder = new GsonBuilder();
        builder.disableHtmlEscaping();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");   //待重构，需要改成接口规范约定的日期类型：yyyyMMddHHmmss格式。或者以Long型来替代
        //builder.serializeNulls();
        builder.registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter());
        //序列化
        builder.registerTypeAdapter(Double.class, new MyDoubleSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new MyLocalTimeSerializer());
        builder.registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
            @Override
            public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext jsonSerializationContext) {
                return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
        });
        //反序列化
        builder.registerTypeAdapter(LocalDateTime.class, new MyLocalTimeDeSerializer());
        builder.registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), fmt);
            }
        });
        return builder.create();
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(gson());
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        converters.add(gsonHttpMessageConverter);
    }
}
