package glog.leeway.com.home_page.Interfaces;

import java.util.List;

import glog.leeway.com.home_page.Models.NewModels.Orderslist;


/**
 * Created by Abin varghese on 03-08-2017.
 */

public interface OnHttpResponceForListItem {
    void OnListItemSuccess(String stautus, Boolean success, List<Orderslist> categoryinfoList);
    void OnListItemFaild(Throwable throwable);
    void OnListItemFaild(String S);

   // void OnLoginSuccessTrue(String success, boolean b, List<UserInfo> userInfo);
}
