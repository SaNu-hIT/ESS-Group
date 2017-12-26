package glog.leeway.com.home_page.Interfaces;

import java.util.List;

import glog.leeway.com.home_page.Models.SubCat.Jobinfo;


/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface OnHttpResponceForSubCategory {
    void OnSubCategorySuccess(String stautus, Boolean success, List<Jobinfo> categoryinfoList);
    void OnSubCategoryFaild(Throwable throwable);
    void OnSubCategoryFaild(String S);

   // void OnLoginSuccessTrue(String success, boolean b, List<UserInfo> userInfo);
}
