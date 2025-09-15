package com.pantruka.libreriaonline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LibroDetallesFragment extends Fragment {

    private static final String ARG_LIBRO = "libro";
    private Libro libro;

    public static LibroDetallesFragment newInstance(Libro libro) {
        LibroDetallesFragment fragment = new LibroDetallesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_LIBRO, libro);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            libro = (Libro) getArguments().getSerializable(ARG_LIBRO);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_libros, container, false);

        ImageView imgLibro = view.findViewById(R.id.img_libro_detalle);
        TextView tvTitulo = view.findViewById(R.id.tv_titulo_detalle);
        TextView tvDescripcion = view.findViewById(R.id.tv_descripcion_detalle);
        Button btnVolver = view.findViewById(R.id.btn_volver);

        if (libro != null) {
            tvTitulo.setText(libro.getNombre());
            tvDescripcion.setText(libro.getDescripcion());

            int resId = getContext().getResources().getIdentifier(
                    libro.getRutaIMG(), "drawable", getContext().getPackageName());
            if (resId != 0) {
                imgLibro.setImageResource(resId);
            }
        }

        btnVolver.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });

        return view;
    }
}