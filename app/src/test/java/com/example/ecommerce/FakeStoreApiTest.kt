package com.example.ecommerce

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.example.ecommerce.data.remote.api.FakeStoreApi
import com.example.ecommerce.data.remote.dto.ProductDto
import com.example.ecommerce.data.remote.dto.RatingDto
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.io.InputStream

class FakeStoreApiTest {
    lateinit var mockWebServer: MockWebServer
    lateinit var fakeStoreApi : FakeStoreApi
    private var context: Context? = null


    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        mockWebServer.start()
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        context = InstrumentationRegistry.getInstrumentation().targetContext

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()


        val contentType = "application/json".toMediaType()
        val contentConverter = Json.asConverterFactory(contentType)

        fakeStoreApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(contentConverter)
            .client(client)
            .build()
            .create(FakeStoreApi::class.java)

        val rating = RatingDto(
            12, 23.3
        )
        val products = ProductDto(
            "jewellery", "Good", 1, "good", 23.9, rating, "good"
        )

        val fakeResponse = MockResponse()
            .setResponseCode(200)
            .setBody(Gson().toJson(products))
        mockWebServer.enqueue(fakeResponse)
    }

    @Test
    fun `test api returns status code 200`() = runBlocking {
        val apiResponse = fakeStoreApi.getProducts()
        assertThat(apiResponse).hasSize(1)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}