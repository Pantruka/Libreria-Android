package com.pantruka.libreriaonline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LibrosFragment extends Fragment implements LibroAdapter.OnLibroClickListener {

    private final List<Libro> listaLibros = new ArrayList<>();
    private RecyclerView recyclerLibros;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_libros, container, false);

        recyclerLibros = view.findViewById(R.id.recycler_libros);
        recyclerLibros.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Limpiar la lista antes de crear los libros, para que no se repitan si es que vuelvo a la vista de "Libros"
        listaLibros.clear();
        crearLibros();

        LibroAdapter adapter = new LibroAdapter(getContext(), listaLibros, this);
        recyclerLibros.setAdapter(adapter);

        return view;
    }

    private void crearLibros() { // Creo los libros, que por ahora coinciden con la cantidad de "tomos" que hay en drawable
        listaLibros.add(new Libro("Li0001", "Tomo 1: Solo Leveling",
                "Sung Jin-Woo es el cazador más débil de toda la humanidad. En este mundo lleno de peligros, los cazadores luchan contra monstruos para proteger a la sociedad. Todo cambia cuando Jin-Woo obtiene el poder único de subir de nivel.",
                "tomo_1"));

        listaLibros.add(new Libro("Li0002", "Tomo 2: Solo Leveling",
                "Jin-Woo continúa desarrollando sus habilidades únicas. Con cada batalla, se vuelve más fuerte, pero también descubre que el mundo de los cazadores esconde secretos más oscuros de lo que imaginaba.",
                "tomo_2"));

        listaLibros.add(new Libro("Li0003", "Tomo 3: Solo Leveling",
                "Las habilidades de Jin-Woo alcanzan nuevos niveles. Mientras enfrenta enemigos cada vez más poderosos, comienza a comprender la verdadera naturaleza de su poder y el destino que le espera.",
                "tomo_3"));

        listaLibros.add(new Libro("Li0004", "Tomo 4: Solo Leveling",
                "Jin-Woo se convierte en una fuerza imparable. Sus batallas épicas contra jefes de mazmorras revelan secretos sobre el origen de los portales y la verdadera amenaza que se cierne sobre la humanidad.",
                "tomo_4"));

        listaLibros.add(new Libro("Li0005", "Tomo 5: Solo Leveling",
                "El poder de Jin-Woo continúa creciendo exponencialmente. En este volumen, enfrenta enemigos que desafían todo lo que creía saber sobre los límites del poder humano.",
                "tomo_5"));

        listaLibros.add(new Libro("Li0006", "Tomo 6: Solo Leveling",
                "Los misterios detrás de los portales comienzan a revelarse. Jin-Woo descubre conexiones sorprendentes entre su pasado y el futuro de la humanidad en su lucha contra las fuerzas oscuras.",
                "tomo_6"));

        listaLibros.add(new Libro("Li0007", "Tomo 7: Solo Leveling",
                "Jin-Woo enfrenta sus mayores desafíos hasta ahora. Las batallas se vuelven más intensas y las revelaciones sobre su verdadera naturaleza cambian todo lo que creía saber sobre sí mismo.",
                "tomo_7"));

        listaLibros.add(new Libro("Li0008", "Tomo 8: Solo Leveling",
                "El climax se acerca. Jin-Woo debe tomar decisiones que determinarán no solo su propio destino, sino el futuro de toda la humanidad en su guerra contra las sombras.",
                "tomo_8"));

        listaLibros.add(new Libro("Li0009", "Tomo 9: Solo Leveling",
                "Las fuerzas finales se alinean para la batalla definitiva. Jin-Woo alcanza niveles de poder que trascienden lo humano, preparándose para el enfrentamiento que decidirá el destino del mundo.",
                "tomo_9"));

        listaLibros.add(new Libro("Li0010", "Tomo 10: Solo Leveling",
                "La batalla final comienza. Jin-Woo debe usar todo su poder y sabiduría acumulada para enfrentar la amenaza más grande que la humanidad haya conocido jamás.",
                "tomo_10"));

        listaLibros.add(new Libro("Li0011", "Tomo 11: Solo Leveling",
                "La conclusión épica de la saga. Todos los misterios se revelan, todas las batallas llegan a su fin, y el destino de Jin-Woo y la humanidad se decide para siempre.",
                "tomo_11"));
    }

    @Override
    public void onLibroClick(Libro libro) { // Recibe el objeto libro y remplaza la vista actual con el fragmento de detalles, también permite que el usuario vuelva a la página de Libros con el boton volver.
        LibroDetallesFragment detailFragment = LibroDetallesFragment.newInstance(libro);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}