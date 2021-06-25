package com.example.springbootdemo.design_pattern.chain;

import org.hzero.core.interceptor.ChainId;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 21:30
 * @description 用户的操作组,声明拦截链的id
 */
public enum UserOperation implements ChainId {
    // 用户注册
    REGISTER("REGISTER"),
    // 用户更新
    MODIFY("MODIFY"),
    // 用户失效
    INVALID("INVALID"),
    // 用户注销
    DEPRECATED("DEPRECATED")
    ;


    private final String chainId;

    UserOperation(String chainId) {
        this.chainId = chainId;
    }

    @Override
    public String id() {
        return chainId;
    }
}
