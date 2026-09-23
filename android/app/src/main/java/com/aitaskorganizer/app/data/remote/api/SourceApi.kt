package com.aitaskorganizer.app.data.remote.api

import com.aitaskorganizer.app.data.remote.dto.AnalysisResultDto
import com.aitaskorganizer.app.data.remote.dto.SourceDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface SourceApi {
    @POST("sources/")
    @Multipart
    suspend fun createSource(
        @Query("type") type: String,
        @Part file: MultipartBody.Part? = null,
        @Part("text") text: RequestBody? = null
    ): SourceDto

    @GET("sources/")
    suspend fun getSources(): List<SourceDto>

    @GET("sources/{id}")
    suspend fun getSource(@Path("id") id: Long): SourceDto

    @POST("analyze/{sourceId}")
    suspend fun analyzeSource(@Path("sourceId") sourceId: Long): AnalysisResultDto
}
