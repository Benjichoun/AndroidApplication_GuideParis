package org.esiea.badelon_batista.androidapplication_guideparis;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendrierActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent intent;
    Notification notif;
    PendingIntent pintent;
    Calendar calendar;
    SimpleDateFormat format1;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        String now = DateUtils.formatDateTime(getApplicationContext(),(new Date()).getTime(),DateFormat.FULL);
        //TextView myTextView = (TextView) findViewById(R.id.textView4);
        TextView myTextView = (TextView) findViewById(R.id.textView4);
        // if(Locale.getDefault().getLanguage()=="fr")
        myTextView.setText(Html.fromHtml(getString(R.string.texthtmlcal)));

       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        if (id == R.id.nav_accueil) {
            //Accueil
            intent= new Intent(this,MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_arrondissements) {
            //Arrondissements
            intent= new Intent(this,ArrondissementsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_calendrier) {
            //calendrier
            intent= new Intent(this,CalendrierActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_partage) {
            //partage bouton
            intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.text_partage));
            startActivity(Intent.createChooser(intent,"Share"));




        } else if (id == R.id.nav_contact) {
            //contact
            intent= new Intent(this,InformationActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
