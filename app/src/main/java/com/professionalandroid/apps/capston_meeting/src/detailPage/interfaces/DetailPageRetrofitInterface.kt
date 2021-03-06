package com.professionalandroid.apps.capston_meeting.src.detailPage.interfaces

import com.professionalandroid.apps.capston_meeting.src.detailPage.models.ApplyBody
import com.professionalandroid.apps.capston_meeting.src.detailPage.models.ApplyResponse
import com.professionalandroid.apps.capston_meeting.src.detailPage.models.DetailResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DetailPageRetrofitInterface {
    @GET("/api/boards/{boardId}/{userId}/")
    fun getDetail(
        @Path("boardId") boardId: Long,
        @Path("userId") userId: Long
    ): Call<DetailResponse>

    @POST("api/match")
    fun apply(
        @Body applyBody: ApplyBody
    ): Call<ApplyResponse>

}