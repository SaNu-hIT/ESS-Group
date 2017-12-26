package glog.leeway.com.home_page.Aapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import glog.leeway.com.home_page.Cat_recycler;
import glog.leeway.com.home_page.Fullscreen_data;
import glog.leeway.com.home_page.Interfaces.onClickClose;
import glog.leeway.com.home_page.R;

/**
 * Created by user on 8/2/2017.
 */

public class SubCategoruAdapter extends RecyclerView.Adapter<SubCategoruAdapter.ViewHolder> {
    private ArrayList<Cat_recycler>catrecycles;
    private Context context;
    onClickClose onClickClose;

    public SubCategoruAdapter(ArrayList<Cat_recycler> categl, Fullscreen_data mainActivity){
        catrecycles=categl;
        context=mainActivity;

    }
    public void SetListnerMon(onClickClose onClickClose)
    {
       this.onClickClose=onClickClose;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Cat_recycler cycle=catrecycles.get(position);
        holder.textView.setText(cycle.getItem_name());
        holder.textView1.setText(cycle.getQuantity());
        holder.textView2.setText(cycle.getTotal());
        holder.rate_peritem.setText(cycle.getRat());
        holder.close_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catrecycles.remove(position);
onClickClose.CloseItems(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return catrecycles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView1;
        public TextView textView2;
        public TextView rate_peritem;
        ImageView close_icons;
        public ViewHolder(View itemView)
        {

            super(itemView);
            textView=itemView.findViewById(R.id.category);
            textView1=itemView.findViewById(R.id.subcategory);
            rate_peritem=itemView.findViewById(R.id.rate_peritem);
            textView2=itemView.findViewById(R.id.ratetext);
            close_icons=itemView.findViewById(R.id.close_icons);

        }
    }
}
