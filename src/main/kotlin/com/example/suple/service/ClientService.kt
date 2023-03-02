package com.example.suple.service

import com.example.suple.model.Client
import com.example.suple.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ClientService {

    @Autowired
    lateinit var clientRepository: ClientRepository


    fun list():List<Client>{
        return clientRepository.findAll()
    }

  fun listById (id: Long?): Client?{
    return clientRepository.findById(id)
  }

  fun findCsI(): List<Client> {
    return clientRepository.findCsI()
  }


    fun save(client:Client):Client {
      try {
        client.fullname?.takeIf { it.trim().isNotEmpty() }
          ?: throw Exception("fullname no debe ser vacio")

        return clientRepository.save(client)
      }
      catch(ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
      }
    }
}
