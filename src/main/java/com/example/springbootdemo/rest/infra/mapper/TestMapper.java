package com.example.springbootdemo.rest.infra.mapper;

import com.example.springbootdemo.rest.domain.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-19 16:28
 * @description
 */
@Mapper
public interface TestMapper {
    List<Test> getAll ();

    @Select(value = "select * from test where id = 5")
    List<Test> select();
}
