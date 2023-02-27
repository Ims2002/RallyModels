package com.ims.rallyModels.api;

import com.ims.rallyModels.modelo.CompeticionEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Date;
import java.util.List;

public interface Api {

    @GET("maquetas/all")
    Call<List<MaquetaEntity>> getMaquetasAll();

    @GET("maquetas/all/{id}")
    Call<MaquetaEntity> getMaquetaPorId();

    @GET("maquetas/all/{nombre}")
    Call<List<MaquetaEntity>> getMaquetasPorNombre();

    @GET("maquetas/all/{nombre_piloto}")
    Call<List<MaquetaEntity>> getMaquetasPorPiloto();

    @GET("maquetas/all/competicion/{id}")
    Call<List<MaquetaEntity>> getMaquetasPorCompeticion();



    @GET("competicion/all")
    Call<List<MaquetaEntity>> getCompeticiones();

    @GET("competicion/all/{id}")
    Call<List<MaquetaEntity>> getMaquetasPorId();

    @GET("competicion/all/{nombre}")
    Call<List<MaquetaEntity>> getMaquetasPorLugar();


    @POST("competicion/add")
    Call<Boolean> addCompeticion(@Body CompeticionEntity competicion);

    @POST("competicion/addValues")
    @FormUrlEncoded
    Call<Boolean> addCompeticionValues(@Field("nombre")String nombre,
                                 @Field("lugar") String lugar,
                                 @Field("mejor_posicion") String mejor_posicion,
                                 @Field("anio") Date fecha);


    @POST("maquetas/add")
    Call<Boolean> addMaqueta(@Body MaquetaEntity maqueta);

    @POST("competicion/addValues")
    @FormUrlEncoded
    Call<Boolean> addMaquetaValues(@Field("nombre")String nombre,
                                       @Field("piloto") String piloto,
                                       @Field("marca") String marca,
                                       @Field("modelo") String modelo,
                                       @Field("descripcion") String descripcion,
                                       @Field("precio") float precio);
}
