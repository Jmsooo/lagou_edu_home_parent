package com.lagou.service;

import com.lagou.bean.Test;

import java.util.List;

public interface TestService {

    /**
     * 对 test 表进行查询所有
     */
    public List<Test> findAllTest();

}
