package com.example.esearch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esearch.Api.Api;
import com.example.esearch.Api.RequestHelper;
import com.example.esearch.Helper.HttpsTrustManager;
import com.example.esearch.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private TextView txtcadastro;
    private TextView forgot;
    private EditText edit_email, edit_senha;
    private Button btn_entrar;
    private ProgressBar progressBar;
    private String Semail,Ssenha,Snome;
    private int Sid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IniciarComponentes();


        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = edit_email.getText().toString();
                String Senha = edit_senha.getText().toString();
                if (Email.isEmpty() || Senha.isEmpty()) {

                    Toast.makeText(LoginActivity.this,
                            "preencha todos os campos",
                            Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(Email)) {

                    edit_email.setError("Por favor entre com o nome");
                    edit_email.requestFocus();
                    return;

                } else if (TextUtils.isEmpty(Senha)) {
                    edit_senha.setError("Por favor entre com o email");
                    edit_senha.requestFocus();
                    return;

                } else {

                    logar(Email, Senha);
                    SalvarDadosDispositivo(Email,Senha);


                }
            }
        });

        txtcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void Progressbar() {

        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    public void logar(String Email, String Senha) {


        HttpsTrustManager.allowAllSSL();

        final ProgressDialog progressDialog = new ProgressDialog(this);

        RequestHelper req = new RequestHelper(this, Api.URL_logar_Usuario, new RequestHelper.IRequests() {
            @Override
            public void Pre() {

            }

            @Override
            public void Pos(JSONObject jsonObject) throws JSONException {

                if (jsonObject.getInt("error") == 1) {
                    Progressbar();


                }
                else if (jsonObject.getInt("error") == 5) {
                    Toast.makeText(getApplicationContext(), "Email e/ou Senha invalido(s)", Toast.LENGTH_LONG).show();
                    edit_email.requestFocus();
                }

            }

            @Override
            public void Error() {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Não foi possivel realizar o procedimento, verifique sua conexão!", Toast.LENGTH_LONG).show();
            }

            @Override
            public HashMap<String, String> params() {
                HashMap hashMap = new HashMap();
                hashMap.put("email", Email);
                hashMap.put("senha", Senha);
                return hashMap;
            }
        });
        req.execRequest();
    }

    public void IniciarComponentes() {

        txtcadastro = findViewById(R.id.sing_in);
        forgot = findViewById(R.id.forgotpassowrd);
        edit_email = findViewById(R.id.email);
        edit_senha = findViewById(R.id.senha);
        btn_entrar = findViewById(R.id.btnEntrar);
        progressBar = findViewById(R.id.progressbar);
        edit_email.requestFocus();
    }
    public void SalvarDadosDispositivo(String Email, String Senha){

        SharedPreferences sharedPrefe = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefe.edit();
        editor.putString("email",Email);
        editor.putString("senha",Senha);
        editor.commit();
        editor.apply();

    }
}