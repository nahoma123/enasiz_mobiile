package com.messenger.hfad.enasiz.sampledata;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahom on 2018-03-31.
 */
public class Utils {
    private static Context mContext;
    private static final String TAG = "Utils";

    public static List<Match> loadFeeds(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "news.json"));
            List<Match> matchList = new ArrayList<>();
            Log.e("Stringraw Match file", matchList+"");
            for (int i = 0; i < array.length(); i++) {

                Match match = gson.fromJson(array.getString(i), Match.class);
                Log.e("Teamx", array.getString(i)+"");
                matchList.add(match);
            }
            return matchList;
        } catch (Exception e) {
            Log.d(TAG, "seedGames parseException " + e);
            e.printStackTrace();
            return null;
        }
    }

    public static List<Match> loadMatches(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            JSONArray array = new JSONArray("0:[\"competition_type\":\"League\"]");
            List<Match> matchList = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                Match match = gson.fromJson(array.getString(i), Match.class);
                matchList.add(match);
            }
            return matchList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json = null;

        InputStream is = null;
        try {
            AssetManager manager = context.getAssets();
            Log.d(TAG, "path " + jsonFileName);
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String loadJSONFromUrl(final Context context, final String url) {

        final JSONArray[] json = new JSONArray[1];
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                String jsonResponse = "";
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonResponse += response.getString(0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                Log.e("Json", "Chignkking" + "");
                json[0] = response;
                // parsing json
                Log.e("Json", response + "");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        //AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return "0:[\"competition_type\":\"League\"]";

    }
}