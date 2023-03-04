package com.example.suple.repository

import com.example.suple.model.SubjectView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectViewRepository: JpaRepository <SubjectView, Long> {

    fun findById(id: Long?):SubjectView?
}
