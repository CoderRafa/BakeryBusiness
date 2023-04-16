package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.model.Receipt
import org.springframework.stereotype.Component

@Component
data class ReceiptRepository(
    private val receipt: MutableSet<Receipt> = mutableSetOf()
): DefaultRepositoryImpl<Receipt>(receipt)
