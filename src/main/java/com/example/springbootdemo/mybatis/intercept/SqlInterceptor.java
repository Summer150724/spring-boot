/**
 * 文件名：SqlInterceptor.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.mybatis.intercept;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 23:07
 * @description
 */
@Intercepts(value = @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
@Component
@Slf4j
public class SqlInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 拦截sql
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = statement.getBoundSql(parameterObject);
        String sql = boundSql.getSql();
        log.info("获取到的SQL：{}", sql);
        StringUtils.isBlank(sql);
        // 返回
        return invocation.proceed();
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
