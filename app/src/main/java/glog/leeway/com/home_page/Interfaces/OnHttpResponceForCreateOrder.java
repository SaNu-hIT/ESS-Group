package glog.leeway.com.home_page.Interfaces;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface OnHttpResponceForCreateOrder {
    void OnOrderSuccess(String stautus, Boolean success);
    void OnOrderFaild(Throwable throwable);
    void OnOrderFaild(String S);

   // void OnLoginSuccessTrue(String success, boolean b, List<UserInfo> userInfo);
}
