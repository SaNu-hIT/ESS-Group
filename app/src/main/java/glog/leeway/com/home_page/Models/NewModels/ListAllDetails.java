
package glog.leeway.com.home_page.Models.NewModels;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ListAllDetails {

    @SerializedName("code")
    private Code mCode;
    @SerializedName("orderslist")
    private List<Orderslist> mOrderslist;

    public Code getCode() {
        return mCode;
    }

    public void setCode(Code code) {
        mCode = code;
    }

    public List<Orderslist> getOrderslist() {
        return mOrderslist;
    }

    public void setOrderslist(List<Orderslist> orderslist) {
        mOrderslist = orderslist;
    }

}
