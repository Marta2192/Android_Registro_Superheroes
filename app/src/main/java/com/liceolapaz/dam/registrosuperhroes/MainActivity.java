package com.liceolapaz.dam.registrosuperhroes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.liceolapaz.dam.registrosuperhroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final int FOTO_REQUEST_CODE = 1000;
    private ActivityMainBinding binding;
    private Bitmap foto_bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btGuardar.setOnClickListener(view -> {
            String nome = binding.nome.getText().toString();
            String alterEgo = binding.alterEgo.getText().toString();
            String descripcion = binding.descripcion.getText().toString();
            float ratio = binding.ratio.getRating();



            openEnDetalle(nome, alterEgo, descripcion, ratio);
        });

        binding.foto.setOnClickListener(view -> {
            openFoto();
        });

    }

    private void openFoto() {
        Intent camara_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(camara_intent,FOTO_REQUEST_CODE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode== Activity.RESULT_OK && requestCode == FOTO_REQUEST_CODE){
            if(data!= null){
                foto_bitmap = data.getExtras().getParcelable("data");
                binding.foto.setImageBitmap(foto_bitmap);
            }else{
                Toast.makeText(this, "Foto mal sacada", Toast.LENGTH_SHORT).show();
            }

        }
    };



    private void openEnDetalle(String nome, String alterEgo, String descripcion, float ratio){

        Superheroe superheroe = new Superheroe( nome,  alterEgo,  descripcion,  ratio);

        Intent intent = new Intent(this, EnDetalle.class);
        intent.putExtra(EnDetalle.SUPERHEROE_KEY, superheroe);
        intent.putExtra(EnDetalle.BITMAP_KEY, foto_bitmap);


        startActivity(intent);
    }
}