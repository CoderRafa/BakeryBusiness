package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.Receipt
import com.rafeng.bakery.improve.business.service.impl.ReceiptServiceImpl
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/receipt")
class ReceiptController(val receiptServiceImpl: ReceiptServiceImpl) {

    @PostMapping
    fun addReceiptToRepository(@RequestBody receipt: Receipt) {
        receiptServiceImpl.addItem(receipt)
    }

    @DeleteMapping
    fun deleteReceiptFromRepository(deleteReceiptRequest: Receipt) {
        receiptServiceImpl.deleteItem(deleteReceiptRequest)
    }

    @GetMapping
    fun getAllReceiptsFromRepository(): List<Receipt> {
        return  receiptServiceImpl.getAll()
    }
}