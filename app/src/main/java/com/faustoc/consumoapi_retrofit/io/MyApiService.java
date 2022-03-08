package com.faustoc.consumoapi_retrofit.io;

import com.faustoc.consumoapi_retrofit.model.Testimonio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {

    @GET("api")
    Call<List<Testimonio>> getTestimonials();

}
