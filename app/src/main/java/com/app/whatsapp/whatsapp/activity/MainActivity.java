package com.app.whatsapp.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.app.whatsapp.whatsapp.R;
import com.app.whatsapp.whatsapp.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autenticacao = ConfiguracaoFirebase.getFirebaseAuth();

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Whatsapp");
        setSupportActionBar(toolbar); //Suporte a versoes anteriores

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuConfiguracoes:

                break;
            case R.id.menuPesquisa:

                break;
            case R.id.menuSair:
                deslogarUsuario();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void deslogarUsuario(){
     try {
        autenticacao.signOut();
     }catch (Exception e){
         e.printStackTrace();
     }
    }
}
