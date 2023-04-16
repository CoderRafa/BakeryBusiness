package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.repository.impl.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl(
    private val clientRepository: ClientRepository
): DefaultServiceImpl<Client, ClientRepository>(clientRepository)