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
import glog.leeway.com.home_page.Models.NewModels.Orderslist;
import glog.leeway.com.home_page.R;

/**
 * Created by user on 8/2/2017.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
    private List<Orderslist> catrecycles;
    private List<Order> order;
    private Context context;
    onClickClose onClickClose;
    onClickCard onClickCard;

    public OrderListAdapter(List<Orderslist> categl, Context context) {
        catrecycles = categl;
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_orders, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(""+catrecycles.get(position).getCName());
        holder.phonenumber_txt.setText(""+catrecycles.get(position).getMobile());
        holder.alternative_phonenumber.setText("TIN NO "+catrecycles.get(position).getAltmobile());
        holder.email_id.setText(""+catrecycles.get(position).getEmailId());

        holder.tax_amt.setText("ADVANCE  : "+catrecycles.get(position).getAdvance().toString());
        holder.amount_of_event.setText("TOTAL  :"+catrecycles.get(position).getTotal().toString());
        holder.advance_amount.setText("BALANCE  :"+catrecycles.get(position).getBalance().toString());


         order=catrecycles.get(position).getOrders();

        int size=order.size();

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCard.Clicktems(position);

            }
        });




    }

    @Override
    public int getItemCount() {
        return catrecycles.size();
    }

    public void OnItemClickCallBck(MainActivity mainActivity) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView_Lato name, phonenumber_txt,alternative_phonenumber,email_id,subcategory,amount_of_event,tax_amt,advance_amount;
CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.cust_name);
            card_view=itemView.findViewById(R.id.card_view);
            phonenumber_txt = (TextView_Lato) itemView.findViewById(R.id.phonenumber_txt);
            alternative_phonenumber = (TextView_Lato) itemView.findViewById(R.id.alternative_phonenumber);

            email_id = (TextView_Lato) itemView.findViewById(R.id.email_id);
            subcategory = (TextView_Lato) itemView.findViewById(R.id.subcategory);
            amount_of_event = (TextView_Lato) itemView.findViewById(R.id.amount_of_event);
            tax_amt = (TextView_Lato) itemView.findViewById(R.id.tax_amt);
            advance_amount = (TextView_Lato) itemView.findViewById(R.id.advance_amount);


        }
    }
}
