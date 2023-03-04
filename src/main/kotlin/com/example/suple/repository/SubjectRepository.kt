package com.example.suple.repository

import com.example.suple.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository: JpaRepository <Subject, Long> {

    fun findById(id: Long?):Subject?
}
