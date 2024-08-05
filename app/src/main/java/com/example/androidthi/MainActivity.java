package com.example.androidthi;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MotorcycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MotorcycleApi api = RetrofitClient.getClient("http://192.168.0.102:3000/").create(MotorcycleApi.class);
        api.getMotorcycles().enqueue(new Callback<List<Motorcycle>>() {
            @Override
            public void onResponse(Call<List<Motorcycle>> call, Response<List<Motorcycle>> response) {
                if (response.isSuccessful()) {
                    List<Motorcycle> motorcycles = response.body();
                    adapter = new MotorcycleAdapter(MainActivity.this, motorcycles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Motorcycle>> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }
}
