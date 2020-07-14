package com.example.digikalamvvm.PushNotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.digikalamvvm.R;
import com.example.digikalamvvm.databinding.ActivityShowNotificationBinding;
import com.example.digikalamvvm.model.NotficationModel;

public class ActivityShowNotification extends AppCompatActivity {


    private ActivityShowNotificationBinding binding;
    private TextView Tv_title;
    private TextView Tv_content;
    TextView Tv_date;
    NotficationModel notficationModel =new NotficationModel();

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_notification);
        Tv_title=binding.title;
        Tv_content=binding.content;
        Tv_date = binding.date;

       notficationModel.setTitle( getIntent().getStringExtra("title"));
        notficationModel.setDate( getIntent().getStringExtra("date"));
        notficationModel.setContent( getIntent().getStringExtra("content"));
        notficationModel.setImage( getIntent().getStringExtra("image"));

        binding.setData(notficationModel);


    }
}