package br.digitalhouse.desafioandroidlucaspereira.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.digitalhouse.desafioandroidlucaspereira.R;

public class CadastroActivity extends AppCompatActivity {

    TextInputLayout nomecad;
    TextInputLayout emailcad;
    TextInputLayout senhacad;
    TextInputLayout repetirsenhacad;
    Button buttonregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nomecad = findViewById(R.id.tILNomeCadastro);
        emailcad = findViewById(R.id.tILEmailCadastro);
        senhacad = findViewById(R.id.tILSenhaCadastro);
        repetirsenhacad = findViewById(R.id.tILRepetirSenhaCadastro);
        buttonregistrar = findViewById(R.id.buttonRegistrarCadastro);

        buttonregistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                String nome= nomecad.getEditText().getText().toString();
                String senha = senhacad.getEditText().getText().toString();
                String email = emailcad.getEditText().getText().toString();
                String senharepetida = repetirsenhacad.getEditText().getText().toString();


                if(!nome.isEmpty() && !senharepetida.isEmpty() && !senha.isEmpty() && !email.isEmpty()){
                    if (senha.equals(senharepetida)){
                        Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("NOME", nome);
                        bundle.putString("SENHA", senha);
                        bundle.putString("EMAIL", email);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }

                    else {
                        repetirsenhacad.setError("O campo não pode estar vazio");
                    }
                }

                else {
                    nomecad.setError("O campo não pode estar vazio");
                    emailcad.setError("O campo não pode estar vazio");
                    repetirsenhacad.setError("O campo não pode estar vazio");
                    senhacad.setError("O campo não pode estar vazio");
            }

            }
        });

    }
}
