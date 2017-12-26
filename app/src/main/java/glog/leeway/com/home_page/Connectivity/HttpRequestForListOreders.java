package glog.leeway.com.home_page.Connectivity;

import android.util.Log;

import java.util.List;

import glog.leeway.com.home_page.Interfaces.OnHttpResponceForListItem;
import glog.leeway.com.home_page.Models.NewModels.Code;
import glog.leeway.com.home_page.Models.NewModels.ListAllDetails;
import glog.leeway.com.home_page.Models.NewModels.Orderslist;
import glog.leeway.com.home_page.Rest.ApiClient;
import glog.leeway.com.home_page.Rest.ApiInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class HttpRequestForListOreders {
    private static final String TAG = HttpRequestForListOreders.class.getSimpleName();
    OnHttpResponceForListItem onHttpResponceForCategory;



    public HttpRequestForListOreders(OnHttpResponceForListItem onHttpResponceForCategory) {
        this.onHttpResponceForCategory = onHttpResponceForCategory;
    }


    public void ListOrders(String key) {

        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        Call<ListAllDetails> call = apiInterfaces.ListInvoice(key);
        call.enqueue(new Callback<ListAllDetails>() {
            @Override
            public void onResponse(Call<ListAllDetails> call, Response<ListAllDetails> response)
            {
                String res=response.message();
                Log.e(TAG, "onResponse: "+res );

                if(res.equals("OK")) {
                    Code status = response.body().getCode();

                    String stas=status.getCode().toString();
                    Log.e(TAG, "onResponse: "+status);
                    Log.e(TAG, "onResponse: "+stas);
                    String userid;

                    if (stas.equals("200")) {
                    List<Orderslist> categoryinfo=response.body().getOrderslist();

                        Log.e(TAG, "onResponse: "+categoryinfo.size() );

                        onHttpResponceForCategory.OnListItemSuccess("success",false,categoryinfo);


                    } else {

                        Log.e(TAG, "onResponse: " +response.message() );
                        onHttpResponceForCategory.OnListItemFaild("Login Faild");
                    }
                }
                else
                {

                    Log.e(TAG, "onResponse: "+response.message() );
                    onHttpResponceForCategory.OnListItemFaild("Check Network ");


                }

            }

            @Override
            public void onFailure(Call<ListAllDetails> call, Throwable t) {

                onHttpResponceForCategory.OnListItemFaild(t);
                Log.e(TAG, "onHttpResponceForLogin:"+t.toString() );

            }
        });


    }
}
