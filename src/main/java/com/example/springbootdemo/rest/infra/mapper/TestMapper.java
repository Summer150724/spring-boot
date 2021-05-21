package com.example.springbootdemo.rest.infra.mapper;

import com.example.springbootdemo.rest.domain.entity.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    List<Test> getAll (@Param("int") Integer integer);

    List<Test> select(@Param("list") List<Long> idList);

    void insert(@Param("list") List<Test> list);

    List<Test> selectByIds(@Param("ids") String ids);

}
