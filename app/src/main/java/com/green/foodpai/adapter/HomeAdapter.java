package com.green.foodpai.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.green.foodpai.R;
import com.green.foodpai.bean.Feeds;

import java.util.List;

/**
 * Created by green on 2016/7/3.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Feeds.FeedsBean> data;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    public HomeAdapter(List<Feeds.FeedsBean> data, Context context){
        this.data = data;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    public enum ITEM_TYPE{
        ITEM_TYPE1,
        ITEM_TYPE2
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE.ITEM_TYPE1.ordinal()){
           return new Item1ViewHolder(inflater.inflate(R.layout.first_fragment_item1,parent,false));
        }else {
            return new Item2ViewHolder(inflater.inflate(R.layout.first_fragment_item2,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Item1ViewHolder) {
            Glide.with(context).load(data.get(position).getBackground()).into(((Item1ViewHolder) holder).iv_background_id);
            ((Item1ViewHolder) holder).tv_auther1_id.setTextColor(Color.WHITE);
            ((Item1ViewHolder) holder).tv_auther1_id.setText(data.get(position).getSource());
            ((Item1ViewHolder) holder).tv_title1_id.setTextColor(Color.WHITE);
            ((Item1ViewHolder) holder).tv_title1_id.setText(data.get(position).getTitle());
            ((Item1ViewHolder) holder).tv_number1_id.setTextColor(Color.WHITE);
            ((Item1ViewHolder) holder).tv_number1_id.setText(data.get(position).getTail());

        } else if (holder instanceof Item2ViewHolder) {
            ((Item2ViewHolder) holder).tv_auther2_id.setTextColor(Color.GRAY);
            ((Item2ViewHolder) holder).tv_auther2_id.setText(data.get(position).getSource());
            ((Item2ViewHolder) holder).tv_title2_id.setTextColor(Color.BLACK);
            ((Item2ViewHolder) holder).tv_title2_id.setText(data.get(position).getTitle());
            ((Item2ViewHolder) holder).tv_number2_id.setTextColor(Color.GRAY);
            ((Item2ViewHolder) holder).tv_number2_id.setText(data.get(position).getTail());
        }
    }
    @Override
    public int getItemViewType(int position) {
        return data.get(position).getBackground()==""? ITEM_TYPE.ITEM_TYPE1.ordinal():ITEM_TYPE.ITEM_TYPE2.ordinal();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void addAll(List<Feeds.FeedsBean> dd){
        data.addAll(dd);
        notifyDataSetChanged();
    }
    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }




    class Item1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final ImageView iv_auther1_id ,iv_background_id;
        private final TextView tv_number1_id,tv_auther1_id,tv_title1_id;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            iv_auther1_id = ((ImageView) itemView.findViewById(R.id.iv_auther1_id));
            iv_background_id = ((ImageView) itemView.findViewById(R.id.iv_background_id));
            tv_number1_id = ((TextView) itemView.findViewById(R.id.tv_number1_id));
            tv_auther1_id = ((TextView) itemView.findViewById(R.id.tv_auther1_id));
            tv_title1_id = ((TextView) itemView.findViewById(R.id.tv_title1_id));
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getLayoutPosition(), v);
        }


    }
    class Item2ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final ImageView iv_auther2_id;
        private final TextView tv_number2_id, tv_auther2_id, tv_title2_id;

        public Item2ViewHolder(View itemView) {
            super(itemView);
            iv_auther2_id = ((ImageView) itemView.findViewById(R.id.iv_auther2_id));
            tv_number2_id = ((TextView) itemView.findViewById(R.id.tv_number2_id));
            tv_auther2_id = ((TextView) itemView.findViewById(R.id.tv_auther2_id));
            tv_title2_id = ((TextView) itemView.findViewById(R.id.tv_title2_id));
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getLayoutPosition(), v);
        }

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }


    public interface  OnItemClickListener{
        public void onItemClick(int position, View itemView);
    }
}
