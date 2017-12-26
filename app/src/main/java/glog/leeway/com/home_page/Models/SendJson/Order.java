
package glog.leeway.com.home_page.Models.SendJson;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Order {

    @SerializedName("item_name")
    private String mItemName;
    @SerializedName("itemtotal")
    private String mItemtotal;
    @SerializedName("quantity")
    private String mQuantity;
    @SerializedName("rate_item")
    private String mRateItem;

    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public String getItemtotal() {
        return mItemtotal;
    }

    public void setItemtotal(String itemtotal) {
        mItemtotal = itemtotal;
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

}
