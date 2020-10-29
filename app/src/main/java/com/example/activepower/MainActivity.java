package com.example.activepower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.activepower.fragments.HomeFragment;
import com.example.activepower.fragments.ProfileFragment;
import com.example.activepower.fragments.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottonNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //show default fragment
        showSelectFragment(new HomeFragment());

        mBottonNavigationView = (BottomNavigationView) findViewById(R.id.nav);

        mBottonNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.menu_profile){
                    showSelectFragment(new ProfileFragment());
                }
                if(item.getItemId() == R.id.menu_home){
                    showSelectFragment(new HomeFragment());
                }
                if(item.getItemId() == R.id.menu_settings){
                    showSelectFragment(new SettingFragment());
                }

                return true;
            }
        });
    }

    /* metodo para seleccionar un fragmento */

    private void showSelectFragment(Fragment f){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, f)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}