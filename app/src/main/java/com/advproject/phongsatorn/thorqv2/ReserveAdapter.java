package com.advproject.phongsatorn.thorqv2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ReserveAdapter extends RecyclerView.Adapter<ReserveAdapter.ReserveViewHolder>{
    private List<OrderModel> list;
    private Context context;

    public ReserveAdapter(Context c , List<OrderModel> list){
        this.list = list;
        this.context = c;
    }

    @Override
    public ReserveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReserveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_que, parent, false));
    }

    @Override
    public void onBindViewHolder(final ReserveAdapter.ReserveViewHolder holder, final int position) {
        OrderModel order = list.get(position);

        holder.title.setText(order.title);
        holder.desc.setText(order.desc);
        holder.que.setText(Integer.toString(order.que));
        Picasso.with(context).load(order.img).placeholder(R.drawable.placeholder).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , ReserveActivity.class);
                intent.putExtra("Title",list.get(position).getTitle());
                intent.putExtra("Description",list.get(position).getDesc());
                intent.putExtra("Que",list.get(position).getQue());
                intent.putExtra("img",list.get(position).getImg());



                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReserveViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc, que;
        ImageView img;

        public ReserveViewHolder(View itemView){
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.txtTitle);
            desc = (TextView) itemView.findViewById(R.id.txtDescription);
            que = (TextView) itemView.findViewById(R.id.txtQue);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
