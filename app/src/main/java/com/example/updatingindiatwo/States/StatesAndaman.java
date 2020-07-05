package com.example.updatingindiatwo.States;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.updatingindiatwo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatesAndaman extends AppCompatActivity {
    RelativeLayout sideAnimationTotal;
    LinearLayout sideAnimationActive, sideAnimationRecovered, sideAnimationDeath;
    Animation sideTotal, sideActive, sideRecovered, sideDeath;
    TextView andamanActive, andamanRecovered, andamanDeath, andamanTotal;
    String andamantotal, andamandeath, andamanrecovered, andamanactive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_andaman);
        ///Animation contents
        sideAnimationActive = findViewById(R.id.active_cases_animation);
        sideAnimationDeath = findViewById(R.id.death_cases_animation);
        sideAnimationRecovered = findViewById(R.id.recovered_cases_animation);
        sideAnimationTotal = findViewById(R.id.total_cases_animation);
        sideTotal = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        sideDeath = AnimationUtils.loadAnimation(this, R.anim.side_animation_death);
        sideActive = AnimationUtils.loadAnimation(this, R.anim.side_animation_active);
        sideRecovered = AnimationUtils.loadAnimation(this, R.anim.side_animtion_recovered);
        sideAnimationTotal.setAnimation(sideTotal);
        sideAnimationActive.setAnimation(sideActive);
        sideAnimationDeath.setAnimation(sideDeath);
        sideAnimationRecovered.setAnimation(sideRecovered);

        //hooks for display
        andamanActive = findViewById(R.id.active_cases);
        andamanDeath = findViewById(R.id.death_cases);
        andamanTotal = findViewById(R.id.total_cases);
        andamanRecovered = findViewById(R.id.recovered_cases);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Header Data");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                andamanActive.setText(snapshot.child("Andaman").child("active").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //display data

    }
}
