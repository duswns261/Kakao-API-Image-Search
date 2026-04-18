import com.cret.kakaoimagesearch.BuildConfig
import com.cret.kakaoimagesearch.Constants
import com.cret.kakaoimagesearch.model.SearchNetworkResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageSearchRequestApi {

//    @Headers("Authorization: KakaoAK ${Constants.REST_API_KEY}")
    @Headers("Authorization: KakaoAK ${BuildConfig.KAKAO_API_KEY}")
    @GET("v2/search/image")
    fun getSearchImage(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<SearchNetworkResponse>
}