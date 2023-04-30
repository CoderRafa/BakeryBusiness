package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.model.dto.Worker
import org.springframework.stereotype.Component
import javax.swing.SwingWorker

@Component
data class WorkerRepository (
    private val workers: MutableSet<Worker> = mutableSetOf()
): DefaultRepositoryImpl<Worker>(workers)

