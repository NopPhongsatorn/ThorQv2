package com.advproject.phongsatorn.thorqv2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class OrderQ extends AppCompatActivity {

    private ImageButton backBtn;
    private TextView counterTxt;
    private ImageButton plusBtn;
    private ImageButton minusBtn;
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

//        ImageView img1 = (ImageView) findViewById(R.id.table1);
//        ImageView img2 = (ImageView) findViewById(R.id.table2);
//        ImageView img3 = (ImageView) findViewById(R.id.table3);
//        int imgResource1 = getResources().getIdentifier("@drawable/table1", null , this.getPackageName());
//        int imgResource2 = getResources().getIdentifier("@drawable/table2", null , this.getPackageName());
//        int imgResource3 = getResources().getIdentifier("@drawable/table3", null , this.getPackageName());
//        img1.setImageResource(imgResource1);
//        img2.setImageResource(imgResource2);
//        img3.setImageResource(imgResource3);

        backBtn = (ImageButton) findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderQ.this,MainActivity.class);
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
