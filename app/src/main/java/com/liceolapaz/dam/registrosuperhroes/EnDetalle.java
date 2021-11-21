package com.liceolapaz.dam.registrosuperhroes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.liceolapaz.dam.registrosuperhroes.databinding.ActivityEnDetalleBinding;
import com.liceolapaz.dam.registrosuperhroes.databinding.ActivityMainBinding;

public class EnDetalle extends AppCompatActivity {


    public static final String SUPERHEROE_KEY = "superheroe";
    public static final String BITMAP_KEY = "bitmap";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEnDetalleBinding binding = ActivityEnDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        Superheroe superheroe = extras.getParcelable(SUPERHEROE_KEY);
        Bitmap bitmap = extras.getParcelable(BITMAP_KEY);

        if(bitmap!=null){
            binding.imageView.setImageBitmap(bitmap);
        }

        binding.setSuperheroe(superheroe);

    }
}