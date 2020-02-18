package com.manpower.manpower;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.manpower.manpower.Config.NexmoConfig;
import com.nexmo.sdk.NexmoClient;
import com.nexmo.sdk.core.client.ClientBuilderException;
import com.nexmo.sdk.verify.client.VerifyClient;


public class ManPowerApp extends Application
{
        
        private static Context context;
        
        @Override
        public void onCreate() {
                super.onCreate();
                // app context
                ManPowerApp.context = getApplicationContext();
                
                acquireVerifyClient();
        }
        
        public static Context getAppContext() {
                return ManPowerApp.context;
        }
        
        
        
        
        
        public static final String TAG = ManPowerApp.class.getSimpleName();
        private VerifyClient verifyClient;
        private NexmoClient nexmoClient;
        
        public VerifyClient getVerifyClient() {
                return this.verifyClient;
        }
        
        
        /**
         * Acquire a new verify client.
         * If the user changes the settings shared preferences, a new verify client needs
         * to be created to reflect the new configuration.
         * Storing the credentials: applicationId and sharedSecretKey is up to the developer:
         * you may choose to use SharedPreferences, a file or define meta-data in the AndroidManifest.xml
         */
        public void acquireVerifyClient() {
                if (TextUtils.isEmpty(NexmoConfig.NexmoAppId) || TextUtils.isEmpty(NexmoConfig.NexmoSharedSecretKey)) {
                        Log.e(TAG, "You must supply valid appId and sharedSecretKey, provided by Nexmo");
                        return;
                }
                NexmoClient nexmoClient = null;
                try {
                        nexmoClient = new NexmoClient.NexmoClientBuilder()
                                .context(context)
                                .applicationId(NexmoConfig.NexmoAppId)
                                .sharedSecretKey(NexmoConfig.NexmoSharedSecretKey)
                                .build();
                } catch (ClientBuilderException e) {
                        e.printStackTrace();
                        return;
                }
                this.verifyClient = new VerifyClient(nexmoClient);
        }

}
