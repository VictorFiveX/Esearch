package com.example.esearch.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.Toast;

import com.example.esearch.Api.Api;
import com.example.esearch.Api.RequestHelper;
import com.example.esearch.Helper.HttpsTrustManager;
import com.example.esearch.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class CadastroActivity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    private EditText editnome, editsenha, editemail, editrepsenha;
    private Button btnCadastrar;
    ImageView voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        IniciarComponentes();

        voltar = findViewById(R.id.voltar1);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtnome = editnome.getText().toString();
                String txtsenha = editsenha.getText().toString();
                String txtrepsenha = editrepsenha.getText().toString();
                String txtemail = editemail.getText().toString();

                if (txtnome.isEmpty() || txtsenha.isEmpty() || txtrepsenha.isEmpty() || txtemail.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(txtnome)) {
                    editnome.setError("Por favor entre com o nome");
                    editnome.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(txtemail)) {
                    editemail.setError("Por favor entre com o email");
                    editemail.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(txtsenha)) {
                    editsenha.setError("Por favor entre com a senha");
                    editsenha.requestFocus();
                    return;
                }

                else if (!txtrepsenha.equals(txtsenha)) {
                    Toast.makeText(CadastroActivity.this, "Senhas diferentes", Toast.LENGTH_LONG).show();
                } else {

                    registrarUsuario(txtnome,txtemail,txtsenha);

                }

            }
        });
    }

    /* Método fara a requisição ao webservice para registrtar o usuario */

    public void registrarUsuario(final String nome, final String email, final String senha){

        HttpsTrustManager.allowAllSSL();

        ProgressDialog progressDialog = new ProgressDialog(this);

        RequestHelper req = new RequestHelper(this, Api.URL_CREATE_Usuario, new RequestHelper.IRequests() {
            @Override
            public void Pre() {

            }

            @Override
            public void Pos(JSONObject jsonObject) throws JSONException {

                progressDialog.dismiss();

                if(jsonObject.getInt("error") == 1){

                    limparCampos();

                /*    Toast.makeText(getApplicationContext(), "Registrado com sucesso!", Toast.LENGTH_LONG).show(); */

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setMessage("Bem Vindo !!!");
                            progressDialog.show();
                            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 500);

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
                hashMap.put("nome", nome);
                hashMap.put("email", email);
                hashMap.put("senha", senha);
                return hashMap;
            }
        });
        req.execRequest();
    }

    /* Método limpa os campos dos componentes edittext */
    public void limparCampos(){
        editnome.setText("");
        editemail.setText("");
        editsenha.setText("");
        editrepsenha.setText("");
    }

    public void IniciarComponentes() {

        editnome = findViewById(R.id.editnome);
        editemail = findViewById(R.id.email);
        editsenha = findViewById(R.id.senha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        editrepsenha = findViewById(R.id.repsenha);

        editnome.requestFocus();

    }

}