
package glog.leeway.com.home_page.Models.SendJson;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class JsonSendOrder {

    @SerializedName("advance")
    private String mAdvance;
    @SerializedName("altmobileno")
    private String mAltmobileno;
    @SerializedName("amount")
    private String mAmount;
    @SerializedName("balance")
    private String mBalance;
    @SerializedName("c_name")
    private String mCName;
    @SerializedName("email_id")
    private String mEmailId;
    @SerializedName("mobileno")
    private String mMobileno;
    @SerializedName("orders")
    private List<Order> mOrders;
    @SerializedName("tax")
    private String mTax;
    @SerializedName("total")
    private String mTotal;

    public String getAdvance() {
        return mAdvance;
    }

    public void setAdvance(String advance) {
        mAdvance = advance;
    }

    public String getAltmobileno() {
        return mAltmobileno;
    }

    public void setAltmobileno(String altmobileno) {
        mAltmobileno = altmobileno;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public String getBalance() {
        return mBalance;
    }

    public void setBalance(String balance) {
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

    public String getMobileno() {
        return mMobileno;
    }

    public void setMobileno(String mobileno) {
        mMobileno = mobileno;
    }

    public List<Order> getOrders() {
        return mOrders;
    }

    public void setOrders(List<Order> orders) {
        mOrders = orders;
    }

    public String getTax() {
        return mTax;
    }

    public void setTax(String tax) {
        mTax = tax;
    }

    public String getTotal() {
        return mTotal;
    }

    public void setTotal(String total) {
        mTotal = total;
    }

}
