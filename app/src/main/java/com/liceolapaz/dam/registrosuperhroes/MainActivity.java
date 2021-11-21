package com.liceolapaz.dam.registrosuperhroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.liceolapaz.dam.registrosuperhroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btGuardar.setOnClickListener(view -> {
            String nome = binding.nome.getText().toString();
            String alterEgo = binding.alterEgo.getText().toString();
            String descripcion = binding.descripcion.getText().toString();
            float ratio = binding.ratio.getRating();



            openEnDetalle(nome, alterEgo, descripcion, ratio);
        });



        /*Button btguardar = findViewById(R.id.bt_guardar);
        EditText nome = findViewById(R.id.nome);
        EditText alterEgo = findViewById(R.id.alterEgo);
        EditText descripcion = findViewById(R.id.descripcion);
        RatingBar ratio = findViewById(R.id.ratio);
*/


    }

    private void openEnDetalle(String nome, String alterEgo, String descripcion, float ratio){
        Intent intent = new Intent(this, EnDetalle.class);
        intent.putExtra(EnDetalle.SUPERHEROE_NOME, nome);
        intent.putExtra(EnDetalle.SUPERHEROE_EGO, alterEgo);
        intent.putExtra(EnDetalle.SUPERHEROE_DESCRIPCION, descripcion);
        intent.putExtra(EnDetalle.SUPERHEROE_RATIO, ratio);
        startActivity(intent);
    }
}