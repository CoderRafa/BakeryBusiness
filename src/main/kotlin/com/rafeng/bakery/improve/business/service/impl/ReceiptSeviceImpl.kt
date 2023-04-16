package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Receipt
import com.rafeng.bakery.improve.business.repository.impl.ReceiptRepository
import org.springframework.stereotype.Service

@Service
class ReceiptServiceImpl(
    private val receiptRepository: ReceiptRepository
): DefaultServiceImpl<Receipt, ReceiptRepository>(receiptRepository)