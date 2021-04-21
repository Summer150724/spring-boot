package com.example.springbootdemo.mybatis.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-20 19:26
 * @description 全半角空格转义工具类
 */
public class CharEscapeUtil {

    /**
     * mysql的模糊查询时特殊字符转义
     *
     * @param before
     * @return
     */
    public static String escapeChar(String before) {
        if (StringUtils.isNotBlank(before)) {
            //before = before.replaceAll("\\\\", "\\\\\\\\");
            //before = before.replaceAll("_", "\\\\_");
            //before = before.replaceAll("%", "\\\\%");
            //空格（全半角）
            before = before.replaceAll(" ", "%");
            before = before.replaceAll("　", "%");
        }
        return before;
    }


}
