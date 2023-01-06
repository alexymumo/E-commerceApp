package com.example.ecommerce.data.repository

import com.example.ecommerce.data.remote.api.FakeStoreApi
import com.example.ecommerce.data.remote.dto.ProductDto
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val fakeStoreApi: FakeStoreApi): ProductRepository {
    override suspend fun getProducts(): List<ProductDto> {
        return fakeStoreApi.getProducts()
    }
}

/*
override suspend fun getProducts(): Flow<NetworkResult<List<Product>>> = flow {
    emit(NetworkResult.Loading(true))


    try {
        val product = apiService.getProducts()
        emit(NetworkResult.Success(product))
    } catch (e: IOException) {
        emit(NetworkResult.Failure(errorMessage = "Error occurred"))
    } catch (e: HttpException) {
        emit(NetworkResult.Failure(errorMessage = "Something went wrong"))
    }
}

 */