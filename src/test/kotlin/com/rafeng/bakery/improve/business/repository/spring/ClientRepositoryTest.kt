package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.ClientEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@SpringBootTest(classes = [LiquibaseH2TestConfig::class])
class ClientRepositoryTest @Autowired constructor(
    val clientEntityRepository: ClientEntityRepository
) {

    @Order(1)
    @Test
    fun `Happy pass - add a new client to DB`() {
        val clientEntity = createClientEntity()

        clientEntityRepository.save(clientEntity)

        checkNewClientEntityFields(clientEntity)
        checkNewClientEntityFields(clientEntityRepository.findById(clientEntity.id!!).get())
    }


    private fun createClientEntity(): ClientEntity {
        return ClientEntity().apply {
            this.name = "Vasiliy"
            this.lastname = "Ivanov"
            this.phoneNumber = "+794585987584"
        }
    }
    private fun checkNewClientEntityFields(clientEntity: ClientEntity) {
        assertThat(clientEntity.id).isNotNull()
        assertThat(clientEntity.name).isEqualTo("Vasiliy")
        assertThat(clientEntity.lastname).isNotNull()
        assertThat(clientEntity.phoneNumber).isNotNull()
    }

    @Order(2)
    @Test
    fun `Happy pass - find all clients in DB`() {
        val clientEntities = clientEntityRepository.findAll()
        assertThat(clientEntities).isNotEmpty
    }

    @Order(3)
    @Test
    fun `Happy pass - a client was deleted from DB`() {
        val clientEntity = createClientEntity()
        checkNewClientEntityFields(clientEntityRepository.save(clientEntity))

        clientEntityRepository.deleteById(clientEntity.id!!)
        assertThat(clientEntityRepository.findById(clientEntity.id!!)).isEmpty

        assertThat(clientEntityRepository.findAll()).isEmpty()
    }
}