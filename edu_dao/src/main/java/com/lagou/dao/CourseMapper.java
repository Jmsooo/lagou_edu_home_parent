package com.lagou.dao;

import com.lagou.bean.Course;
import com.lagou.bean.CourseVO;
import com.lagou.bean.Teacher;

import java.util.List;

public interface CourseMapper {

    /**
     * 多条件列表查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 新增课程信息
     * @param course
     */
    public void saveCourse(Course course);

    /**
     * 薪资老师信息
     * @param teacher
     */
    public void saveTeacher(Teacher teacher);

}
