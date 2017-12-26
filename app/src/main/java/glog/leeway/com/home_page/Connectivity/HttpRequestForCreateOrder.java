package glog.leeway.com.home_page.Connectivity;

import android.util.Log;

import glog.leeway.com.home_page.Interfaces.OnHttpResponceForCreateOrder;
import glog.leeway.com.home_page.Models.SendJson.JsonSendOrder;
import glog.leeway.com.home_page.Models.SendJsonsRespo.StatusForSend;
import glog.leeway.com.home_page.Rest.ApiClient;
import glog.leeway.com.home_page.Rest.ApiInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class HttpRequestForCreateOrder {
    private static final String TAG = HttpRequestForCreateOrder.class.getSimpleName();
    OnHttpResponceForCreateOrder onHttpResponceForLogin;



    public HttpRequestForCreateOrder( OnHttpResponceForCreateOrder onHttpResponceForLogin) {
        this.onHttpResponceForLogin = onHttpResponceForLogin;
    }


    public void PlaceOrder(JsonSendOrder josnsend) {


        Log.e(TAG, "PlaceOrder: "+josnsend.getOrders().get(0).getItemName() );
        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<StatusForSend> call = apiInterfaces.PlaceOrder(josnsend);
        call.enqueue(new Callback<StatusForSend>() {
            @Override
            public void onResponse(Call<StatusForSend> call, Response<StatusForSend> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {


                    String stas=response.body().getStatus().toString();
//                    Log.e(TAG, "onResponse: "+status);
                    Log.e(TAG, "stas: "+stas);
                    String userid;

                    if (stas.equals("200")) {


                        onHttpResponceForLogin.OnOrderSuccess("Success",false);

                    } else {
                        onHttpResponceForLogin.OnOrderFaild("Upload Faild");
                    }
                }
                else
                {
                    onHttpResponceForLogin.OnOrderFaild("Check Network ");
                }

            }

            @Override
            public void onFailure(Call<StatusForSend> call, Throwable t) {

                onHttpResponceForLogin.OnOrderFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }
}
