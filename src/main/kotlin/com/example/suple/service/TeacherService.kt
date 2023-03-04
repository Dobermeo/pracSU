package com.example.suple.service

import com.example.suple.model.Teacher
import com.example.suple.repository.TeacherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class TeacherService {

    @Autowired
    lateinit var teacherRepository: TeacherRepository


    fun list():List<Teacher>{
        return teacherRepository.findAll()
    }

  fun listById (id: Long?): Teacher?{
    return teacherRepository.findById(id)
  }

  fun findCsI(): List<Teacher> {
    return teacherRepository.findCsI()
  }


    fun save(teacher:Teacher):Teacher {
      try {
        teacher.fullname?.takeIf { it.trim().isNotEmpty() }
          ?: throw Exception("fullname no debe ser vacio")

        return teacherRepository.save(teacher)
      }
      catch(ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
      }
    }


}
