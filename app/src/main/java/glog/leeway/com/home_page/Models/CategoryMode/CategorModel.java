
package glog.leeway.com.home_page.Models.CategoryMode;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CategorModel {

    @SerializedName("categoryinfo")
    private List<Categoryinfo> mCategoryinfo;
    @SerializedName("status")
    private Status mStatus;

    public List<Categoryinfo> getCategoryinfo() {
        return mCategoryinfo;
    }

    public void setCategoryinfo(List<Categoryinfo> categoryinfo) {
        mCategoryinfo = categoryinfo;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
