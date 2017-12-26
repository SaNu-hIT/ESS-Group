
package glog.leeway.com.home_page.Models.SubCat;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Jobinfo {

    @SerializedName("subcat_id")
    private Long mSubcatId;
    @SerializedName("subcat_name")
    private String mSubcatName;

    public Long getSubcatId() {
        return mSubcatId;
    }

    public void setSubcatId(Long subcatId) {
        mSubcatId = subcatId;
    }

    public String getSubcatName() {
        return mSubcatName;
    }

    public void setSubcatName(String subcatName) {
        mSubcatName = subcatName;
    }

}
