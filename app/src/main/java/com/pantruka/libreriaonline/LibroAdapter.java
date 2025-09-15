package com.pantruka.libreriaonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

 // El objetivo de esta clase es "enlazar" la lista de libros con RecyclerView mostrando cada libro en una fila personalizada.
 public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {
    private Context context;
    private List<Libro> listaLibros;
    private OnLibroClickListener listener;

    public interface OnLibroClickListener {
        void onLibroClick(Libro libro);
    }

    public LibroAdapter(Context context, List<Libro> listaLibros, OnLibroClickListener listener) {
        this.context = context;
        this.listaLibros = listaLibros;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_libro, parent, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        Libro libro = listaLibros.get(position);
        holder.tvNombre.setText(libro.getNombre());

        // Convertir el string "@drawable/tomo_01" en recurso real para que use la aplicacion
        int resId = context.getResources().getIdentifier(
                libro.getRutaIMG(), "drawable", context.getPackageName());

        if (resId != 0) {
            holder.imgLibro.setImageResource(resId);
        }

        // Acción del botón
        holder.btnAccion.setOnClickListener(v -> {
            if (listener != null) {
                listener.onLibroClick(libro);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    static class LibroViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        ImageView imgLibro;
        Button btnAccion;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            imgLibro = itemView.findViewById(R.id.imgLibro);
            btnAccion = itemView.findViewById(R.id.btnAccion);
        }
    }
}