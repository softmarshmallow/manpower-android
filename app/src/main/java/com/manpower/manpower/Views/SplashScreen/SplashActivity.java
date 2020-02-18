package com.manpower.manpower.Views.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.manpower.manpower.R;
import com.manpower.manpower.Views.MainScreen.MainActivity;
import com.manpower.manpower.Views.Review.ReviewEditorActivity;
import com.manpower.manpower.Views.SMSAuthentication.SMSAuthentication_EnterPhoneNumber;

public class SplashActivity extends AppCompatActivity
{
        
        static final String TAG = "SplashScreenActivity";
        final int delayMilliSeconds = 1700;
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setTheme(R.style.AppTheme_FullScreen);
                setContentView(R.layout.activity_splash);
                
        }
        
        
        @Override
        protected void onResume() {
                super.onResume();
                StartWaiting();
        }
        
        @Override
        protected void onPause() {
                super.onPause();
                handler.removeCallbacks(r);
        }
        
        
        Handler handler = new Handler();
        Runnable r= new Runnable()
        {
                @Override
                public void run() {
                        MoveToNextActivity();
                }
        };
        
        void StartWaiting() {
                handler.postDelayed(r , delayMilliSeconds);
                
        }
        
        
        
        private void MoveToNextActivity() {
        
                Intent intent = new Intent(this, MainActivity.class);
//                Intent intent = new Intent(this, ReviewEditorActivity.class);
                startActivity(intent);
                
                finish();
        }
        
        
}
