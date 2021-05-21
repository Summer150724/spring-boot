package com.example.springbootdemo.mybatis.interceptor;


import com.example.springbootdemo.mybatis.util.CharEscapeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-20 19:26
 * @description Sql语句拦截器,对模糊查询的特殊字符进行特殊处理
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class SelectSqlInterceptor implements Interceptor {

    public static final Logger logger = LoggerFactory.getLogger(SelectSqlInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Exception {
        logger.debug("---------------25583 SelectSqlInterceptor start--------------");
        //通过StatementHandler获取执行的sql
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        Object parameterObject = statementHandler.getParameterHandler().getParameterObject();
        //打印查询语句
        if (logger.isInfoEnabled()) {
            // logger.info(sql);
        }
        modifyLikeSql(sql, parameterObject, boundSql);
        logger.info("---------------25583 SelectSqlInterceptor end----------------");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 对关键字进行字符替换
     *
     * @param sql             sql
     * @param parameterObject 查询属性
     * @param boundSql        boundSql
     * @return
     */
    @SuppressWarnings("unchecked")
    public static BoundSql modifyLikeSql(String sql, Object parameterObject, BoundSql boundSql) throws IllegalAccessException {
        if (ObjectUtils.isEmpty(parameterObject)) {
            return boundSql;
        }

        if (!sql.toLowerCase().contains(" like ") || !sql.toLowerCase().contains("?")) {
            return boundSql;
        }
        // 获取关键字的个数（）
        String[] strList = sql.split("\\?");
        for (int i = 0; i < strList.length; i++) {
            if (strList[i].toLowerCase().contains(" like ")) {
                List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
                if (i < parameterMappings.size()) {
                    ParameterMapping parameterMapping = parameterMappings.get(i);
                    String property = parameterMapping.getProperty();
                    Object additionalParameter = boundSql.getAdditionalParameter(property);
                    if (additionalParameter != null) {
                        if (additionalParameter instanceof String) {
                            logger.info("additionalParameter.toString:{}", additionalParameter.toString());
                            boundSql.setAdditionalParameter(property, CharEscapeUtil.escapeChar(additionalParameter.toString()));
                        }
                    } else {
                        String fieldValue = (String) getFieldValueByFieldName(property, parameterObject);
                        logger.info("fieldValue :{}", fieldValue);
                        if(StringUtils.isNotEmpty(fieldValue)){
                            boundSql.setAdditionalParameter(property, CharEscapeUtil.escapeChar(fieldValue));
                        }
                    }
                }
            }
        }
        return boundSql;
    }

    public static Object getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            // 对private的属性的访问
            field.setAccessible(true);
            String typeName = field.getType().getTypeName();
            if ("java.lang.String".equals(typeName)) {
                return field.get(object);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
