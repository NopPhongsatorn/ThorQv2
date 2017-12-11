package com.advproject.phongsatorn.thorqv2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class OrderQ extends AppCompatActivity {

    private ImageButton backBtn;
    private TextView counterTxt,title,description;
    private ImageButton plusBtn;
    private ImageButton minusBtn;
    private Button reserveBtn;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.minusBtn :
                    minusCounter();
                    break;
                case R.id.plusBtn :
                    plusCounter();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_que);

        title = (TextView)findViewById(R.id.txtTitle);
        String titleShow = getIntent().getExtras().getString("Title");
        title.setText(titleShow);

        description = (TextView)findViewById(R.id.txtDescription);
        String descShow = getIntent().getExtras().getString("Description");
        description.setText(descShow);

        final TextView que = (TextView)findViewById(R.id.txtQue);
        int queShow = getIntent().getExtras().getInt("Que");
        que.setText(queShow+"");

        final ImageView imgOrder = (ImageView)findViewById(R.id.img);
        Picasso
                .with(this)
                .load(getIntent().getExtras().getString("img"))
                .into(imgOrder);

        backBtn = (ImageButton) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderQ.this,MainActivity.class);
                startActivity(intent);
            }
        });

        reserveBtn = (Button) findViewById(R.id.reserveBtn);
        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderQ.this, ReserveActivity.class);
                intent.putExtra("Title",title.getText());
                intent.putExtra("Description",description.getText());
                intent.putExtra("Que",Integer.parseInt(que.getText().toString()));
                intent.putExtra("img",getIntent().getExtras().getString("img"));

                startActivity(intent);
            }
        });

        counterTxt = (TextView) findViewById(R.id.counterTxt);
        plusBtn = (ImageButton) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        minusBtn = (ImageButton) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);

        initCounter();

        //Toast.makeText(this,titleShow, Toast.LENGTH_SHORT).show();
    }

    private void initCounter(){
        counter = 1;
        counterTxt.setText(counter+"");
    }

    private void plusCounter() {
        if (counter > 98) {
            counter = 99;
            counterTxt.setText(counter+"");
        } else {
            counter++;
            counterTxt.setText(counter+"");
        }
    }

    private void minusCounter() {
        if (counter < 2) {
            counter = 1;
            counterTxt.setText(counter+"");
        } else {
            counter--;
            counterTxt.setText(counter+"");
        }
    }


}
