package com.example.islit;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener,
    ListFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    selectedFragment=MapFragment.newInstance("1","2");
                    transaction.replace(R.id.content_main,selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    selectedFragment=ListFragment.newInstance();
                    transaction.replace(R.id.content_main,selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    selectedFragment=SettingsFragment.newInstance("1","2");
                    transaction.replace(R.id.content_main,selectedFragment);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment selectedFragment=null;
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        selectedFragment=MapFragment.newInstance("1","2");
        transaction.replace(R.id.content_main,selectedFragment);
        transaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onFragmentInteraction(Uri uri){

    }

}
