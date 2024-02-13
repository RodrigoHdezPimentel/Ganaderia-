package com.example.ganadariasplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExplotacionAdapter extends RecyclerView.Adapter<ExplotacionAdapter.MyViewHolder> {

    Context context;
    ArrayList<ExplotacionModel> explotacionModels;

    public ExplotacionAdapter(FragmentActivity context, ArrayList<ExplotacionModel> explotacionModels){
        this.context = context;
        this.explotacionModels = explotacionModels;
    }
    @NonNull
    @Override
    public ExplotacionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_explotacion, parent, false);
        return new ExplotacionAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExplotacionAdapter.MyViewHolder holder, int position) {

        holder.id.setText(explotacionModels.get(position).getId());
        holder.nombre.setText(explotacionModels.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return explotacionModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, nombre;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.idExplotacion);
            nombre = itemView.findViewById(R.id.nombreExplotacion);
        }
    }
}
