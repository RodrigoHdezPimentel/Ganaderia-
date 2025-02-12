package com.example.ganadariasplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ganadariasplus.retrofit.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnadirAnimal extends AppCompatActivity {

    Button btn_anadir;

    ArrayList<AnimalModel> animalModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_animal);
        btn_anadir = findViewById(R.id.btn_anadirAnimal);



        btn_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnadirAnimal.this, Movimiento.class);
                startActivity(intent);
            }
        });



        setAnimalModel();



    }

    private void setAnimalModel() {

        SharedPreferences sharedPref = this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        int idExplotacion = Integer.parseInt(sharedPref.getString("idExplotacion", "1"));


        Call<List<AnimalModel>> call = ApiAdapter.getApiService().animalByIdExplotacion(idExplotacion);
        call.enqueue(new Callback<List<AnimalModel>>() {

            @Override
            public void onResponse(Call<List<AnimalModel>> call, Response<List<AnimalModel>> response) {

                animalModels = (ArrayList<AnimalModel>) response.body();

                RecyclerView recyclerView = findViewById(R.id.recyclreAnadirAnimales);
                AnimalAdapter adapter = new AnimalAdapter(AnadirAnimal.this, animalModels);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(AnadirAnimal.this));
                }

            @Override
            public void onFailure(Call<List<AnimalModel>> call, Throwable t) {

            }
        });
    }
}