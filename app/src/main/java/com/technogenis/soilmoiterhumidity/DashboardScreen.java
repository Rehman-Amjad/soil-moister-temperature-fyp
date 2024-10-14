package com.technogenis.soilmoiterhumidity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class DashboardScreen extends AppCompatActivity {

    NavigationView navMenu;
    ActionBarDrawerToggle toggle;
    DrawerLayout drayerLayout;

    Fragment temp=null;

    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_screen);

        Toolbar toolbar=findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        navMenu=findViewById(R.id.navMenu);
        drayerLayout=findViewById(R.id.drawerlayout);

        //    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Fragment_MainDashboard_cat()).commit();

        //  tv_result=findViewById(R.id.tv_result);

        toggle=new ActionBarDrawerToggle(this,drayerLayout,toolbar,R.string.app_name,R.string.app_name);
        drayerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_Moisture) {
                    Intent fireIntent = new Intent(DashboardScreen.this, MoisterScreen.class);
                    startActivity(fireIntent);
                    drayerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.menu_Air) {
                    Intent airIntent = new Intent(DashboardScreen.this, AirScreen.class);
                    startActivity(airIntent);
                    drayerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.menu_soil) {
                    Intent soilIntent = new Intent(DashboardScreen.this, SoilScreen.class);
                    startActivity(soilIntent);
                    drayerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.menu_Humidity) {
                    Intent humIntent = new Intent(DashboardScreen.this, HumidityScreen.class);
                    startActivity(humIntent);
                    drayerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.menu_show_all_data) {
                    Intent showIntent = new Intent(DashboardScreen.this, FirebaseShowData.class);
                    startActivity(showIntent);
                    drayerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.menu_npk) {
                    Intent showIntent = new Intent(DashboardScreen.this, NPKScreen.class);
                    startActivity(showIntent);
                    drayerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() == R.id.menu_logout) {
                    Intent logIntent = new Intent(DashboardScreen.this, LoginScreen.class);
                    startActivity(logIntent);
                    finish();

                    Toast.makeText(DashboardScreen.this, "Logout", Toast.LENGTH_SHORT).show();
                    drayerLayout.closeDrawer(GravityCompat.START);
                }




                return false;
            }
        });

    }
}