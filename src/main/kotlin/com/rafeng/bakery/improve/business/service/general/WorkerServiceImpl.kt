package com.rafeng.bakery.improve.business.service.general

import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.repository.impl.WorkerRepository
import com.rafeng.bakery.improve.business.service.general.DefaultServiceImpl
import org.springframework.stereotype.Service

@Service
class WorkerServiceImpl(
    private val workerRepository: WorkerRepository
): DefaultServiceImpl<Worker, WorkerRepository>(workerRepository)