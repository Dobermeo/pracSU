package com.example.suple.repository

import com.example.suple.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository: JpaRepository <Teacher, Long> {

    fun findById(id: Long?):Teacher?

  @Query(value = "SELECT t FROM Teacher t WHERE NOT EXISTS (SELECT 1 FROM Subject s WHERE s.teacherId = t.id)")
  fun findCsI(): List<Teacher>
}
