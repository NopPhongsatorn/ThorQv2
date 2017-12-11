package com.advproject.phongsatorn.thorqv2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PromotionOnce extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.promotion_once);

        TextView title = (TextView)findViewById(R.id.titlePromo);
        String titleShow = getIntent().getExtras().getString("Title");
        title.setText(titleShow);

        TextView description = (TextView)findViewById(R.id.descPromo);
        String descShow = getIntent().getExtras().getString("Description");
        description.setText(descShow);

        ImageView imgOrder = (ImageView)findViewById(R.id.imgPromo);
        Picasso
                .with(this)
                .load(getIntent().getExtras().getString("img"))
                .into(imgOrder);
    }
}
