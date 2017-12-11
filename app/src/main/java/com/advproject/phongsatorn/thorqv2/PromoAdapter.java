package com.advproject.phongsatorn.thorqv2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoViewHolder>{
    private List<PromoModel> promotion;
    private Context context;

    public PromoAdapter(Context c , List<PromoModel> promotion){
        this.promotion = promotion;
        this.context = c;
    }

    @Override
    public PromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PromoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final PromoViewHolder holder, final int position) {
        PromoModel promo = promotion.get(position);

        holder.title.setText(promo.title);
        holder.desc.setText(promo.desc);
        Picasso.with(context).load(promo.img).placeholder(R.drawable.placeholder).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , PromotionOnce.class);
                intent.putExtra("Title",promotion.get(position).getTitle());
                intent.putExtra("Description",promotion.get(position).getDesc());
                intent.putExtra("img",promotion.get(position).getImg());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return promotion.size();
    }

    public class PromoViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView img;

        public PromoViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titlePromo);
            desc = (TextView) itemView.findViewById(R.id.descPromo);
            img = (ImageView)itemView.findViewById(R.id.imgPromo);
        }
    }
}
