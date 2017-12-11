package com.advproject.phongsatorn.thorqv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ReserveActivity extends AppCompatActivity {

    private Button backHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        TextView title = (TextView)findViewById(R.id.txtTitle);
        String titleShow = getIntent().getExtras().getString("Title");
        title.setText(titleShow);

        TextView description = (TextView)findViewById(R.id.txtDescription);
        String descShow = getIntent().getExtras().getString("Description");
        description.setText(descShow);

        TextView que = (TextView)findViewById(R.id.txtQue);
        int queShow = getIntent().getExtras().getInt("Que");
        que.setText(queShow+"");

        ImageView imgOrder = (ImageView)findViewById(R.id.img);
        Picasso
                .with(this)
                .load(getIntent().getExtras().getString("img"))
                .into(imgOrder);

        TextView counterTxt = (TextView)findViewById(R.id.counterTxt);
        String counterShow = getIntent().getExtras().getString("Counter");
        counterTxt.setText(counterShow);

        backHomeBtn = (Button) findViewById(R.id.backHomeBtn);
        backHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReserveActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
