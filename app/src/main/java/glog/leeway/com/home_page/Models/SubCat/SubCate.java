
package glog.leeway.com.home_page.Models.SubCat;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SubCate {

    @SerializedName("jobinfo")
    private List<Jobinfo> mJobinfo;
    @SerializedName("status")
    private Status mStatus;

    public List<Jobinfo> getJobinfo() {
        return mJobinfo;
    }

    public void setJobinfo(List<Jobinfo> jobinfo) {
        mJobinfo = jobinfo;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
