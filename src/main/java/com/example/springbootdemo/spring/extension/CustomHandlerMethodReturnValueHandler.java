/**
 * 文件名：CustomHandlerMethodReturnValueHandler.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-05-21 17:50
 * @description
 */
@Slf4j
@Component
public class CustomHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return true;
    }

    /**
     * 为啥没用!!!
     * 不生效是因为Controller注解了responseBody,导致在选择handler的时候选择了RequestResponseBodyMethodProcessor{@link RequestResponseBodyMethodProcessor}
     * @param o
     * @param methodParameter
     * @param modelAndViewContainer
     * @param webRequest
     * @throws Exception
     */
    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest) throws Exception {
        // 设置这个就是最终的处理类了，处理完不再去找下一个类进行处理
        modelAndViewContainer.setRequestHandled(true);

        // 获得注解并执行filter方法 最后返回
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write("别返回了");
        log.error("Mycroft-returnValue:{}", o);
    }
}
