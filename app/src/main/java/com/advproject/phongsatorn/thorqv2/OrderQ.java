package com.advproject.phongsatorn.thorqv2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class OrderQ extends AppCompatActivity {

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

        ImageView img1 = (ImageView) findViewById(R.id.table1);
        ImageView img2 = (ImageView) findViewById(R.id.table2);
        ImageView img3 = (ImageView) findViewById(R.id.table3);
        int imgResource1 = getResources().getIdentifier("@drawable/table1", null , this.getPackageName());
        int imgResource2 = getResources().getIdentifier("@drawable/table2", null , this.getPackageName());
        int imgResource3 = getResources().getIdentifier("@drawable/table3", null , this.getPackageName());
        img1.setImageResource(imgResource1);
        img2.setImageResource(imgResource2);
        img3.setImageResource(imgResource3);


        //Toast.makeText(this,titleShow, Toast.LENGTH_SHORT).show();
    }
}
