package glog.leeway.com.home_page;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import glog.leeway.com.home_page.Aapter.OrderListAdapter;
import glog.leeway.com.home_page.Activitys.DetailsActivity;
import glog.leeway.com.home_page.Connectivity.HttpRequestForListOreders;
import glog.leeway.com.home_page.Interfaces.OnHttpResponceForListItem;
import glog.leeway.com.home_page.Interfaces.onClickCard;
import glog.leeway.com.home_page.Models.NewModels.Orderslist;
import glog.leeway.com.home_page.SessionManager.SessionManager;


public class MainActivity extends AppCompatActivity implements OnHttpResponceForListItem, onClickCard {
    private ProgressDialog progressBar;
SessionManager sessionManager;
    List<List<Orderslist>> orderslists;
    private AutoCompleteTextView searchField;
    OrderListAdapter eventRecyclerViewAdapter;
  List<Orderslist> orderslistsnew;
    @OnClick(R.id.fab_icoons)
    public void OpenCust(FloatingActionButton floatingActionButton)
    {
        Intent intent=new Intent(getBaseContext(),Fullscreen_data.class);
        startActivity(intent);

    }
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sessionManager=new SessionManager(this);
        searchField= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                progressBar.show();

                callApi(searchField.getText().toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });

        orderslists=new ArrayList<>();
        progressBar = new ProgressDialog(this,
                ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(false);
        progressBar.setMessage("Loading..");
        progressBar.setCancelable(false);
        progressBar.cancel();
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        progressBar.show();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

   callApi("");

    }

    private void callApi(String key) {
        HttpRequestForListOreders httpRequestForListOreders=new HttpRequestForListOreders(this);
        httpRequestForListOreders.ListOrders(key);
    }

    @Override
    protected void onResume() {
        super.onResume();
        callApi("");

    }

    @Override
    public void OnListItemSuccess(String stautus, Boolean success, List<Orderslist> categoryinfoList) {
        orderslists.clear();
        orderslists.add(categoryinfoList);


         eventRecyclerViewAdapter=new OrderListAdapter(categoryinfoList,MainActivity.this);
        eventRecyclerViewAdapter.OnItemClickCallBck(this);
        eventRecyclerViewAdapter.OrderClick(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventRecyclerViewAdapter);
        eventRecyclerViewAdapter.notifyDataSetChanged();
        progressBar.cancel();
    }

    @Override
    public void OnListItemFaild(Throwable throwable) {
progressBar.cancel();


//        eventRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnListItemFaild(String S) {
progressBar.cancel();
        eventRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void Clicktems(int position) {
        Orderslist categoryinfoList=orderslists.get(0).get(position);

        String mobile=categoryinfoList.getAltmobile();
        String orders=categoryinfoList.getCName();

//        Log.e( "Clicktems: ",""+mobile );
        Log.e( "Clicktems: ",""+orders );


        Intent intent=new Intent();
//
        Bundle b = new Bundle();
        b.putSerializable("OBJECT", categoryinfoList);
        intent.setClass(getBaseContext(),DetailsActivity.class);
        intent.putExtras(b);
        startActivity(intent);







    }

    public void onLogout(View view) {

        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,Logout!")
                .setCancelText("Cancel")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                     clearAll();
                    }
                })
                .show();

    }

    private void clearAll() {
        sessionManager.ClearAll();
        Intent intent=new Intent(getBaseContext(),Login1.class);
        startActivity(intent);
        finish();
    }
}
