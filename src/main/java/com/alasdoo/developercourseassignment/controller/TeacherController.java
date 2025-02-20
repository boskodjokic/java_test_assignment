package com.alasdoo.developercourseassignment.controller;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {

    /*
    Added 2 methods to teacher controller, deleteTeacher and updateTeacher
     */

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping(value = "/getTeacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO selectTeacher(@PathVariable("id") Integer id) {
        return teacherServiceImpl.findOne(id);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeacherDTO> getAllTeachers() {
        return teacherServiceImpl.findAll();
    }

    @PostMapping(value = "/addTeacher", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherServiceImpl.save(teacherDTO);
    }

//    added delete method to teacher controller
    @DeleteMapping(value = "/delete/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeacher(@PathVariable("id") Integer id) {
        teacherServiceImpl.remove(id);
    }

//    added update method to teacher controller
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO updateTeacher(@PathVariable("id") Integer id, @RequestBody TeacherDTO teacherDTO) {
        return teacherServiceImpl.update(id, teacherDTO);
    }

    @GetMapping(value = "/get/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO findByEmail(@PathVariable("email") String email) {
        return teacherServiceImpl.findByTeacherEmail(email);
    }

    @GetMapping(value = "/get/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDTO findByNameAndSurname(@PathVariable("name") String name, @PathVariable("surname") String surname) {
        return teacherServiceImpl.findByTeacherNameAndTeacherSurname(name, surname);
    }

}
