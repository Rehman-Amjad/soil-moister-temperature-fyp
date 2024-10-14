package com.technogenis.soilmoiterhumidity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.technogenis.soilmoiterhumidity.model.User;

public class AirScreen extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    Button btn_back;

    TextView tv_wait,tv_moisture,date_text;

    ImageView img_fire_back,imgMoisture;

    String img, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_air_screen);

        btn_back=findViewById(R.id.btn_back);

        tv_wait=findViewById(R.id.tv_wait);
        tv_moisture=findViewById(R.id.tv_moisture);
        date_text=findViewById(R.id.date_text);

        img_fire_back=findViewById(R.id.img_fire_back);

        imgMoisture=findViewById(R.id.imgMoisture);


        img_fire_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(AirScreen.this,DashboardScreen.class);
                startActivity(backIntent);

                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(AirScreen.this,DashboardScreen.class);
                startActivity(backIntent);

                finish();
            }
        });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("SoilData");
        DatabaseReference callref=myRef.child("100");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                value =snapshot.child("AirTemps").getValue(String.class);
                String date  =snapshot.child("DatedTime").getValue(String.class);
                date_text.setText("Date and Time: " + date);

                img=snapshot.child("img").getValue(String.class);

                tv_moisture.setVisibility(View.VISIBLE);
                imgMoisture.setVisibility(View.VISIBLE);

                User user =snapshot.getValue(User.class);

                tv_moisture.setText("Air Temperature: " +user.getAirTemps() + " C");

                tv_wait.setVisibility(View.INVISIBLE);







            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                value =snapshot.child("AirTemps").getValue(String.class);
                String date  =snapshot.child("DatedTime").getValue(String.class);
                date_text.setText("Date and Time: " + date);

                img=snapshot.child("img").getValue(String.class);

                tv_moisture.setVisibility(View.VISIBLE);
                imgMoisture.setVisibility(View.VISIBLE);

                User user =snapshot.getValue(User.class);

                tv_wait.setVisibility(View.INVISIBLE);

                tv_moisture.setText("Air Temperature: " +user.getAirTemps() + " C");


            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}