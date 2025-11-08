package com.cret.kakaoimagesearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cret.kakaoimagesearch.databinding.FragmentSearchBinding
import com.cret.kakaoimagesearch.model.SearchNetworkResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(ImageSearchRequestApi::class.java)
        retrofitService.getSearchImage(
            query = "${binding.etSearchContent.text}",
            sort = "accuracy",
            page = 1,
            size = 20
        ).enqueue(object : retrofit2.Callback<SearchNetworkResponse> {
            override fun onResponse(
                call: Call<SearchNetworkResponse?>,
                response: Response<SearchNetworkResponse?>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@SearchFragment.context, "데이터 로딩 성공", Toast.LENGTH_SHORT).show()

                    val response = response.body()

                } else {
                    Toast.makeText(this@SearchFragment.context, "데이터 로딩 실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                call: Call<SearchNetworkResponse?>,
                t: Throwable
            ) {
                t.printStackTrace()
                Toast.makeText(this@SearchFragment.context, "데이터 로딩 실패", Toast.LENGTH_SHORT).show()
            }
        })
    }


}