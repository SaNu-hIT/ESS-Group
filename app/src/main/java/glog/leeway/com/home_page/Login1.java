package glog.leeway.com.home_page;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import glog.leeway.com.home_page.Connectivity.HttpRequestForLogin;
import glog.leeway.com.home_page.Interfaces.OnHttpResponceForLogin;
import glog.leeway.com.home_page.Models.Userinfo;
import glog.leeway.com.home_page.SessionManager.SessionManager;

/**
 * Created by Abin varghese on 31-07-2017.
 */

public class Login1 extends AppCompatActivity implements OnHttpResponceForLogin {
EditText phonenumber_txt,password_txt;
    Button login_button;
    boolean flag = true;
SessionManager sessionManager;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        progressBar = new ProgressDialog(this,
                ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(false);
        progressBar.setMessage("Loading...");
        progressBar.setCancelable(false);


        sessionManager=new SessionManager(this);

        phonenumber_txt= (EditText) findViewById(R.id.phonenumber_txt);
        password_txt= (EditText) findViewById(R.id.password_txt);
        login_button= (Button) findViewById(R.id.login_button);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number=phonenumber_txt.getText().toString();
                String password=password_txt.getText().toString();




                    if(isConnectedToNet(getBaseContext())) {
                        String firebase_id=getFirebaseId();// Firebase id for getting notifiction
                        String device_id=getDeviceIdfromMobile();//Device id for getting to authonticate user

                        //TODO validate firebase and device id

//                        validate(phone_number,password,firebase_id,device_id);

                        if(!validate(phone_number,password,firebase_id,device_id))
                        {
                            progressBar.show();

sendData();
                        }

                    }
                    else
                    {
                        //TODO : handle if no network connection is available
                        Toast.makeText(Login1.this, "No internet connectivity", Toast.LENGTH_SHORT).show();
                    }







//validate(phone_number,password);




            }
        });

    }

    private void sendData() {


        HttpRequestForLogin httpRequestForLogin=new HttpRequestForLogin(this);
        httpRequestForLogin.AttemtToLogin(phonenumber_txt.getText().toString().trim(),password_txt.getText().toString().trim());

    }

    public boolean validate(String phone_number, String password, String firebase_id, String device_id){

            flag = false;
        if (phone_number.isEmpty() ) {
            phonenumber_txt.setFocusable(true);
            phonenumber_txt.setError("Enter username");
            flag=true;
           // Toast.makeText(Login1.this, "Login filed", Toast.LENGTH_SHORT).show();

        }


        else if (password.isEmpty()) {
            password_txt.setFocusable(true);
            password_txt.setError("invalid password");
            flag=true;
           // Toast.makeText(Login1.this, "Login faild", Toast.LENGTH_SHORT).show();
        }
        else
        {
            flag=false;
        }
return flag;



    }


    public boolean isConnectedToNet(Context context)
    {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;

    }



    private String getFirebaseId() {
        String firebaseid="";
        return firebaseid;
    }



    private String getDeviceIdfromMobile() {
        String device_id="";

//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        device_id=telephonyManager.getDeviceId();

        return device_id;

    }

    @Override
    public void OnLoginSuccess(String stautus, Boolean success, Userinfo userinfo) {
        progressBar.cancel();
String role=userinfo.getRole();
String usename=userinfo.getUsername();
String mobile=userinfo.getMobileno();
String userid=userinfo.getUserId().toString();

sessionManager.SaveCredentials(usename,mobile);
sessionManager.SaveRole(role);
sessionManager.SaveUseId(userid);


        Intent intent=new Intent(getBaseContext(),MainActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    public void OnLoginFaild(Throwable throwable) {
        progressBar.cancel();
        Toast.makeText(this, "Sing in failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnLoginFaild(String S)
    {
        progressBar.cancel();
        Toast.makeText(this, ""+S, Toast.LENGTH_SHORT).show();
    }
}
