package com.messenger.hfad.enasiz.sampledata;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nahom on 2018-03-22.
 */

public class JsonHandler {

    public String bringData(final String uri){
        Log.e("Check", "Inside");

        try {

            URL localAddress = new URL("http://10.0.2.2:8000"+uri);
            HttpURLConnection myConnection =
                    (HttpURLConnection) localAddress.openConnection();

            if (myConnection.getResponseCode() == 200) {
//                        Log.e("Response", obj.getString("name"));
                BufferedReader in = new BufferedReader( new InputStreamReader(myConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String currentLine;

                while ((currentLine = in.readLine()) != null)
                    response.append(currentLine);

                in.close();


                JSONObject obj = new JSONObject(response.toString());
                Log.e("Take",obj.toString());

                return response.toString();
            }else {
                Log.e("Response", "Failure");
            }

//                    InputStream responseBody = myConnection.getInputStream();
//                    InputStreamReader responseBodyReader =
//                            new InputStreamReader(responseBody, "UTF-8");
            // JsonReader jsonReader = new JsonReader(responseBodyReader);
//                    jsonReader.beginObject();

            //  jsonReader.beginArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "Error";
    }

    public String jsonFind(String json, String name){
        try {
            JSONObject obj = new JSONObject(String.valueOf(json));
            return obj.getString(String.valueOf(name));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }
}
