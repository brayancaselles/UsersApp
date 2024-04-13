package com.brayandev.users_gse.domain.useCase

import com.brayandev.users_gse.data.repository.UserRepository
import com.brayandev.users_gse.domain.model.AddressModel
import com.brayandev.users_gse.domain.model.CompanyModel
import com.brayandev.users_gse.domain.model.GeoModel
import com.brayandev.users_gse.domain.model.UserItemModel
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verifyBlocking
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class RequestUsersUseCaseTest {

    @Mock
    private lateinit var repository: UserRepository

    private lateinit var useCase: RequestUsersUseCase

    private val users = emptyList<UserItemModel>()

    @Before
    fun setUp() {
        useCase = RequestUsersUseCase(repository)
    }

    @Test
    fun `verify requestUsers is called when RequestUsersUseCase is invoked`() {

        runBlocking { useCase.invoke() }

        verifyBlocking(repository) { requestUsers() }
    }

    @Test
    fun `when RequestUsersUseCase is invoked should return empty list of UserItemModel `() = runBlocking {
        whenever(repository.requestUsers()).thenReturn(users)

        val userList = useCase.invoke()

        TestCase.assertEquals(users, userList)
    }

    @Test
    fun `when RequestUsersUseCase is invoked should return list of UserItemModel `() = runBlocking {
        val listUsers: List<UserItemModel> = listOf(
            UserItemModel(
                AddressModel(
                    "castilla",
                    GeoModel("adas", "adasd"),
                    "casi",
                    "nel",
                    "124554522",
                ),
                CompanyModel("das", "asdaasd244 444", "Wos"),
                "adasdqa@adssad.com",
                15,
                "Jose",
                "348774154",
                "josesito",
                "josesito.com",
            ),
        )
        whenever(repository.requestUsers()).thenReturn(listUsers)

        val userList = useCase.invoke()

        TestCase.assertEquals(listUsers, userList)
    }
}
