package com.professionalandroid.apps.capston_meeting.src.detailPage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.professionalandroid.apps.capston_meeting.MainActivity
import com.professionalandroid.apps.capston_meeting.MainActivity.Companion.user
import com.professionalandroid.apps.capston_meeting.R
import com.professionalandroid.apps.capston_meeting.retrofit.ConnectRetrofit
import com.professionalandroid.apps.capston_meeting.retrofit.board
import com.professionalandroid.apps.capston_meeting.src.detailPage.interfaces.DetailPageView
import com.professionalandroid.apps.capston_meeting.src.detailPage.models.DetailResponse
import kotlinx.android.synthetic.main.fragment_detail_page.*
import kotlinx.android.synthetic.main.fragment_detail_page.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPage : Fragment(), DetailPageView {

    lateinit var mDetailPageService: DetailPageService

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mDetailPageService = DetailPageService(this, context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_page, container, false)

        // 전 fragment에서 데이터가 넘어왔는지 확인
        if(arguments != null){
            val boardId = arguments?.getLong("href", 0)
            mDetailPageService.getDetail(user, boardId!!)

        }
        return view
    }

    override fun getDetail(body: DetailResponse) {
        detail_title.text = body.title
        detail_tag1.text = body.tag1
        detail_tag2.text = body.tag2
        detail_tag3.text = body.tag3
        detail_location.text = body.location1
        detail_num_type.text = body.num_type

        (activity as MainActivity).displayImg(context!!, body.img1 ,detail_img1)
        (activity as MainActivity).displayImg(context!!, body.img2 ,detail_img2)
        (activity as MainActivity).displayImg(context!!, body.img3 ,detail_img3)

    }

}