package com.example.updatingindiatwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.updatingindiatwo.DataBase.FeedbackHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {
    TextInputLayout phoneNumber, name, feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        phoneNumber = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        feedback = findViewById(R.id.feedback);
    }

    public void backbtn(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void storeFeedback(View view) {
        String Name = name.getEditText().getText().toString().trim();
        String PhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String Feedback = feedback.getEditText().getText().toString().trim();
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Feedback Data");
        FeedbackHelperClass addNewUser = new FeedbackHelperClass(PhoneNumber, Name, Feedback);
        reference.child(PhoneNumber).setValue(addNewUser);
        Toast.makeText(this,"Feedback submitted\npress back button\nor enter new feedback",Toast.LENGTH_SHORT).show();
    }
}
