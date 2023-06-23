package com.example.webviewfragment059;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.webviewfragment059.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


   private ActivityMainBinding mBinding;
    private EditText texto1;
    private Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        texto1= mBinding.texto;
        boton = mBinding.boton1;

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFragmento();
            }
        });

    }
    private void mostrarFragmento() {
    //crar instancia del fragmento
        BlankFragment fragment = BlankFragment.newInstance(texto1.getText().toString(),"");
        // OBTENER EL ADMINISTRADOR DE LOS FRAGMENTOS
        FragmentManager fragmentManager= getSupportFragmentManager();
        // iniciar transacción del fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // reemplazar el contenido del contendor con el fragmento
        transaction.replace(mBinding.container.getId(), fragment);
        // opcional : añadir la transacciona la pila de retroceso
        transaction.addToBackStack(null);
        transaction.commit();

    }




}