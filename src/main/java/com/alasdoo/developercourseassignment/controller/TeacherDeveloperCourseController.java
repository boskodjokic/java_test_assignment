package com.alasdoo.developercourseassignment.controller;

import com.alasdoo.developercourseassignment.dto.TeacherDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.service.impl.TeacherDeveloperCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacherdevelopercourse")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherDeveloperCourseController {

    @Autowired
    private TeacherDeveloperCourseServiceImpl teacherDeveloperCourseServiceImpl;

    @GetMapping(value = "/getTeacherCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDeveloperCourseDTO selectTeacherDeveloperCourse(@PathVariable("id") Integer id) {
        return teacherDeveloperCourseServiceImpl.findOne(id);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeacherDeveloperCourseDTO> getAllTeacherDeveloperCourses() {
        return teacherDeveloperCourseServiceImpl.findAll();
    }

    @PostMapping(value = "/addTeacherCourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDeveloperCourseDTO saveTeacherDeveloperCourse(@RequestBody TeacherDeveloperCourseDTO teacherDeveloperCourseDTO) {
        return teacherDeveloperCourseServiceImpl.save(teacherDeveloperCourseDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDeveloperCourseDTO updateTeacherDeveloperCourse(@PathVariable("id") Integer id, @RequestBody TeacherDeveloperCourseDTO teacherDeveloperCourseDTO) {
        return teacherDeveloperCourseServiceImpl.update(id, teacherDeveloperCourseDTO);
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeacherDeveloperCourse(@PathVariable("id") Integer id) {
        teacherDeveloperCourseServiceImpl.remove(id);
    }

    @GetMapping(value = "/get/teacher/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDeveloperCourseDTO findByTeacherId(@PathVariable("teacherId") Integer teacherId) {
        return teacherDeveloperCourseServiceImpl.findByTeacherId(teacherId);
    }
    //    Added GetMapping for findByCourseIdAndTeacherId()
    @GetMapping(value = "/get/course/{courseId}/teacher/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDeveloperCourseDTO findByCourseIdAndTeacherId(@PathVariable("courseId") Integer courseId, @PathVariable("teacherId") Integer teacherId) {
        return teacherDeveloperCourseServiceImpl.findByDeveloperCourseIdAndTeacherId(courseId, teacherId);
    }
}
