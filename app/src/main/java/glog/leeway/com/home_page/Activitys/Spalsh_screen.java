package glog.leeway.com.home_page.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import glog.leeway.com.home_page.Login1;
import glog.leeway.com.home_page.MainActivity;
import glog.leeway.com.home_page.R;
import glog.leeway.com.home_page.SessionManager.SessionManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Spalsh_screen extends AppCompatActivity {

     public static final int TIME_OUT=3000;
     SessionManager sessionManager;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);


     setContentView(R.layout.activity_spalsh_screen);
     sessionManager=new SessionManager(this);



     Handler handler=new Handler();
     handler.postDelayed(new Runnable() {
     @Override
     public void run() {


     if(sessionManager.getUsername().equals("1"))
     {
     Intent intent=new Intent(getBaseContext(),Login1.class);
     startActivity(intent);
     finish();

     }
     else
     {
     Intent intent=new Intent(getBaseContext(),MainActivity.class);
     startActivity(intent);
     finish();
     }


     }
     },TIME_OUT);

     }
}
