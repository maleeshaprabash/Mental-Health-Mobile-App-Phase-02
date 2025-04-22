package com.example.evervital;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity10 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FeelAdapter feelAdapter;
    private List<feelings> feelingsList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main10);

        ImageView backicn = findViewById(R.id.imageView39);
        backicn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity10.this, MainActivity7.class);
            startActivity(intent);
        });

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("feelings");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        feelingsList = new ArrayList<>();
        feelAdapter = new FeelAdapter(feelingsList);
        recyclerView.setAdapter(feelAdapter);

        loadFeelingsData();
    }



    private void loadFeelingsData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();

            mDatabase.orderByChild("userId")
                    .equalTo(userId)
                    .addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            feelingsList.clear();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                feelings feeling = dataSnapshot.getValue(feelings.class);
                                if (feeling != null){
                                    feeling.setId(snapshot.getKey());
                                    feelingsList.add(feeling);
                                }
                            }
                            feelAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(MainActivity10.this, "Failed to load " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
