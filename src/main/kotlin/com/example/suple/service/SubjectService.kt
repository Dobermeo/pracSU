package com.example.suple.service

import com.example.suple.model.Subject
import com.example.suple.model.SubjectView
import com.example.suple.repository.TeacherRepository
import com.example.suple.repository.SubjectRepository
import com.example.suple.repository.SubjectViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.text.SimpleDateFormat


@Service
class SubjectService {

  @Autowired
  lateinit var subjectRepository: SubjectRepository

  @Autowired
  lateinit var subjectViewRepository: SubjectViewRepository

  @Autowired
  lateinit var teacherRepository: TeacherRepository

  fun list(): List<Subject> {
    return subjectRepository.findAll()
  }

  fun listById (id: Long?): Subject?{
    return subjectRepository.findById(id)
  }

  fun listWithTeacher(): List<SubjectView> {
    return subjectViewRepository.findAll()
  }


  fun save(subject: Subject): Subject {
    try {

      teacherRepository.findById(subject.teacherId)
        ?: throw Exception("Id del cliente no encontrada")
      return subjectRepository.save(subject)
    } catch (ex: Exception) {
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex
      )
    }
  }

}


