package com.example.suple.controller

import com.example.suple.model.Invoice
import com.example.suple.model.InvoiceView
import com.example.suple.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/invoice")
class InvoiceController {

    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list():List<Invoice>{
        return invoiceService.list()
    }

  @GetMapping("/{id}")
  fun listById (@PathVariable("id") id: Long):ResponseEntity<Invoice>{
    return ResponseEntity(invoiceService.listById(id), HttpStatus.OK)
  }

  @GetMapping("/with/client")
  fun listWithClient (): ResponseEntity<List<InvoiceView>> {
    return ResponseEntity(invoiceService.listWithClient(), HttpStatus.OK)
  }

    @PostMapping
    fun save (@RequestBody @Valid invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }


}
