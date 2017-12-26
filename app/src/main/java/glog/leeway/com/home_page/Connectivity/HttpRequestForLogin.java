package glog.leeway.com.home_page.Connectivity;

import android.util.Log;

import glog.leeway.com.home_page.Interfaces.OnHttpResponceForLogin;
import glog.leeway.com.home_page.Models.LoginModel;
import glog.leeway.com.home_page.Models.Status;
import glog.leeway.com.home_page.Models.Userinfo;
import glog.leeway.com.home_page.Rest.ApiClient;
import glog.leeway.com.home_page.Rest.ApiInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class HttpRequestForLogin {
    private static final String TAG = HttpRequestForLogin.class.getSimpleName();
    OnHttpResponceForLogin onHttpResponceForLogin;



    public HttpRequestForLogin(OnHttpResponceForLogin onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }


    public void AttemtToLogin(final String username, final String password) {

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<LoginModel> call = apiInterfaces.loginUser(username, password);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    Status status = response.body().getStatus();

                    String stas=status.getCode().toString();
                    Log.e(TAG, "onResponse: "+status);
                    String userid;

                    if (stas.equals("200")) {

                       Userinfo userInfo=response.body().getUserinfo();


                        onHttpResponceForLogin.OnLoginSuccess("Success",false,userInfo);








                    } else {
                        onHttpResponceForLogin.OnLoginFaild("Login Faild");
                    }
                }
                else
                {
                    onHttpResponceForLogin.OnLoginFaild("Check Network ");


                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                onHttpResponceForLogin.OnLoginFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }
}
