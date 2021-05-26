/**
 * 文件名：CustomRequestBodyAdvice.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-05-24 11:29
 * @description
 */
@ControllerAdvice(annotations = {RestController.class})
public class CustomRequestBodyAdvice implements RequestBodyAdvice {

    /**
     * Invoked first to determine if this interceptor applies.
     *
     * @param methodParameter the method parameter
     * @param targetType      the target type, not necessarily the same as the method
     *                        parameter type, e.g. for {@code HttpEntity<String>}.
     * @param converterType   the selected converter type
     * @return whether this interceptor should be invoked or not
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return false;
    }

    /**
     * Invoked second before the request body is read and converted.
     *
     * @param inputMessage  the request
     * @param parameter     the target method parameter
     * @param targetType    the target type, not necessarily the same as the method
     *                      parameter type, e.g. for {@code HttpEntity<String>}.
     * @param converterType the converter used to deserialize the body
     * @return the input request or a new instance, never {@code null}
     */
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return null;
    }

    /**
     * Invoked third (and last) after the request body is converted to an Object.
     *
     * @param body          set to the converter Object before the first advice is called
     * @param inputMessage  the request
     * @param parameter     the target method parameter
     * @param targetType    the target type, not necessarily the same as the method
     *                      parameter type, e.g. for {@code HttpEntity<String>}.
     * @param converterType the converter used to deserialize the body
     * @return the same body or a new instance
     */
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return null;
    }

    /**
     * Invoked second (and last) if the body is empty.
     *
     * @param body          usually set to {@code null} before the first advice is called
     * @param inputMessage  the request
     * @param parameter     the method parameter
     * @param targetType    the target type, not necessarily the same as the method
     *                      parameter type, e.g. for {@code HttpEntity<String>}.
     * @param converterType the selected converter type
     * @return the value to use or {@code null} which may then raise an
     * {@code HttpMessageNotReadableException} if the argument is required.
     */
    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return null;
    }
}
