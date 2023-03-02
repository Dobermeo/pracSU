package com.example.suple.repository

import com.example.suple.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: JpaRepository <Client, Long> {

    fun findById(id: Long?):Client?

  @Query(value = "SELECT c FROM Client c WHERE NOT EXISTS (SELECT 1 FROM Invoice i WHERE i.clientId = c.id)")
  fun findCsI(): List<Client>
}
