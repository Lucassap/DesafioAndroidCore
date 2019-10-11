package br.digitalhouse.desafioandroidlucaspereira.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.digitalhouse.desafioandroidlucaspereira.Model.Prato;
import br.digitalhouse.desafioandroidlucaspereira.R;



public class VerPratoActivity extends AppCompatActivity {
    private TextView nome;
    private TextView detalhe;
    private ImageView imagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prato);
        nome = findViewById(R.id.detalheNomePrato);
        detalhe = findViewById(R.id.detalhePrato);
        imagem = findViewById(R.id.detalheImagemPrato);

        if(getIntent() != null && getIntent().getExtras() != null ){
            Prato prato = getIntent().getExtras().getParcelable("PRATO");
            Drawable drawable = getResources().getDrawable(prato.getImagem());
            imagem.setImageDrawable(drawable);
            nome.setText(prato.getNome());
            detalhe.setText(prato.getDescricao());
        }

    }
}
