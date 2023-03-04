package com.example.suple.controller

import com.example.suple.model.Subject
import com.example.suple.model.SubjectView
import com.example.suple.service.SubjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/subject")
class SubjectController {

    @Autowired
    lateinit var subjectService: SubjectService

    @GetMapping
    fun list():List<Subject>{
        return subjectService.list()
    }

  @GetMapping("/{id}")
  fun listById (@PathVariable("id") id: Long):ResponseEntity<Subject>{
    return ResponseEntity(subjectService.listById(id), HttpStatus.OK)
  }

  @GetMapping("/with/teacher")
  fun listWithTeacher (): ResponseEntity<List<SubjectView>> {
    return ResponseEntity(subjectService.listWithTeacher(), HttpStatus.OK)
  }

    @PostMapping
    fun save (@RequestBody @Valid subject:Subject):ResponseEntity<Subject>{
        return ResponseEntity(subjectService.save(subject), HttpStatus.OK)
    }


}
