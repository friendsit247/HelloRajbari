package com.friendsit.hellorajbari;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HelloAdapter extends RecyclerView.Adapter<HelloAdapter.HelloViewHolder> {
    private Context context;
    private List<HelloModel> list;

    public HelloAdapter(Context context, List<HelloModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HelloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_layout,parent,false);
        return new HelloViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelloViewHolder holder, int position) {
        holder.nameTv.setText(list.get(position).getNam());
        holder.titleTv.setText(list.get(position).getTit());
        holder.phoneTv.setText(list.get(position).getPho());

        holder.dialBtn.setOnClickListener(view -> {
            dialBtnOnClick(list.get(position).getPho());
        });
    }

    private void dialBtnOnClick(String Phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"+88"+Phone.trim()));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HelloViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv,titleTv,phoneTv;
        private FloatingActionButton dialBtn;
        public HelloViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            titleTv = itemView.findViewById(R.id.titleTv);
            phoneTv = itemView.findViewById(R.id.phoneTv);
            dialBtn = itemView.findViewById(R.id.dialBtn);
        }
    }
}
