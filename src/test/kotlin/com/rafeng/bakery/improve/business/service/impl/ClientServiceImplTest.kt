package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.repository.impl.ClientRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

//@ExtendWith(MockitoExtension::class)
//class ClientServiceImplTest {
//
//    @Mock
//    val clientRepository = ClientRepository()
//
//    @InjectMocks
//    val clientServiceImpl = ClientService(clientEntityRepository)
//
//    val client = Client(
//        name = "Valeriy",
//        lastname = "Ivanov",
//        phoneNumber = "+794565859845"
//    )
//    @Test
//    fun `Happy pass - add a client to repository`() {
//        assertTrue(clientServiceImpl.save(client))
//    }
//
//    @Test
//    fun `Negative pass - failed to add an existing client`() {
//        clientServiceImpl.save(client)
//        assertFalse(clientServiceImpl.addItem(client))
//    }
//
//    @Test
//    fun `Happy pass - get all clients`() {
//        clientServiceImpl.addItem(client)
//        assertEquals("Valeriy", clientServiceImpl.getAll()[0].name)
//    }
//
//    @Test
//    fun `Negative pass - get all with nothing to get`() {
//        clientServiceImpl.addItem(client)
//        clientServiceImpl.deleteItem(client)
//        assertFalse(clientServiceImpl.getAll().contains(client))
//    }
//
//    @Test
//    fun `Happy pass - delete a client`() {
//        clientServiceImpl.addItem(client)
//        assertEquals(1, clientServiceImpl.getAll().size)
//        assertTrue(clientServiceImpl.deleteItem(client))
//        assertEquals(0, clientServiceImpl.getAll().size)
//    }
//}

