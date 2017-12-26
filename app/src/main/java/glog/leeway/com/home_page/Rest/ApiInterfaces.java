package glog.leeway.com.home_page.Rest;


import glog.leeway.com.home_page.Models.CategoryMode.CategorModel;
import glog.leeway.com.home_page.Models.LoginModel;
import glog.leeway.com.home_page.Models.NewModels.ListAllDetails;
import glog.leeway.com.home_page.Models.SendJson.JsonSendOrder;
import glog.leeway.com.home_page.Models.SendJsonsRespo.StatusForSend;
import glog.leeway.com.home_page.Models.SubCat.SubCate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface ApiInterfaces {

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginModel> loginUser(@Field("username") String uername, @Field("password") String passoword);


    @POST("create_orders")
    Call<StatusForSend> PlaceOrder(@Body JsonSendOrder data);






    @POST("listproductcategory")
    Call<CategorModel> getCategory();
    @FormUrlEncoded
  @POST("getsubcatbyid")
    Call<SubCate> getSubCategory(@Field("category_id") String category_id);




//    @POST("listorders")
//    Call<ListModel> ListInvoice();
    @FormUrlEncoded
    @POST("getorderid")
    Call<ListAllDetails> ListInvoice(@Field("key") String key);

}
