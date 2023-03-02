package com.example.suple.service

import com.example.suple.model.Client
import com.example.suple.repository.ClientRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ClientServiceTest {

  @InjectMocks
  lateinit var clientService: ClientService

  @Mock
  lateinit var  clientRepository: ClientRepository

  var clientMock = Client().apply{
    id=1
    fullname="David Bermeo"
    email="dobermeo@sudamericano.edu.ec"
  }

  @Test
  fun validationemail(){
    Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
    clientMock.email?.contains("@")?.let { Assertions.assertTrue(it) }
    val response = clientService.save(clientMock)
    Assertions.assertEquals(response?.id, clientMock.id)
  }
}


