package com.example.ecommerce.data.repository

import com.example.ecommerce.data.api.ApiService
import com.example.ecommerce.data.models.Product
import com.example.ecommerce.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService): ProductRepository {
    override suspend fun getProducts(): Flow<NetworkResult<List<Product>>> = flow {
        emit(NetworkResult.Loading(true))

        try {
            val product = apiService.getProducts()
            emit(NetworkResult.Success(product.products))
        } catch (e: IOException) {
            emit(NetworkResult.Failure(errorMessage = "Error occurred"))
        } catch (e: HttpException) {
            emit(NetworkResult.Failure(errorMessage = "Something went wrong"))
        }
    }

}