package com.example.suple.controller

import com.example.suple.model.Client
import com.example.suple.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/client")
class ClientController {

    @Autowired
    lateinit var clientService: ClientService

    @GetMapping
    fun list():List<Client>{
        return clientService.list()
    }

  @GetMapping("/{id}")
  fun listById (@PathVariable("id") id: Long):ResponseEntity<Client>{
    return ResponseEntity(clientService.listById(id), HttpStatus.OK)
  }

  @GetMapping("/without-invoice")
  fun findCsI(): ResponseEntity<List<Client>> {
    val clients = clientService.findCsI()
    return ResponseEntity.ok(clients)
  }

    @PostMapping
    fun save (@RequestBody @Valid client:Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.save(client), HttpStatus.OK)
    }
}
