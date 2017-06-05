package com.example.invitado.apiservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.invitado.apiservice.ApiService.ApiService;
import com.example.invitado.apiservice.models.Parque;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG = "PARQUES";
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private ListaParqueAdapter listaParqueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaParqueAdapter = new ListaParqueAdapter(this);
        recyclerView.setAdapter(listaParqueAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Finalizacion.");

                            aptoParaCargar = false;
                            obtenerLista();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        obtenerLista();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.uno) {
            Intent i = new Intent(this, MainActivity2.class );
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    private void obtenerLista() {

        ApiService service = retrofit.create(ApiService.class);
        Call<ArrayList<Parque>> autoRespuestaCall = service.obtenerListaParque();

        autoRespuestaCall.enqueue(new Callback<ArrayList<Parque>>() {

            public void onResponse(Call<ArrayList<Parque>> call, Response<ArrayList<Parque>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    listaParqueAdapter.adicionarListaParque(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            public void onFailure(Call<ArrayList<Parque>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });

    }
}
