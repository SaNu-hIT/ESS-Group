
package glog.leeway.com.home_page.Models.CategoryMode;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Categoryinfo {

    @SerializedName("cat_name")
    private String mCatName;
    @SerializedName("category_id")
    private Long mCategoryId;

    public String getCatName() {
        return mCatName;
    }

    public void setCatName(String catName) {
        mCatName = catName;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
    }

}
