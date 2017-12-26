package glog.leeway.com.home_page.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
//    public static final String BASE_URL="https://www.leewaylabs.com/ANDROID2/v1/";
    public static final String BASE_URL="https://www.essgroup.co.in/ANDROID2/v1/";
    public static Retrofit retrofit=null;
    public static Retrofit getClient()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
