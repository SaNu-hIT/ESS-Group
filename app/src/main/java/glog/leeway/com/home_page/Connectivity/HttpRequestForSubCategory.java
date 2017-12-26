package glog.leeway.com.home_page.Connectivity;

import android.util.Log;

import java.util.List;

import glog.leeway.com.home_page.Interfaces.OnHttpResponceForSubCategory;
import glog.leeway.com.home_page.Models.SubCat.Jobinfo;
import glog.leeway.com.home_page.Models.SubCat.Status;
import glog.leeway.com.home_page.Models.SubCat.SubCate;
import glog.leeway.com.home_page.Rest.ApiClient;
import glog.leeway.com.home_page.Rest.ApiInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class HttpRequestForSubCategory {
    private static final String TAG = HttpRequestForSubCategory.class.getSimpleName();
    OnHttpResponceForSubCategory onHttpResponceForCategory;



    public HttpRequestForSubCategory(OnHttpResponceForSubCategory onHttpResponceForCategory) {
        this.onHttpResponceForCategory = onHttpResponceForCategory;
    }


    public void getSubCategory(String sub) {

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<SubCate> call = apiInterfaces.getSubCategory(sub);
        call.enqueue(new Callback<SubCate>() {
            @Override
            public void onResponse(Call<SubCate> call, Response<SubCate> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    Status status = response.body().getStatus();

                    String stas=status.getCode().toString();
                    Log.e(TAG, "onResponse: "+status);
                    String userid;

                    if (stas.equals("200")) {
                    List<Jobinfo> categoryinfo=response.body().getJobinfo();


                        onHttpResponceForCategory.OnSubCategorySuccess("Success",false,categoryinfo);








                    } else {
                        onHttpResponceForCategory.OnSubCategoryFaild("Login Faild");
                    }
                }
                else
                {
                    onHttpResponceForCategory.OnSubCategoryFaild("Check Network ");


                }

            }

            @Override
            public void onFailure(Call<SubCate> call, Throwable t) {

                onHttpResponceForCategory.OnSubCategoryFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }
}
