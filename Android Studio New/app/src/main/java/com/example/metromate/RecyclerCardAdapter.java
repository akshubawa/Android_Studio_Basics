package com.example.metromate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

        String line = arrCard.get(position).line;
        if(line.equals("Blue")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroBlue));
        }
        else if(line.equals("Bluebranch")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroBlueBranch));
        }
        else if(line.equals("Magenta")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroMagenta));
        }
        else if(line.equals("Yellow")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroYellow));
        }
        else if(line.equals("Red")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroRed));
        }
        else if(line.equals("Green")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroGreen));
        }
        else if(line.equals("Greenbranch")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroGreenBranch));
        }
        else if(line.equals("Violet")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroViolet));
        }
        else if(line.equals("Pink")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroPink));
        }
        else if(line.equals("Pinkbranch")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroPinkBranch));
        }
        else if(line.equals("Orange")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroOrange));
        }
        else if(line.equals("Aqua")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroAqua));
        }
        else if(line.equals("Grey")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroGrey));
        }
        else if(line.equals("Rapidmetro")) {
            holder.metro_color.setBackgroundColor(context.getResources().getColor(R.color.metroRapid));
        }

    }

    @Override
    public int getItemCount() {
        return arrCard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView path_name, path_line;
        LinearLayout metro_color;
        public ViewHolder(View itemView) {
            super(itemView);

            path_name = itemView.findViewById(R.id.path_name);
            path_line = itemView.findViewById(R.id.path_line);
            metro_color = itemView.findViewById(R.id.metro_color);

        }
    }
}
