package com.jiuxiniot.example.annotation;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class OkHttpUrlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String reqUrl = request.url().toString();
        log.info("reqUrl: {}", reqUrl);

        Response response = new Response.Builder()
                .code(200)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), reqUrl))
                .message(reqUrl)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .build();
        return response;
    }
}
