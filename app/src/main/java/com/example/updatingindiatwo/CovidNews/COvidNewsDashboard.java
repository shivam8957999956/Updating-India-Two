package com.example.updatingindiatwo.CovidNews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.updatingindiatwo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class COvidNewsDashboard extends AppCompatActivity {
    ProgressBar progressBar;
    TextView news1,news2,news3,news4,news5,news6,news7,news8,news9,news10,lastUpdates;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_ovid_news_dashboard);
        scrollView=findViewById(R.id.scroll_view);
        news1=findViewById(R.id.news_one);
        news2=findViewById(R.id.news_two);
        news3=findViewById(R.id.news_three);
        news4=findViewById(R.id.news_four);
        news5=findViewById(R.id.news_five);
        news6=findViewById(R.id.news_six);
        news7=findViewById(R.id.news_seven);
        news8=findViewById(R.id.news_eight);
        news9=findViewById(R.id.news_nine);
        news10=findViewById(R.id.news_ten);
        lastUpdates=findViewById(R.id.last_updates);

        progressBar=findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        displayNewsContent();

    }

    private void displayNewsContent() {
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference("news");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                news1.setText(datasnapshot.child("news1").getValue(String.class));
                news2.setText(datasnapshot.child("news2").getValue(String.class));
                news3.setText(datasnapshot.child("news3").getValue(String.class));
                news4.setText(datasnapshot.child("news4").getValue(String.class));
                news5.setText(datasnapshot.child("news5").getValue(String.class));
                news6.setText(datasnapshot.child("news6").getValue(String.class));
                news7.setText(datasnapshot.child("news7").getValue(String.class));
                news8.setText(datasnapshot.child("news8").getValue(String.class));
                news9.setText(datasnapshot.child("news9").getValue(String.class));
                news10.setText(datasnapshot.child("news10").getValue(String.class));
                lastUpdates.setText(datasnapshot.child("lastupdates").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(COvidNewsDashboard.this, "Data not found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
