package br.digitalhouse.desafioandroidlucaspereira.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import br.digitalhouse.desafioandroidlucaspereira.R;

public class LoginActivity extends AppCompatActivity {




        TextInputLayout emaillogin;
        TextInputLayout senhalogin;
        Button buttonlogin;
        Button buttonregistrar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);


            emaillogin = findViewById(R.id.tILEmail);
            senhalogin = findViewById(R.id.tILSenha);
            buttonlogin = findViewById(R.id.buttonLogin);
            buttonregistrar = findViewById(R.id.buttonRegister);

            buttonlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String senha = senhalogin.getEditText().getText().toString();
                    String email = emaillogin.getEditText().getText().toString();


                    if (!senha.isEmpty() && !email.isEmpty()) {

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("SENHA", senha);
                        bundle.putString("EMAIL", email);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    } else {

                        emaillogin.setError("O campo não pode estar vazio");
                        senhalogin.setError("O campo não pode estar vazio");
                    }

                }
            });

            buttonregistrar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent2 = new Intent(LoginActivity.this, CadastroActivity.class);
                    startActivity(intent2);
                }

            });


        }
    }

