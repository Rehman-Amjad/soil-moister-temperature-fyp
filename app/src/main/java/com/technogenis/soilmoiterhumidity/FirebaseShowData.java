package com.technogenis.soilmoiterhumidity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.technogenis.soilmoiterhumidity.adapter.UserAdapter;
import com.technogenis.soilmoiterhumidity.model.User;

import java.util.ArrayList;
import java.util.List;

public class FirebaseShowData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter mUserAdapter;
    private List<User> mDatalist;

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button btnDelete;
    private DatabaseReference historyRef;

    private ChildEventListener MyChildEventListener;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRef.removeEventListener(MyChildEventListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firebase_show_data);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Soil_Moisture_Information");
        btnDelete=findViewById(R.id.btnDelete);
        historyRef = FirebaseDatabase.getInstance().getReference("Soil_Moisture_Information");

        mDatalist=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserAdapter=new UserAdapter(this,mDatalist);
        recyclerView.setAdapter(mUserAdapter);


        MyChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                User user=snapshot.getValue(User.class);
            /*Log.d(TAG,"User Name :" + user.getUserName());
            Log.d(TAG,"User Name :" + user.getUserPassword());*/
                mDatalist.add(user);
                mUserAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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

        };
        myRef.addChildEventListener(MyChildEventListener);


        btnDelete.setOnClickListener(v -> {

        });

    }

    private void deleteAllHistoryData() {
        // Show a confirmation toast before deletion
        Toast.makeText(FirebaseShowData.this, "Deleting all history...", Toast.LENGTH_SHORT).show();

        // Delete all data under "History" in Firebase
        historyRef.removeValue().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mDatalist.clear();
                mUserAdapter.notifyDataSetChanged();
                Toast.makeText(FirebaseShowData.this, "All history deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(FirebaseShowData.this, "Failed to delete history", Toast.LENGTH_SHORT).show();
            }
        });
    }
}