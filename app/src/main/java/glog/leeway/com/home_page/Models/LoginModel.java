
package glog.leeway.com.home_page.Models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LoginModel {

    @SerializedName("status")
    private Status mStatus;
    @SerializedName("userinfo")
    private Userinfo mUserinfo;

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public Userinfo getUserinfo() {
        return mUserinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        mUserinfo = userinfo;
    }

}
