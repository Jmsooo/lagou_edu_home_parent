package com.lagou.dao;

import com.lagou.bean.Course;
import com.lagou.bean.CourseVO;

import java.util.List;

public interface CourseMapper {

    /**
     * 多条件列表查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

}
