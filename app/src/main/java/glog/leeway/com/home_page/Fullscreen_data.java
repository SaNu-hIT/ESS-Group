package glog.leeway.com.home_page;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import glog.leeway.com.home_page.Aapter.SubCategoruAdapter;
import glog.leeway.com.home_page.Connectivity.HttpRequestForCategory;
import glog.leeway.com.home_page.Connectivity.HttpRequestForCreateOrder;
import glog.leeway.com.home_page.Connectivity.HttpRequestForSubCategory;
import glog.leeway.com.home_page.Customfont.MyEditText;
import glog.leeway.com.home_page.Interfaces.OnHttpResponceForCategory;
import glog.leeway.com.home_page.Interfaces.OnHttpResponceForCreateOrder;
import glog.leeway.com.home_page.Interfaces.OnHttpResponceForSubCategory;
import glog.leeway.com.home_page.Interfaces.onClickClose;
import glog.leeway.com.home_page.Models.CategoryMode.Categoryinfo;
import glog.leeway.com.home_page.Models.SendJson.JsonSendOrder;
import glog.leeway.com.home_page.Models.SendJson.Order;
import glog.leeway.com.home_page.Models.SubCat.Jobinfo;



public class Fullscreen_data extends AppCompatActivity implements OnHttpResponceForCategory, OnHttpResponceForSubCategory, onClickClose, OnHttpResponceForCreateOrder {
    String catid = "0";
    String subcat_ids = "0";
    //List<Catrecycle>catrecycleList;
    boolean flag;
    ArrayList<String> categorySpinnerList;
    ArrayList<String> categorySpinnerIdList;
    ArrayList<String> SubcategorySpinnerList;
    ArrayList<String> SubcategoryIdSpinnerList;
    ArrayList<List<Cat_recycler>> full_cate;
float total_amount_all;
    List<String> tots;
@OnClick(R.id.add)
public void AddItem()
{
    if(!item_name.getText().toString().equals("")) {

        Cat_recycler cat_recycler = new Cat_recycler(item_name.getText().toString(), quantity.getText().toString(),rate_peritem .getText().toString(),total_item.getText().toString());
        catg.add(cat_recycler);
        full_cate.add(catg);
        categoruAdapter = new SubCategoruAdapter(catg, Fullscreen_data.this);



        categoruAdapter.SetListnerMon(Fullscreen_data.this);
        recyclerView.setAdapter(categoruAdapter);
        categoruAdapter.notifyDataSetChanged();

        tots.add(total_item.getText().toString());
        item_name.setText("");
        quantity.setText("");
        total_item.setText("");
        rate_peritem.setText("");
        total_amount_all=0;
        int size=tots.size();
        for (int i=0;i<size;i++)
        {
            String ss=tots.get(i);
            if(!ss.equals("")) {
                float s = Float.parseFloat(ss);
                total_amount_all = total_amount_all + s;
            }

        }
        amount_of_event.setText(""+total_amount_all);





    }
    else {
        item_name.setError("Enter item name");

    }


}
    @BindView(R.id.customarname)
    MyEditText customername;
    @BindView(R.id.email)
    MyEditText mail;
    @BindView(R.id.phonenumber_txt)
    MyEditText phon;
    @BindView(R.id.alternative_phonenumber)
    MyEditText altphnum;

    @BindView(R.id.item_name)
    MyEditText item_name;
    @BindView(R.id.quantity)
    MyEditText quantity;

    @BindView(R.id.rate_peritem)
    MyEditText rate_peritem;


    @BindView(R.id.total_item)
    MyEditText total_item;






    //
//    @BindView(R.id.rate)
//    LinearLayout rate;
    @BindView(R.id.cattext)
    TextView cattext;
    @BindView(R.id.subtext)
    TextView subtext;
    @BindView(R.id.ratetext)
    TextView ratetext;
    @BindView(R.id.amount_of_event)
    MyEditText amount_of_event;
    @BindView(R.id.taxamount)
    MyEditText taxamount;
    @BindView(R.id.total_amount)
    MyEditText total_amount;
    @BindView(R.id.advance_amount)
    MyEditText advance_amount;
    @BindView(R.id.balace_amount)
    MyEditText balace_amount;
    ArrayList<String> categorySpinnerlist;
    ArrayList<String> subcategorySpinnerlist;
    ArrayList<String> categorySpinnerlistid;
    ArrayList<String> subcategorySpinnerlistid;
    ArrayList<Cat_recycler> catg;
    SubCategoruAdapter categoruAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressBar;
    String subcategorys="";
    List<String> subl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreen_data);
        ButterKnife.bind(this);
        categorySpinnerList = new ArrayList<>();
        categorySpinnerIdList = new ArrayList<>();
        SubcategorySpinnerList = new ArrayList<>();
        SubcategoryIdSpinnerList = new ArrayList<>();
        full_cate = new ArrayList<>();
        subl = new ArrayList<>();
        catg = new ArrayList<>();
        tots = new ArrayList<>();
        Button save = (Button) findViewById(R.id.save);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        progressBar = new ProgressDialog(this,
                ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(false);
        progressBar.setMessage("Loading...");
        progressBar.setCancelable(false);

        progressBar.show();
        setListenter();


        setRecyclerview();

        getCategory();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String cstname = customername.getText().toString();
                String email = mail.getText().toString();
                String phn = phon.getText().toString();

                String altnum = altphnum.getText().toString();
                String amnt = amount_of_event.getText().toString();
                String tamnt = taxamount.getText().toString();
                String totlamnt = total_amount.getText().toString();
                String adamnt = advance_amount.getText().toString();
                String bamnt = balace_amount.getText().toString();

                if(validate(cstname, email, altnum, phn,  amnt, tamnt, totlamnt, adamnt, bamnt))
                {
progressBar.show();
//                    Cat_recycler cat_recycler
                    JsonSendOrder jsonSendOrder=new JsonSendOrder();
                    jsonSendOrder.setCName(cstname);
                    jsonSendOrder.setEmailId(email);
                    jsonSendOrder.setAltmobileno(altnum);
                    jsonSendOrder.setMobileno(phn);
                    jsonSendOrder.setAmount(amnt);
                    jsonSendOrder.setTax(tamnt);
                    jsonSendOrder.setTotal(totlamnt);
                    jsonSendOrder.setAdvance(adamnt);
                    jsonSendOrder.setBalance(bamnt);

                    List<Order> order = new ArrayList<Order>();
                    for (int i = 0; i < full_cate.size(); i++)
                    {
                        Order imageList = new Order();
                        imageList.setItemName(full_cate.get(0).get(i).getItem_name());
                        imageList.setQuantity(full_cate.get(0).get(i).getQuantity());
                        imageList.setRateItem(full_cate.get(0).get(i).getRat());
                        imageList.setItemtotal(full_cate.get(0).get(i).getTotal());
                        order.add(imageList);
                    }
                    jsonSendOrder.setOrders(order);
                    Log.e( "onClick: ",""+jsonSendOrder.getOrders().size() );
                    SendData(jsonSendOrder);
                }
            }

        });



    }

    private void SendData(JsonSendOrder jsonSendOrder) {
        HttpRequestForCreateOrder httpRequestForCreateOrder=new HttpRequestForCreateOrder(this);
        httpRequestForCreateOrder.PlaceOrder(jsonSendOrder);

    }



    private void setRecyclerview() {


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setListenter() {


        rate_peritem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!quantity.getText().toString().equals("")) {
                    float qty = Float.parseFloat(quantity.getText().toString());

                    String ss = rate_peritem.getText().toString();
                    if (!ss.equals("")) {
                        float value = Float.parseFloat(ss);

                        float totals = value * qty;

                        Log.e( "afterTextChanged: ",""+totals );

                        total_item.setText("" + totals);

                    }
                    else {
                        total_item.setText("");
                    }

                }

            }
        });


        amount_of_event.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!taxamount.getText().toString().equals("")) {
                    float taxamounts = Float.parseFloat(taxamount.getText().toString());

                    String ss = amount_of_event.getText().toString();
                    if (!ss.equals("")) {
                        float value = Float.parseFloat(ss);

                        float tax = (int) (value * (taxamounts / 100.0f));
                        float total = tax + value;
                        total_amount.setText("" + total);
                    }
                    else {
                        total_amount.setText("total d");
                    }

                }

            }
        });
        advance_amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!total_amount.getText().toString().equals("")) {
                    float totalamount = Float.parseFloat(total_amount.getText().toString());

                    if (!advance_amount.getText().toString().equals("")&&!advance_amount.getText().toString().equals(".")) {
                        float advance = Float.parseFloat(advance_amount.getText().toString());

                        float balance = totalamount - advance;
                        balace_amount.setText("" + balance);
                    } else {
                        balace_amount.setText("");
                    }


                }
            }
        });


        taxamount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!taxamount.getText().toString().equals("")) {

                    float taxamounts = Integer.parseInt(taxamount.getText().toString());
                    String ss = amount_of_event.getText().toString();
                    if (!ss.equals("")) {

                        float value = Float.parseFloat(ss);
                        float tax = (int) (value * (taxamounts / 100.0f));
                        float total = tax + value;


                        total_amount.setText("" + total);
                    }
                }


            }
        });


    }

    private void getSubcategory(String catid) {

        HttpRequestForSubCategory httpRequestForSubCategory = new HttpRequestForSubCategory(this);
        httpRequestForSubCategory.getSubCategory(catid);


    }

    public boolean validate(String cst, String em, String emptrn, String phn,  String amnt, String txamnt, String tamnt, String adamnt, String bamnt) {
        flag = true;
        if (cst.isEmpty()) {
            customername.setFocusable(true);
            customername.setError("Error");
            flag=false;
            // Toast.makeText(Fullscreen_data.this, "fali", Toast.LENGTH_SHORT).show();

        } else {
            flag=true;
            customername.setError(null);
        }

        if (em.isEmpty() ) {
            mail.setFocusable(true);
            mail.setError("invalid mail id");
            flag=false;
            // Toast.makeText(Fullscreen_data.this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            mail.setError(null);
        }

        if (phn.isEmpty() || phn.length() > 10 || phn.length() < 9) {
            phon.setFocusable(true);
            phon.setError("invalid number");
            flag=false;
            // Toast.makeText(Fullscreen_data.this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            phon.setError(null);
        }

        if (amnt.isEmpty()) {
            amount_of_event.setFocusable(true);
            amount_of_event.setError("invalid");
            flag=false;
            //  Toast.makeText(Fullscreen_data.this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            amount_of_event.setError(null);
        }
        if (txamnt.isEmpty()) {
            taxamount.setFocusable(true);
            flag=false;
            taxamount.setError("invalid");
            //  Toast.makeText(Fullscreen_data.this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            taxamount.setError(null);
        }
        if (tamnt.isEmpty()) {
            total_amount.setFocusable(true);
            flag=false;
            total_amount.setError("invalid");
            //  Toast.makeText(Fullscreen_data.this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            total_amount.setError(null);
        }
        if (adamnt.isEmpty()) {
            advance_amount.setFocusable(true);
            advance_amount.setError("invalid");
            // Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            advance_amount.setError(null);
        }
        if (bamnt.isEmpty()) {
            balace_amount.setFocusable(true);
            balace_amount.setError("invalid");
            flag=false;
            // Toast.makeText(Fullscreen_data.this, "fail", Toast.LENGTH_SHORT).show();
        } else {
            flag=true;
            balace_amount.setError(null);
        }
        return flag;
    }


    private void getCategory() {

        HttpRequestForCategory httpRequestForCategory = new HttpRequestForCategory(this);
        httpRequestForCategory.AttemtToLogin();
    }


    @Override
    public void OnCategorySuccess(String stautus, Boolean success, List<Categoryinfo> categoryinfoList) {


        categorySpinnerList.clear();
        categorySpinnerList.add("Category");
        categorySpinnerIdList.add("0");
        for (int i = 0; i < categoryinfoList.size(); i++) {
            String name = categoryinfoList.get(i).getCatName();
            String id = categoryinfoList.get(i).getCategoryId().toString();
            categorySpinnerList.add(name);
            Log.e("", "CATEGORYLIST: " + name);
            categorySpinnerIdList.add(id);

        }

        progressBar.cancel();


    }

    @Override
    public void OnCategoryFaild(Throwable throwable) {

    }

    @Override
    public void OnCategoryFaild(String S) {

    }


    @Override
    public void OnSubCategorySuccess(String stautus, Boolean success, List<Jobinfo> categoryinfoList) {


        progressBar.cancel();
        SubcategorySpinnerList.clear();
        SubcategoryIdSpinnerList.clear();
        SubcategorySpinnerList.add("Subcategory Type");
        SubcategoryIdSpinnerList.add("0");
        for (int i = 0; i < categoryinfoList.size(); i++) {
            String name = categoryinfoList.get(i).getSubcatName();
            String id = categoryinfoList.get(i).getSubcatId().toString();
            SubcategorySpinnerList.add(name);
            Log.e("", "Occation: " + name);
            SubcategoryIdSpinnerList.add(id);
        }


    }

    @Override
    public void OnSubCategoryFaild(Throwable throwable) {

    }

    @Override
    public void OnSubCategoryFaild(String S) {

    }

    public void onBackPressed(View view) {
        onBackPressed();
    }

    @Override
    public void CloseItems(int position) {
        tots.remove(position);
        full_cate.remove(position);
        categoruAdapter.notifyDataSetChanged();
//        int size=tots.size();
//        Log.e( "CloseItems: ",""+size);
//        for (int i=0;i<size;i++)
//        {
//            int s= Integer.parseInt(tots.get(i));
//            total_amount_all=total_amount_all + s;
//
//        }
//        amount_of_event.setText(""+total_amount_all);

        int size=tots.size();
        total_amount_all=0;
        for (int i=0;i<size;i++)
        {
            String ss=tots.get(i);
            if(!ss.equals("")) {
                int s = Integer.parseInt(ss);
                total_amount_all = total_amount_all + s;
            }

        }
        amount_of_event.setText(""+total_amount_all);


    }

    @Override
    public void OnOrderSuccess(String stautus, Boolean success) {
        Toast.makeText(this, stautus, Toast.LENGTH_SHORT).show();
        progressBar.cancel();
        finish();
    }

    @Override
    public void OnOrderFaild(Throwable throwable) {
        progressBar.cancel();
        Toast.makeText(this, throwable.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnOrderFaild(String S) {
        Toast.makeText(this, S, Toast.LENGTH_SHORT).show();
        progressBar.cancel();

    }
}
