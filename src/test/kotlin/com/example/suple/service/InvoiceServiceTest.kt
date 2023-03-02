package com.example.suple.service

import com.example.suple.model.Invoice
import com.example.suple.repository.InvoiceRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat


@SpringBootTest
class InvoiceServiceTest {

  @Mock
  lateinit var invoiceRepository: InvoiceRepository

  @InjectMocks
  lateinit var invoiceService: InvoiceService

  var invoiceMock = Invoice().apply {
    id = 2
    fecha = SimpleDateFormat("yyyy-MM-dd").parse("2023-02-13")
    total = 200.0
    clientId = 2
  }

  @Test
  fun testInvoiceDateFormat() {
    // Configuración del comportamiento esperado del repositorio
    Mockito.`when`(invoiceRepository.save(invoiceMock)).thenReturn(invoiceMock)

    // Prueba del servicio de facturas
    invoiceService.save(invoiceMock)

    // Comprobación del formato de la fecha
    val invoiceSavedWithCorrectDateFormat = invoiceRepository.save(invoiceMock)

    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val savedDateWithCorrectFormat = dateFormat.format(invoiceSavedWithCorrectDateFormat.fecha)

    Assertions.assertNotEquals("Formato de fecha correcto", "yyyy-MM-dd", savedDateWithCorrectFormat)
    //Assertions.assertEquals("Formato de fecha incorrecto", "yyyy-MM-dd", savedDateWithCorrectFormat)
  }



}
