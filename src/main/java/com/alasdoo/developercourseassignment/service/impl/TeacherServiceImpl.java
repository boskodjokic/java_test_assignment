package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl {

    /*
    Implemented methods for TeacherServiceImpl.
     */

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

//    method for finding one teacher by id
    public TeacherDTO findOne(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(!teacher.isPresent()) {
            throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

//    getting a list of teachers
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(i -> teacherMapper.transformToDTO(i)).collect(Collectors.toList());
    }

//    saving a new teacher
    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
        return teacherMapper.transformToDTO(teacherRepository.save(teacher));
    }

//    removing a teacher by id
    public void remove(Integer id) throws IllegalArgumentException {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(!teacher.isPresent()) {
            throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found");
        }
        teacherRepository.deleteById(id);
    }

//    updating teacher with new values
    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
        Optional<Teacher> oldTeacher = teacherRepository.findById(id);
        if(!oldTeacher.isPresent()) {
            throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found");
        }
        oldTeacher.get().setTeacherName(teacherDTO.getTeacherName());
        oldTeacher.get().setTeacherSurname(teacherDTO.getTeacherSurname());
        oldTeacher.get().setTeacherEmail(teacherDTO.getTeacherEmail());

        teacherRepository.save(oldTeacher.get());

        return teacherMapper.transformToDTO(oldTeacher.get());
    }
//    find a teacher by name and surname combination
    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherNameAndTeacherSurname(name, surname);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                    ("Teacher with the provided name and surname combination is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

//    finding a teacher by email
    public TeacherDTO findByTeacherEmail(String email) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherEmail(email);

        if(!teacher.isPresent()) {
            throw new IllegalArgumentException("Teacher with the following email = " + email + " is not found.");
        }

        return teacherMapper.transformToDTO(teacher.get());
    }
}
