package com.professionalandroid.apps.capston_meeting.src.myInfoPage.models

data class MyInfoResponse (
    val idx: Long,
    val nickName: String,
    val img: String,
    val email: String,
    val gender: String,
    val age: String,
    val location1: String,
    val location2: String,
    val phone: String,
    val point: Int,
    val token: String
)
