package glog.leeway.com.home_page.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import glog.leeway.com.home_page.Aapter.OrderAda;
import glog.leeway.com.home_page.Customfont.MyTextView;
import glog.leeway.com.home_page.Models.NewModels.Order;
import glog.leeway.com.home_page.Models.NewModels.Orderslist;
import glog.leeway.com.home_page.R;

public class DetailsActivity extends Activity {

    private RecyclerView recyclerView;
    MyTextView name,phone,altmobile,emailid,advance,amount;
    private MyTextView tax,total,balance,total_amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        name= (MyTextView) findViewById(R.id.cust_name);
        phone= (MyTextView) findViewById(R.id.mobile);
        altmobile= (MyTextView) findViewById(R.id.altmobile);
        emailid= (MyTextView) findViewById(R.id.email_id);
        amount= (MyTextView) findViewById(R.id.amount);
        tax= (MyTextView) findViewById(R.id.tax);
        total= (MyTextView) findViewById(R.id.total);
        advance= (MyTextView) findViewById(R.id.advance);
        balance= (MyTextView) findViewById(R.id.balance);
        total_amount= (MyTextView) findViewById(R.id.total_amount);



        Intent intent=getIntent();



        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        Orderslist bean = (Orderslist) intent.getSerializableExtra("OBJECT");


        name.setText("NAME : "+bean.getCName());
        phone.setText("PHONE : "+bean.getMobile());
        altmobile.setText("TIN NO : "+bean.getAltmobile());
        emailid.setText("EMAIL : "+bean.getEmailId());
        amount.setText(bean.getAmount().toString());
        tax.setText(bean.getTax().toString()+"/-");
        total.setText(bean.getTotal().toString());
        advance.setText(bean.getAdvance().toString()+"/-");
        balance.setText(bean.getBalance().toString()+"/-");
        total_amount.setText(bean.getTotal().toString()+"/-");



        List<Order> orders=bean.getOrders();

        OrderAda eventRecyclerViewAdapter=new OrderAda(orders,this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventRecyclerViewAdapter);




    }

    public void onBackPressed(View view) {
        onBackPressed();
    }
}
