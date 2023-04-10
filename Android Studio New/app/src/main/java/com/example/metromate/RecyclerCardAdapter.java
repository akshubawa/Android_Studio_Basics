package com.example.metromate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.ViewHolder> {

    Context context;
    ArrayList<CardModel> arrCard;
    RecyclerCardAdapter(Context context, ArrayList<CardModel> arrCard) {
        this.context = context;
        this.arrCard = arrCard;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.path_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.path_name.setText(arrCard.get(position).name);
        holder.path_line.setText(arrCard.get(position).line);

    }

    @Override
    public int getItemCount() {
        return arrCard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView path_name, path_line;
        public ViewHolder(View itemView) {
            super(itemView);

            path_name = itemView.findViewById(R.id.path_name);
            path_line = itemView.findViewById(R.id.path_line);
        }
    }
}
