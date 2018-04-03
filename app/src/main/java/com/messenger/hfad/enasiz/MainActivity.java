package com.messenger.hfad.enasiz;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.messenger.hfad.enasiz.sampledata.Adapters.MatchAdapter;
import com.messenger.hfad.enasiz.sampledata.AppController;
import com.messenger.hfad.enasiz.sampledata.Competition;
import com.messenger.hfad.enasiz.sampledata.Feed;

import com.messenger.hfad.enasiz.sampledata.HeadingMatchView;
import com.messenger.hfad.enasiz.sampledata.HeadingView;
import com.messenger.hfad.enasiz.sampledata.Info;
import com.messenger.hfad.enasiz.sampledata.InfoView;
import com.messenger.hfad.enasiz.sampledata.Item;

import com.messenger.hfad.enasiz.sampledata.Match;
import com.messenger.hfad.enasiz.sampledata.Team;
import com.messenger.hfad.enasiz.sampledata.Utils;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    private static final String url="https://api.androidhive.info/json/movies.json";
    private static final String url="http://10.0.2.2:8000/api/matches/showall";
    private ProgressDialog dialog;
    private List<Match> array = new ArrayList<Match>();
    private ExpandableListView listView;
    private ExpandableListAdapter matchadapter;
    private HashMap<String, List<String>> listDataChild;

    //

    private ExpandablePlaceHolderView mExpandableView;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




//        //send806(888,888);
//      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//

//      SendSMS sms = new SendSMS();
//      sms.sendSMSMessage("0912663978","Sending message");
        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        listView = findViewById(R.id.myListView);
        matchadapter = new MatchAdapter(this, array,array);
        listView.setAdapter( matchadapter);
        MenuItem recharge;
        recharge = (MenuItem) findViewById(R.id.nav_gallery);



        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading ....");

        dialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                hideDialog();
                // parsing json
                for(int i=0;i<response.length();i++){
                    try{

                        JSONObject obj = response.getJSONObject(i);
                        Match match = new Match();
                        match.setAway_team(Integer.parseInt(obj.getString("away_team")));
                        match.setHome_team(Integer.parseInt(obj.getString("home_team")));
//                        match.setHome_team(Integer.parseInt(obj.getString("home_team")));
//                      item.setTitle("Arsenal Vs Manchester");

                        // genre is json array

//                        JSONArray genreArray = obj.getJSONArray("genre");
//                        ArrayList<String> genre = new ArrayList<String>();
//                        for(int j=0;j<genreArray.length();j++){
//                            genre.add((String) genreArray.get(j));
//                        }
//item.setTitle(obj.getString("title"));
//item.setThumbnailUrl(obj.getString("image"));
//item.setRating(((Number) obj.get("rating")).doubleValue());
//                        item.setGenre(genre);
                        array.add(match);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                matchadapter.notifyDataSetChanged();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
//        ItemAdapter itemAdapter = new ItemAdapter(this,items,prices,description);
//        myListView.setAdapter(itemAdapter);
//        AsyncTask.execute(new Runnable() {
//
//            @Override
//            public void run() {
//                JsonHandler jh = new JsonHandler();
//                Log.e("Data__",(jh.jsonArrayFind(jh.bringData("/api/check"),1)).toString());
//                Log.e("Milestone", jh.jsonStringFind(jh.jsonArrayFind(jh.bringData("/api/check"),0),"name"));
//            }
//        });*/

        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();
        mExpandableView = (ExpandablePlaceHolderView)findViewById(R.id.expandableView);
        for(Match match : Utils.loadFeeds(this.getApplicationContext())){
            try {
                Date dateD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(match.getStart_time());
                Date date1D = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(match.getEnd_time());
                String dateH = new SimpleDateFormat("HH:mm").format(dateD);
                String dateDate = new SimpleDateFormat("dd/MM/yyyy").format(dateD);
                String dateDate1 = new SimpleDateFormat("dd/MM/yyyy").format(date1D);
                String date1H = new SimpleDateFormat("HH:mm").format(date1D);
                Team awayteam= new Team();
                Team hometeam = new Team();
                for (Team team : match.getHometeam()){
                    hometeam = team;
                }

                for (Team team : match.getAwayteam()){
                    awayteam = team;
                }


                Competition competition = match.getCompetition();
                String compName;
                if(competition.getName() != null){
                    compName = competition.getName();
                }
                else {
                    compName = competition.getLeague_name();
                }


                mExpandableView.addView(new HeadingMatchView(mContext,dateDate,dateH,date1H,hometeam.getTeam_name(),
                        awayteam.getTeam_name(),compName,match.getVenue()));
//            for(Info info : feed.getInfoList()){
//                mExpandableView.addView(new InfoView(mContext, info));
//            }
            } catch (ParseException e) {

                e.printStackTrace();
            }


        }
    }

    public void hideDialog() {
      if(dialog!=null){
          dialog.dismiss();
          dialog = null;
      }
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

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
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
        if(id == R.id.recharge){
            send806(888,888);
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

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
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
    public void populateChild(int i){
        List<String> bet;

    }



}
class RechargeThoughPhone extends MainActivity{

}