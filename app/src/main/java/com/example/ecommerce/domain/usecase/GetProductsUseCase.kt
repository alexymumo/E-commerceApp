package com.example.ecommerce.domain.usecase

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.remote.dto.toProduct
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {


    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = productRepository.getProducts().map { it.toProduct() }
            emit(Resource.Success(data = products))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach the server"))
        }
    }
}