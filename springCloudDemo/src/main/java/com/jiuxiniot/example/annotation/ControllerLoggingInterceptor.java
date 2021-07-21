package com.jiuxiniot.example.annotation;

import com.google.gson.Gson;
import com.jiuxiniot.example.dto.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
@Slf4j
@Order(-2)
public class ControllerLoggingInterceptor {

    @Resource
    private MappingJackson2HttpMessageConverter converter;

    @Resource
    private Gson gson;

    /*@Pointcut("execution(* com.jiuxiniot.example.controller.*.*(..))")
    public void myLogging(){
    }

    @Around("myLogging()")
    public Object controllerLogger(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String reqUrl = request.getRequestURI();
        log.info("controller reqUrl: {}", reqUrl);
        String myMethod = pjp.getSignature().getName();
        log.info("controller method: {}", myMethod);
        if(reqUrl.contains("export") ||
                reqUrl.contains("download") ||
                reqUrl.contains("upload")){
            return pjp.proceed();
        } else {
            Object[] params = pjp.getArgs();
            log.info("req params: {}", this.gson.toJson(params));
            Object retObj = pjp.proceed(params);
            log.info("controller resp: {}", this.gson.toJson(retObj));
            return retObj;
        }
    }*/

    /**
     * 拦截所有@ResponseBody
     */
    @Pointcut("execution(* com.jiuxiniot.example.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public void responseBodyPointCut() {

    }

    @Around(value = "responseBodyPointCut()")
    @ResponseBody
    public void formatResult2JSON(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String reqUrl = request.getRequestURI();
        log.info("controller reqUrl: {}", reqUrl);
        String myMethod = pjp.getSignature().getName();
        log.info("controller method: {}", myMethod);

        Object[] params = pjp.getArgs();
        log.info("req params: {}", this.gson.toJson(params));

        Object ret = pjp.proceed(params);
        ResponseEntity responseBase = ResponseEntity.ok(ret);
        log.info("controller resp: {}", this.gson.toJson(responseBase));

        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        converter.write(responseBase, MediaType.APPLICATION_JSON, outputMessage);
        response.getOutputStream().close();
    }

}
