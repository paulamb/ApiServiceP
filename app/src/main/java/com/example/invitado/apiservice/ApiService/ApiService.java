package com.example.invitado.apiservice.ApiService;

import com.example.invitado.apiservice.models.Parque;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Invitado on 03/06/2017.
 */

public interface ApiService {
    @GET("tbnf-tvbj.json")
    Call<ArrayList<Parque>> obtenerListaParque();
}
