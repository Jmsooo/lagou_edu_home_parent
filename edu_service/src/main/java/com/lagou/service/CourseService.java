package com.lagou.service;

import com.lagou.bean.Course;
import com.lagou.bean.CourseVO;

import java.util.List;

public interface CourseService {

    /**
     * 多条件列表查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

}
