package br.digitalhouse.desafioandroidlucaspereira.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.desafioandroidlucaspereira.Adapter.PratoAdapter;
import br.digitalhouse.desafioandroidlucaspereira.Interface.InterfacePratoOnClick;
import br.digitalhouse.desafioandroidlucaspereira.Model.Prato;
import br.digitalhouse.desafioandroidlucaspereira.Model.Restaurante;
import br.digitalhouse.desafioandroidlucaspereira.R;


public class ListaPratoActivity extends AppCompatActivity implements InterfacePratoOnClick {

    private RecyclerView recycler;
    private PratoAdapter adaptador;
    private ImageView  imagem;
    private TextView titulorestaurante;
    private List<Prato> listapratos = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prato);
        recycler = findViewById(R.id.recicladorprato);
        imagem = findViewById(R.id.fotodorestauranteprato);
        titulorestaurante = findViewById(R.id.txtNomeRestauranteprato);



        if(getIntent() != null && getIntent().getExtras() != null ){
            Restaurante restaurante = getIntent().getExtras().getParcelable("RESTAURANTE");
            Drawable drawable = getResources().getDrawable(restaurante.getImagem());
            imagem.setImageDrawable(drawable);
            listapratos = restaurante.getListapratos();
            titulorestaurante.setText(restaurante.getNome());
            adaptador = new PratoAdapter(restaurante.retornarListaPratos(),this);
            recycler.setAdapter(adaptador);
            recycler.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }




    @Override
    public void clicar(Prato prato) {
        Intent intent = new Intent(ListaPratoActivity.this, VerPratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("PRATO", prato);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
