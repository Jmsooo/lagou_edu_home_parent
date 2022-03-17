package com.lagou.dao;

import com.lagou.bean.Test;

import java.util.List;

public interface TestMapper {
    /**
     * 对 Test 表进行查询所有
     */
    public List<Test> findAllTest();
}
