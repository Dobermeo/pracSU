package com.example.suple.controller

import com.example.suple.model.Teacher
import com.example.suple.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/teacher")
class TeacherController {

    @Autowired
    lateinit var teacherService: TeacherService

    @GetMapping
    fun list():List<Teacher>{
        return teacherService.list()
    }

  @GetMapping("/{id}")
  fun listById (@PathVariable("id") id: Long):ResponseEntity<Teacher>{
    return ResponseEntity(teacherService.listById(id), HttpStatus.OK)
  }

  @GetMapping("/without-subject")
  fun findCsI(): ResponseEntity<List<Teacher>> {
    val teachers = teacherService.findCsI()
    return ResponseEntity.ok(teachers)
  }

    @PostMapping
    fun save (@RequestBody @Valid teacher:Teacher):ResponseEntity<Teacher>{
        return ResponseEntity(teacherService.save(teacher), HttpStatus.OK)
    }
}
