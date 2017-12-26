package glog.leeway.com.home_page.Connectivity;

import android.util.Log;

import java.util.List;

import glog.leeway.com.home_page.Interfaces.OnHttpResponceForCategory;
import glog.leeway.com.home_page.Models.CategoryMode.CategorModel;
import glog.leeway.com.home_page.Models.CategoryMode.Categoryinfo;
import glog.leeway.com.home_page.Models.CategoryMode.Status;
import glog.leeway.com.home_page.Rest.ApiClient;
import glog.leeway.com.home_page.Rest.ApiInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class HttpRequestForCategory {
    private static final String TAG = HttpRequestForCategory.class.getSimpleName();
    OnHttpResponceForCategory onHttpResponceForCategory;



    public HttpRequestForCategory(OnHttpResponceForCategory onHttpResponceForCategory) {
        this.onHttpResponceForCategory = onHttpResponceForCategory;
    }


    public void AttemtToLogin() {

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<CategorModel> call = apiInterfaces.getCategory();
        call.enqueue(new Callback<CategorModel>() {
            @Override
            public void onResponse(Call<CategorModel> call, Response<CategorModel> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    Status status = response.body().getStatus();

                    String stas=status.getCode().toString();
                    Log.e(TAG, "onResponse: "+status);
                    String userid;

                    if (stas.equals("200")) {
                    List<Categoryinfo> categoryinfo=response.body().getCategoryinfo();

                        Log.e(TAG, "onResponse: "+categoryinfo.size() );
//                        onHttpResponceForCategory.OnCategorySuccess("Success",false,categoryinfo);

                        onHttpResponceForCategory.OnCategorySuccess("success",false,categoryinfo);







                    } else {
                        onHttpResponceForCategory.OnCategoryFaild("Login Faild");
                    }
                }
                else
                {
                    onHttpResponceForCategory.OnCategoryFaild("Check Network ");


                }

            }

            @Override
            public void onFailure(Call<CategorModel> call, Throwable t) {

                onHttpResponceForCategory.OnCategoryFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }
}
