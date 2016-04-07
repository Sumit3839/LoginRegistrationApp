package com.example.sumit.loginregistrationapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sumit on 15-01-2016.
 */
public class DBAdapter extends RecyclerView.Adapter<DBAdapter.MyViewHolder> {
    List<Login> logins;
    Context context;

    DBAdapter(Context context, List<Login> objects) {
        this.context = context;
        logins = objects;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Login login = logins.get(position);
        holder.txt1.setText(login.getName());
        holder.txt2.setText(login.getPass());
        holder.txt3.setText(login.getEmail());
        holder.txt4.setText(login.getNo());
        holder.txt5.setText(login.getUsername());
    }

    @Override
    public int getItemCount() {
        return logins.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt1, txt2, txt3, txt4, txt5;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt1 = (TextView) itemView.findViewById(R.id.tt);
            txt2 = (TextView) itemView.findViewById(R.id.tt1);
            txt3 = (TextView) itemView.findViewById(R.id.tt2);
            txt4 = (TextView) itemView.findViewById(R.id.tt3);
            txt5 = (TextView) itemView.findViewById(R.id.tt4);
        }


    }
}
