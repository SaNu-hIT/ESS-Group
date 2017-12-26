
package glog.leeway.com.home_page.Models.NewModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Orderslist implements Serializable {

    @SerializedName("advance")
    private Float mAdvance;
    @SerializedName("altmobile")
    private String mAltmobile;
    @SerializedName("amount")
    private Float mAmount;
    @SerializedName("balance")
    private Float mBalance;
    @SerializedName("c_name")
    private String mCName;
    @SerializedName("email_id")
    private String mEmailId;
    @SerializedName("mobile")
    private String mMobile;
    @SerializedName("orderid")
    private Float mOrderid;
    @SerializedName("orders")
    private List<Order> mOrders;
    @SerializedName("tax")
    private Float mTax;
    @SerializedName("total")
    private Float mTotal;

    public Float getAdvance() {
        return mAdvance;
    }

    public void setAdvance(Float advance) {
        mAdvance = advance;
    }

    public String getAltmobile() {
        return mAltmobile;
    }

    public void setAltmobile(String altmobile) {
        mAltmobile = altmobile;
    }

    public Float getAmount() {
        return mAmount;
    }

    public void setAmount(Float amount) {
        mAmount = amount;
    }

    public Float getBalance() {
        return mBalance;
    }

    public void setBalance(Float balance) {
        mBalance = balance;
    }

    public String getCName() {
        return mCName;
    }

    public void setCName(String cName) {
        mCName = cName;
    }

    public String getEmailId() {
        return mEmailId;
    }

    public void setEmailId(String emailId) {
        mEmailId = emailId;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public Float getOrderid() {
        return mOrderid;
    }

    public void setOrderid(Float orderid) {
        mOrderid = orderid;
    }

    public List<Order> getOrders() {
        return mOrders;
    }

    public void setOrders(List<Order> orders) {
        mOrders = orders;
    }

    public Float getTax() {
        return mTax;
    }

    public void setTax(Float tax) {
        mTax = tax;
    }

    public Float getTotal() {
        return mTotal;
    }

    public void setTotal(Float total) {
        mTotal = total;
    }


}
