
package glog.leeway.com.home_page.Models.NewModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Order implements Serializable{

    @SerializedName("item_name")
    private String mItemName;
    @SerializedName("l_id")
    private String mLId;
    @SerializedName("orderId")
    private String mOrderId;
    @SerializedName("quantity")
    private String mQuantity;
    @SerializedName("rate_item")
    private String mRateItem;
    @SerializedName("total")
    private String mTotal;

    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public String getLId() {
        return mLId;
    }

    public void setLId(String lId) {
        mLId = lId;
    }

    public String getOrderId() {
        return mOrderId;
    }

    public void setOrderId(String orderId) {
        mOrderId = orderId;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setQuantity(String quantity) {
        mQuantity = quantity;
    }

    public String getRateItem() {
        return mRateItem;
    }

    public void setRateItem(String rateItem) {
        mRateItem = rateItem;
    }

    public String getTotal() {
        return mTotal;
    }

    public void setTotal(String total) {
        mTotal = total;
    }

}
