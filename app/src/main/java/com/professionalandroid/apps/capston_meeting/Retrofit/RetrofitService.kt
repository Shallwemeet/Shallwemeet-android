package com.professionalandroid.apps.capston_meeting.retrofit

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.HashMap

interface RetrofitService {

    // 게시판 불러오기
    @GET("/api/boards")
    fun requestSearchBoard(
    ):Call<boards>

    @GET("/filter")
    fun requestSearchBoard2(
        @Query("location") location: String,
        @Query("num_type") num_type: String,
        @Query("age") age: String
    ):Call<List<board>>

    // 번호로 특정 게시판 불러오기
    @GET("/api/boards/{new_href}/")
    fun requestSearchSpecificBoard(
        @Path("new_href") new_href: String
    ): Call<board>

    // 로그인시 이메일 조회
    @GET("/api/users/login")
    fun checkhMyID(
        @Query("email") email: String
    ):Call<user3>

    // 유저 정보 조회
    @GET("api/users/{id}/")
    fun getuserId(
        @Path("id") id: String
    )

    //새로운 글 작성
    @Multipart
    @POST("/api/boards/upload")
    fun sendBoard(
        //인풋을 정의하는 곳
        @Part img1: MultipartBody.Part,
        @Part img2: MultipartBody.Part,
        @Part img3: MultipartBody.Part,
        //@Part("data") data: RequestBody

        @PartMap data: HashMap<String, RequestBody>
        //@Part data: ResponseBody
    ): Call<String>

    // 회원가입
    @Multipart
    @POST("/api/users/{id}/upload")
    fun registernewId(
        //@Part img: MultipartBody.Part,
        @PartMap data: HashMap<String, RequestBody>,
        @Path("id") id: String
    ): Call<user4>
}

