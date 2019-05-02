package com.zulfahmi.kuliahlistview;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESC = "extra_desc";

    ImageView ivPhoto;
    TextView tvName, tvDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivPhoto = findViewById(R.id.img_photo);
        tvName = findViewById(R.id.txt_name);
        tvDesc = findViewById(R.id.txt_description);

        ivPhoto.setImageResource(getIntent().getIntExtra(EXTRA_PHOTO, 0));
        tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvDesc.setText(getIntent().getStringExtra(EXTRA_DESC));
    }
}
