package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.repository.impl.WorkerRepository
import org.springframework.stereotype.Service

@Service
class WorkerServiceImpl(
    private val workerRepository: WorkerRepository
): DefaultServiceImpl<Worker, WorkerRepository>(workerRepository)