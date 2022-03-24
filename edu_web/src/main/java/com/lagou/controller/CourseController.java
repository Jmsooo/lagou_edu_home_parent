package com.lagou.controller;

import com.lagou.bean.Course;
import com.lagou.bean.CourseVO;
import com.lagou.bean.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 多条件课程列表查询
     *
     * @param courseVO
     * @return
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {
        List<Course> list = courseService.findCourseByCondition(courseVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功!", list);
        return responseResult;
    }

    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //1. 判断接收到的上传文件是否为空
        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        //2. 获取项目部署路径
        //${tomcat}\webapps\edu_web\
        String realPath = request.getServletContext().getRealPath("/");
        // /edu-web
        String contextPath = request.getContextPath();
        //${tomcat}\webapps\
        String subString = realPath.substring(0, realPath.indexOf(contextPath.substring(1)));

        //3. 获取原文件名
        String originalFilename = file.getOriginalFilename();

        //4. 生成新文件名
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5. 文件上传
        String uploadPath = subString + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        //如果目录不存在,就创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdir();
        }

        //图片上传
        file.transferTo(filePath);

        //6. 将文件名和文件路径返回,进行响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);
        //http://localhost:8080/upload/
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);

        return new ResponseResult(true, 200, "图片上传成功!", map);
    }


}
