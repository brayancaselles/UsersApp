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
class RequestUserDetailUseCaseTest {
    @Mock
    private lateinit var repository: UserRepository

    private lateinit var useCase: RequestUserDetailUseCase

    private val user = UserItemModel(
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
    )

    private val userId = 1

    @Before
    fun setup() {
        useCase = RequestUserDetailUseCase(repository)
    }

    @Test
    fun `verify requestUserDetail is called when RequestUserDetailUseCase is invoked`() {

        runBlocking { useCase.invoke(userId) }

        verifyBlocking(repository) { requestUserDetail(userId) }
    }

    @Test
    fun `when RequestUserDetailUseCase is invoked should return UserItemModel `() = runBlocking {
        whenever(repository.requestUserDetail(userId)).thenReturn(user)

        val userTest = useCase.invoke(userId)

        TestCase.assertEquals(user, userTest)
    }
}
