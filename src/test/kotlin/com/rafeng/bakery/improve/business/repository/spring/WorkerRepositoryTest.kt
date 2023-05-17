package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.dto.Position.*
import com.rafeng.bakery.improve.business.model.entity.WorkerEntity
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles("h2")
@SpringBootTest(classes = [LiquibaseH2TestConfig::class])
class WorkerRepositoryTest @Autowired constructor(
    val workerEntityRepository: WorkerEntityRepository
) {
    @Test
    @Order(1)
    fun `Happy pass - add a new worker to DB`() {
        val workerEntity = createWorkerEntity()
        workerEntityRepository.save(workerEntity)
    }

    private fun createWorkerEntity(): WorkerEntity {
        return WorkerEntity().apply {
            this.name = "Lena"
            this.lastname = "Petrova"
            this.position = SALESPERSON
        }
    }

}