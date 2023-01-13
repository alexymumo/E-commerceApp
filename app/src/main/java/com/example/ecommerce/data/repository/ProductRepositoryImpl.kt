package com.example.ecommerce.data.repository

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.cache.dao.ProductDao
import com.example.ecommerce.data.cache.mappers.toDomain
import com.example.ecommerce.data.cache.mappers.toEntity
import com.example.ecommerce.data.remote.api.FakeStoreApi
import com.example.ecommerce.data.remote.dto.ProductDto
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val fakeStoreApi: FakeStoreApi,
    private val productsDao: ProductDao): ProductRepository {

    override suspend fun getProducts(): List<ProductDto> {
        return fakeStoreApi.getProducts()
    }

    override suspend fun fetchProducts(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        val getProductsFromDb = productsDao.getProducts().map { it.toDomain() }
        Resource.Loading(data = getProductsFromDb)

        try {
            val apiResponse = fakeStoreApi.getProducts()
            productsDao.deleteProducts()
            productsDao.saveProducts(apiResponse.map { it.toEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Network connection"))
        }

        val products = productsDao.getProducts().map { it.toDomain() }
        emit(Resource.Success(products))
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