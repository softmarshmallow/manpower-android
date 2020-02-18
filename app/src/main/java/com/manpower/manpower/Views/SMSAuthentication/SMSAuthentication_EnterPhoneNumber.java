package com.manpower.manpower.Views.SMSAuthentication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.manpower.manpower.ManPowerApp;
import com.manpower.manpower.R;
import com.nexmo.sdk.verify.client.VerifyClient;
import com.nexmo.sdk.verify.event.SearchListener;
import com.nexmo.sdk.verify.event.UserObject;
import com.nexmo.sdk.verify.event.UserStatus;
import com.nexmo.sdk.verify.event.VerifyClientListener;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SMSAuthentication_EnterPhoneNumber extends AppCompatActivity
{
        
        public static final String TAG = SMSAuthentication_EnterPhoneNumber.class.getSimpleName();
        
        
        @BindView(R.id.phoneNumberEditText)
        EditText phoneNumberEditText;
        
        @BindView(R.id.confirmButton)
        Button confirmButton;
        
        
        InputMethodManager inputMethodManager;
        Activity activity;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_smsauthentication__enter_phone_number);
                ButterKnife.bind(this);
        
        
        
                activity = this;
                inputMethodManager = (InputMethodManager)activity.getSystemService(
                        Context.INPUT_METHOD_SERVICE);
        
        
        
        
                phoneNumberEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                                // If DONE or Enter were pressed, validate the input.
                                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                                        inputMethodManager.hideSoftInputFromWindow(phoneNumberEditText.getWindowToken(), 0);
                                        Editable phoneNumber = phoneNumberEditText.getText();
                                        if (TextUtils.isEmpty(phoneNumber.toString()) || phoneNumber.toString().length() < 5)
                                                phoneNumberEditText.setError("Error Phone Number");
                                        return true;
                                }
                                return false;
                        }
                });
                
                
                
                
                
                
                
                
                
                
                
        }
        
        
        
        @OnClick(R.id.confirmButton)
        public void onViewClicked() {
        
                inputMethodManager.hideSoftInputFromWindow(phoneNumberEditText.getWindowToken(), 0);
                final String prefix = "KR";
        
                Editable phoneNumberEdit = phoneNumberEditText.getText();
        
                if(phoneNumberEdit != null) {
                        final String phoneNumber = phoneNumberEdit.toString();
                        if(TextUtils.isEmpty(prefix) || TextUtils.isEmpty(phoneNumber) || phoneNumber.length() < 5)
                                phoneNumberEditText.setError("Enter your Phone Number");
                        else {
                                initiateGetUserStatus(prefix, phoneNumber);
                        }
                }
                
        }
        
        
        
        
        
        
        
        private void initiateGetUserStatus(final String prefix, final String phoneNumber) {
                final ManPowerApp application = (ManPowerApp) this.getApplication();
                
                application.getVerifyClient().getUserStatus(prefix, phoneNumber, new SearchListener() {
                        @Override
                        public void onUserStatus(final UserStatus userStatus) {
                                Log.d(TAG, "onUserStatus " + userStatus.toString());
                                showToast("onUserStatus: " + userStatus.toString());
                                
                                if(userStatus != UserStatus.USER_VERIFIED) {
                                        application.getVerifyClient().getVerifiedUser(prefix, phoneNumber);
                                }
                        }
                        
                        @Override
                        public void onError(final com.nexmo.sdk.verify.event.VerifyError errorCode, final String errorMessage) {
                                Log.d(TAG, "onSearchError " + errorCode);
                                showToast("onSearchError.message: " + errorMessage);
                        }
                        
                        @Override
                        public void onException(IOException exception) {
                                Log.d(TAG, "onException " + exception.getMessage());
                                showToast("No internet connectivity.");
                        }
                });
        }
        
        private void showToast(final String message) {
                this.runOnUiThread(new Runnable() {
                        public void run() {
                                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        }
                });
        }
        
        @Override
        public void onDestroy() {
                super.onDestroy();
                ManPowerApp application = (ManPowerApp) this.getApplication();
                if (application.getVerifyClient() != null)
                        application.getVerifyClient().removeVerifyListeners();
        }
        
        @Override
        public void onResume(){
                super.onResume();
                
                final Activity activity = this;
                final ManPowerApp application = (ManPowerApp) activity.getApplication();
                application.getVerifyClient().addVerifyListener(new VerifyClientListener() {
                        @Override
                        public void onVerifyInProgress(final VerifyClient verifyClient, final UserObject userObject) {
                        }
                        
                        @Override
                        public void onUserVerified(final VerifyClient verifyClient, final UserObject userObject) {
                                Log.d(TAG, "onUserVerified ");
                                showToast("User verified!");
                        }
                        
                        @Override
                        public void onError(final VerifyClient verifyClient, final com.nexmo.sdk.verify.event.VerifyError errorCode, final UserObject userObject) {
                                Log.d(TAG, "onError " + errorCode);
                                showToast("onError.code: " + errorCode.toString());
                        }
                        
                        @Override
                        public void onException(final IOException exception) {
                                Log.d(TAG, "onException " + exception.getMessage());
                                showToast("No internet connectivity.");
                        }
                });
        }
        
        @Override
        public void onPause(){
                super.onPause();
                
                final Activity activity = this;
                final ManPowerApp application = (ManPowerApp) activity.getApplication();
                application.getVerifyClient().removeVerifyListeners();
        }
        
        
        
        
        
}
