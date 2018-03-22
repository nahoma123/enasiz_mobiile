package com.messenger.hfad.enasiz.sampledata;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;

import com.messenger.hfad.enasiz.MainActivity;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;

/** The code for dealing with the SMS manager;
 * called from the GUI code.
 */
public class SendSMS {
    private final int PERMISSION_REQUEST_CODE=1;
    static String TAG = "SendSMS";
    SmsManager mSMSManager = null;
    /* The list of message parts our message
    * gets broken up into by SmsManager */
    ArrayList<String> mFragmentList = null;
    /* Service Center - not used */
    String mServiceCentreAddr = null;
    public SendSMS() {
        mSMSManager = SmsManager.getDefault();
    }
    /* Called from the GUI to send one message to one destination */
    public boolean sendSMSMessage(
            String aDestinationAddress,
            String aMessageText) {
        if (mSMSManager == null) {
            return (false);
        }
        mFragmentList = mSMSManager.divideMessage(aMessageText);
        int fragmentCount = mFragmentList.size();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            if(ContextCompat.checkSelfPermission(this ,Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_DENIED){
//    String[] permissions = {Manifest.permission.SEND_SMS};
//    //requestPermissions(com.messenger.hfad.enasiz.MainActivity.this,permissions, PERMISSION_REQUEST_CODE);
//            }
        }
        if (fragmentCount > 1) {
            Log.e(TAG, "Sending " + fragmentCount + " parts");
            mSMSManager.sendMultipartTextMessage(aDestinationAddress,
                    mServiceCentreAddr,
                    mFragmentList, null, null);
        } else {
            Log.e(TAG, "Sending one part");

            mSMSManager.sendTextMessage(aDestinationAddress,
                    mServiceCentreAddr,
                    aMessageText, null, null);
        }
        return true;
    }
}