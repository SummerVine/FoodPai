package com.green.foodpai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.green.foodpai.R;
import com.green.foodpai.bean.Wiki;

import java.util.List;

/**
 * Created by 86724 on 2016/7/3 0003.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Context context;
    private List<Wiki.GroupBean> data;
    private LayoutInflater inflater;
    private int index = 0;

    public RvAdapter(List<Wiki.GroupBean> data, Context context,int index){
        this.data = data;
        this.index = index;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.wiki_item_layout,null));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(index).getCategories().get(position).getName());
        Glide.with(context).load(data.get(index).getCategories().get(position).getImage_url()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(data.size()==0){
            return data.size();
        }else {
            return data.get(index).getCategories().size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = ((ImageView) itemView.findViewById(R.id.wiki_item_iv));
            textView = ((TextView) itemView.findViewById(R.id.wiki_item_tv));
        }
    }
    public void addAll(List<Wiki.GroupBean> dd){
        data.addAll(dd);
        notifyDataSetChanged();
    }
}
