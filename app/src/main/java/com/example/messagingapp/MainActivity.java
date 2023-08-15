package com.example.messagingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Mychannel";
    private static final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCall , btnMsg , btnEmail , btnShare , btnNotify;



        btnCall = findViewById(R.id.Call);
        btnMsg = findViewById(R.id.Message);
        btnEmail = findViewById(R.id.Email);
        btnShare = findViewById(R.id.Share);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDail = new Intent(Intent.ACTION_DIAL);
                iDail.setData(Uri.parse("tel: +918074833394"));
                startActivity(iDail);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("8074833394")));
                iMsg.putExtra("sms_body","Please Solve this Issue ASAP");
                startActivity(iMsg);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"ahamedkhalid8074@gmail.com","ahamedkhalid950@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");  //Subject
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please Resolve this issue ASAP"); //Body
                startActivity(Intent.createChooser(iEmail,"Email via")); // chooser

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Download this"); // message to share
                startActivity(Intent.createChooser(iShare,"Share Via"));
            }
        });



    }
}