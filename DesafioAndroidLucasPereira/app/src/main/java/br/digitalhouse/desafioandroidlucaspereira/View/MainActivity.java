package br.digitalhouse.desafioandroidlucaspereira.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.desafioandroidlucaspereira.Adapter.RestauranteAdapter;
import br.digitalhouse.desafioandroidlucaspereira.Interface.OnclickRecyclerRes;
import br.digitalhouse.desafioandroidlucaspereira.Model.Prato;
import br.digitalhouse.desafioandroidlucaspereira.Model.Restaurante;
import br.digitalhouse.desafioandroidlucaspereira.R;

public class MainActivity extends AppCompatActivity implements OnclickRecyclerRes {
    private RecyclerView recycler;
    private RestauranteAdapter adaptador;
    private List<Restaurante> listarestaurantes = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recicladorRestaurante);
        adaptador = new RestauranteAdapter(retornarListaRestaurantes(), this);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(this));

    }


    public List<Restaurante> retornarListaRestaurantes(){

        List<Prato> pratospoleto = new ArrayList<>();
        pratospoleto.add(new Prato("Massa", "Boa pra xuxu", R.drawable.panetone));
        listarestaurantes.add(new Restaurante("Spoleto", "Fecha as 20h" + "\t" + " (Exceto feriados) ", "Rua Magnolia 123", R.drawable.restaurantespoletto, pratospoleto));
        listarestaurantes.add(new Restaurante("La Casa Guapa", "Fecha as 18h", "Rua Davinte 342", R.drawable.restaurante1, pratospoleto));
        listarestaurantes.add(new Restaurante("Canto do Arlindo", "Fecha as 19h", "Rua Papalito 222", R.drawable.restaurante2, pratospoleto));
        listarestaurantes.add(new Restaurante("Bico da Cana" , "Fecha as 21h", "Avenida Arruda 232", R.drawable.restaurante3, pratospoleto));



        return listarestaurantes;
    }


    @Override
    public void clicarRestautante(Restaurante restaurante) {
        Intent intent = new Intent(MainActivity.this, ListaPratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESTAURANTE", restaurante);
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
