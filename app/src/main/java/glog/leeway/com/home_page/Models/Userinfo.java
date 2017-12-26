
package glog.leeway.com.home_page.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Userinfo {

    @SerializedName("mobileno")
    private String mMobileno;
    @SerializedName("role")
    private String mRole;
    @SerializedName("userId")
    private Long mUserId;
    @SerializedName("username")
    private String mUsername;

    public String getMobileno() {
        return mMobileno;
    }

    public void setMobileno(String mobileno) {
        mMobileno = mobileno;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
