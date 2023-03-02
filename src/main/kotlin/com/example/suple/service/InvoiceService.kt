package com.example.suple.service

import com.example.suple.model.Invoice
import com.example.suple.model.InvoiceView
import com.example.suple.repository.ClientRepository
import com.example.suple.repository.InvoiceRepository
import com.example.suple.repository.InvoiceViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.text.SimpleDateFormat


@Service
class InvoiceService {

  @Autowired
  lateinit var invoiceRepository: InvoiceRepository

  @Autowired
  lateinit var invoiceViewRepository: InvoiceViewRepository

  @Autowired
  lateinit var clientRepository: ClientRepository

  fun list(): List<Invoice> {
    return invoiceRepository.findAll()
  }

  fun listById (id: Long?): Invoice?{
    return invoiceRepository.findById(id)
  }

  fun listWithClient(): List<InvoiceView> {
    return invoiceViewRepository.findAll()
  }


  fun save(invoice: Invoice): Invoice {
    try {

      val dateFormat = SimpleDateFormat("yyyy-MM-dd")
      val formattedDate = dateFormat.format(invoice.fecha)
      invoice.fecha = dateFormat.parse(formattedDate)
      return invoiceRepository.save(invoice)

      clientRepository.findById(invoice.clientId)
        ?: throw Exception("Id del cliente no encontrada")
      return invoiceRepository.save(invoice)
    } catch (ex: Exception) {
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex
      )
    }
  }

}


