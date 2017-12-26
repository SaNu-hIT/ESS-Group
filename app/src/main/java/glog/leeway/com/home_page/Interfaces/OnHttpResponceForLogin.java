package glog.leeway.com.home_page.Interfaces;

import glog.leeway.com.home_page.Models.Userinfo;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface OnHttpResponceForLogin {
    void OnLoginSuccess(String stautus, Boolean success, Userinfo userinfo);
    void OnLoginFaild(Throwable throwable);
    void OnLoginFaild(String S);

   // void OnLoginSuccessTrue(String success, boolean b, List<UserInfo> userInfo);
}
