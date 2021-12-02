package com.example.examenfinalapps.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinalapps.Modelos.Contacto;
import com.example.examenfinalapps.Modelos.accion;
import com.example.examenfinalapps.R;

import java.util.List;

public class adaptadorContactos extends RecyclerView.Adapter<adaptadorContactos.ViewHolder> {
    private List<accion> Lista;

    public adaptadorContactos(List<accion> lista) {
        Lista = lista;
    }

    @NonNull
    @Override
    public adaptadorContactos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorContactos.ViewHolder holder, int position) {
          accion c=Lista.get(position);
          holder.bind(c);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Nombre;
        TextView Acciones;
        Contacto con;
        accion ac;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.txt1);
            Acciones = itemView.findViewById(R.id.txt2);
            itemView.setOnClickListener(this);
        }

        public void bind(accion c) {
            Nombre.setText(c.getAccion());
            Acciones.setText(c.getDescripcion());
            ac=c;
        }

        @Override
        public void onClick(View v) {
             switch (ac.getId()){
                 case 1:
                     Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"8714576501"));
                     v.getContext().startActivity(i);
                     break;
                 case 2:
                     Intent e=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                     v.getContext().startActivity(e);
                     break;
                 case 3:
                     Intent f=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps"));
                     v.getContext().startActivity(f);
                     break;
                 case 4:
                     Intent j=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8714576501"));
                     v.getContext().startActivity(j);
                     break;
             }
        }
    }
}
