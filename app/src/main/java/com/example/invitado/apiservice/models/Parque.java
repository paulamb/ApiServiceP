package com.example.invitado.apiservice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Invitado on 03/06/2017.
 */

public class Parque {
    @SerializedName("arenal")
    @Expose
    private String arenal;
    @SerializedName("juegos_infantiles")
    @Expose
    private String juegosInfantiles;
    @SerializedName("nombre_del_parque")
    @Expose
    private String nombreDelParque;
    @SerializedName("zona_de_eventos")
    @Expose
    private String zonaDeEventos;
    @SerializedName("zona_verde")
    @Expose
    private String zonaVerde;
    @SerializedName("zona_wi_fi")
    @Expose
    private String zonaWiFi;

    public String getArenal() {
        return arenal;
    }

    public void setArenal(String arenal) {
        this.arenal = arenal;
    }

    public String getJuegosInfantiles() {
        return juegosInfantiles;
    }

    public void setJuegosInfantiles(String juegosInfantiles) {
        this.juegosInfantiles = juegosInfantiles;
    }

    public String getNombreDelParque() {
        return nombreDelParque;
    }

    public void setNombreDelParque(String nombreDelParque) {
        this.nombreDelParque = nombreDelParque;
    }

    public String getZonaDeEventos() {
        return zonaDeEventos;
    }

    public void setZonaDeEventos(String zonaDeEventos) {
        this.zonaDeEventos = zonaDeEventos;
    }

    public String getZonaVerde() {
        return zonaVerde;
    }

    public void setZonaVerde(String zonaVerde) {
        this.zonaVerde = zonaVerde;
    }

    public String getZonaWiFi() {
        return zonaWiFi;
    }

    public void setZonaWiFi(String zonaWiFi) {
        this.zonaWiFi = zonaWiFi;
    }


}
