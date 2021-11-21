package com.liceolapaz.dam.registrosuperhroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.liceolapaz.dam.registrosuperhroes.databinding.ActivityEnDetalleBinding;
import com.liceolapaz.dam.registrosuperhroes.databinding.ActivityMainBinding;

public class EnDetalle extends AppCompatActivity {

    public static final String SUPERHEROE_NOME = "superheroe_nome";
    public static final String SUPERHEROE_EGO = "superheroe_ego";
    public static final String SUPERHEROE_DESCRIPCION = "superheroe_descripcion";
    public static final String SUPERHEROE_RATIO = "superheroe_ratio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEnDetalleBinding binding = ActivityEnDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        String nome = extras.getString(SUPERHEROE_NOME);
        String alterEgo = extras.getString(SUPERHEROE_EGO);
        String bio = extras.getString(SUPERHEROE_DESCRIPCION);
        float rating = extras.getFloat(SUPERHEROE_RATIO);

        binding.nameTxt.setText(nome);
        binding.egoText.setText(alterEgo);
        binding.bioText.setText(bio);
        binding.ratingBar.setRating(rating);

    }
}