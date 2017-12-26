package glog.leeway.com.home_page.Interfaces;

import java.util.List;

import glog.leeway.com.home_page.Models.CategoryMode.Categoryinfo;


/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface OnHttpResponceForCategory {
    void OnCategorySuccess(String stautus, Boolean success, List<Categoryinfo> categoryinfoList);
    void OnCategoryFaild(Throwable throwable);
    void OnCategoryFaild(String S);

   // void OnLoginSuccessTrue(String success, boolean b, List<UserInfo> userInfo);
}
