package com.rafeng.bakery.improve.business.service.general

import com.rafeng.bakery.improve.business.model.Receipt
import com.rafeng.bakery.improve.business.repository.impl.ReceiptRepository
import com.rafeng.bakery.improve.business.service.general.DefaultServiceImpl
import org.springframework.stereotype.Service

@Service
class ReceiptServiceImpl(
    private val receiptRepository: ReceiptRepository
): DefaultServiceImpl<Receipt, ReceiptRepository>(receiptRepository)