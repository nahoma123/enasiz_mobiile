package com.messenger.hfad.enasiz.sampledata;

import android.telephony.SmsManager;
import android.util.Log;

import java.util.ArrayList;

/** The code for dealing with the SMS manager;
 * called from the GUI code.
 */
public class SendSMS {
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