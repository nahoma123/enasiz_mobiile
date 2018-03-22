package com.messenger.hfad.enasiz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.messenger.hfad.enasiz.sampledata.SendSMS;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//      SendSMS sms = new SendSMS();
//      sms.sendSMSMessage("0912663978","Sending message");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        description = res.getStringArray(R.array.description);

        ItemAdapter itemAdapter = new ItemAdapter(this,items,prices,description);
        myListView.setAdapter(itemAdapter);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.i("Milestone", jsonFind(bringData("/api/check", "name"), "name"));
            }
        });

    }

    public String bringData(final String uri, final String name){
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
                        SendSMS sms = new SendSMS();
                        sms.sendSMSMessage("0912663978","Hello this is me");
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



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

class RechargeThoughPhone extends MainActivity{
    public void send806(int phoneNumber , int amount ){
        if(isPermissionGranted()){
            call_action();
        }
    }
    public void  call_action(){
        Intent out = new Intent();
        out.setAction(Intent.ACTION_CALL);
        out.setData(Uri.parse("tel:" + Uri.encode("*806*0912663978*5#")));
        startActivity(out);
    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    call_action();
                } else {

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
