package glog.leeway.com.home_page;

/**
 * Created by Abin varghese on 03-08-2017.
 */

public class Cat_recycler {
    private String item_name,total,rat,quantity;


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRat() {
        return rat;
    }

    public void setRat(String rat) {
        this.rat = rat;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Cat_recycler(String item_name, String quantity, String rat, String total) {
        this.item_name = item_name;
        this.total = total;
        this.rat = rat;

        this.quantity=quantity;
    }


}
