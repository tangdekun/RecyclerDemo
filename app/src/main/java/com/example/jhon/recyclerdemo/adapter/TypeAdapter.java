package com.example.jhon.recyclerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhon.recyclerdemo.R;
import com.example.jhon.recyclerdemo.bean.TypeData;

import java.util.List;

/**
 * Created by tangdekun on 2016/12/10.
 */

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {

    List<TypeData> typeDatas;
    Context context;
    public TypeAdapter(List<TypeData> typeDatas,Context context){
        if (this.typeDatas!=null && this.typeDatas.size()>0){
            this.typeDatas.clear();
        }
        this.typeDatas =  typeDatas;
        this.context = context;

    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        View typeView;
        TextView titleTv;

        public ViewHolder(View itemView) {
            super(itemView);
            typeView = itemView;
            titleTv = (TextView) itemView.findViewById(R.id.item_title);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_type,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TypeData mTypeData = typeDatas.get(position);
        holder.titleTv.setText(mTypeData.getName());
        holder.typeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mTypeData.getId()+mTypeData.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return typeDatas.size();
    }
}
