package glog.leeway.com.home_page.Aapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import glog.leeway.com.home_page.Customfont.TextView_Lato;
import glog.leeway.com.home_page.Interfaces.onClickCard;
import glog.leeway.com.home_page.Interfaces.onClickClose;
import glog.leeway.com.home_page.MainActivity;
import glog.leeway.com.home_page.Models.NewModels.Order;
import glog.leeway.com.home_page.R;

/**
 * Created by user on 8/2/2017.
 */

public class OrderAda extends RecyclerView.Adapter<OrderAda.ViewHolder> {

    private List<Order> order;
    private Context context;
    onClickClose onClickClose;
    onClickCard onClickCard;

    public OrderAda(List<Order> categl, Context context) {
        order = categl;
        context = context;

    }

    public void OrderClick(onClickCard onClickCard) {
        this.onClickCard=onClickCard;


    }



    public void SetListnerMon(onClickClose onClickClose) {
        this.onClickClose = onClickClose;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_or, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {



holder.itemname.setText(order.get(position).getItemName());
holder.quantity.setText(order.get(position).getQuantity());
holder.price.setText(order.get(position).getRateItem());
holder.total.setText(order.get(position).getTotal());




    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    public void OnItemClickCallBck(MainActivity mainActivity) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        TextView_Lato name, phonenumber_txt,alternative_phonenumber,email_id,subcategory,amount_of_event,tax_amt,advance_amount;
CardView card_view;

        TextView_Lato itemname,quantity,price,total;

        public ViewHolder(View itemView) {
            super(itemView);
            card_view=itemView.findViewById(R.id.card_view);
            itemname = (TextView_Lato) itemView.findViewById(R.id.item_name);
            quantity = (TextView_Lato) itemView.findViewById(R.id.qty);

            price = (TextView_Lato) itemView.findViewById(R.id.rate_peritem);
            total = (TextView_Lato) itemView.findViewById(R.id.total);


        }
    }
}
