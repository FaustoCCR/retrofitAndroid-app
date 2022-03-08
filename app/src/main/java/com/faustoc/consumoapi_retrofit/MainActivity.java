package com.faustoc.consumoapi_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.faustoc.consumoapi_retrofit.io.MyApiAdapter;
import com.faustoc.consumoapi_retrofit.io.MyApiService;
import com.faustoc.consumoapi_retrofit.model.Testimonio;
import com.faustoc.consumoapi_retrofit.view.CustomAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private MyApiAdapter myApiAdapter;
    private String baseUrl;

    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        baseUrl = "https://testimonialapi.toolcarton.com/";
        myApiAdapter = new MyApiAdapter();
        searchData();

    }

    protected void searchData() {

        MyApiService myApiService = myApiAdapter.getApiService(baseUrl);

        Call<List<Testimonio>> call = myApiService.getTestimonials();
        call.enqueue(new Callback<List<Testimonio>>() {
            @Override
            public void onResponse(Call<List<Testimonio>> call, Response<List<Testimonio>> response) {
                if (response.isSuccessful()) {
                    List<Testimonio> testimonioResponse = response.body();
                    adapter = new CustomAdapter(getApplicationContext(),testimonioResponse);
                    listView.setAdapter(adapter);
/*                    for (Testimonio t:
                         testimonioResponse) {
                        System.out.println(t.getMessage());
                    }*/


                } else {
                    System.out.println(response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<Testimonio>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });


    }
}