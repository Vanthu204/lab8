package com.example.androidthi;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMotorcycleActivity extends AppCompatActivity {
    private EditText editTextTenXe, editTextMauSac, editTextGiaBan, editTextMoTa, editTextHinhAnh;
    private Button buttonAddMotorcycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motorcycle);

        editTextTenXe = findViewById(R.id.editTextTenXe);
        editTextMauSac = findViewById(R.id.editTextMauSac);
        editTextGiaBan = findViewById(R.id.editTextGiaBan);
        editTextMoTa = findViewById(R.id.editTextMoTa);
        editTextHinhAnh = findViewById(R.id.editTextHinhAnh);
        buttonAddMotorcycle = findViewById(R.id.buttonAddMotorcycle);

        buttonAddMotorcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMotorcycle();
            }
        });
    }

    private void addMotorcycle() {
        String tenXe = editTextTenXe.getText().toString();
        String mauSac = editTextMauSac.getText().toString();
        int giaBan = Integer.parseInt(editTextGiaBan.getText().toString());
        String moTa = editTextMoTa.getText().toString();
        String hinhAnh = editTextHinhAnh.getText().toString();

        Motorcycle newMotorcycle = new Motorcycle();
        newMotorcycle.setTen_xe(tenXe);
        newMotorcycle.setMau_sac(mauSac);
        newMotorcycle.setGia_ban(giaBan);
        newMotorcycle.setMo_ta(moTa);
        newMotorcycle.setHinh_anh(hinhAnh);

        MotorcycleApi api = RetrofitClient.getClient("http://192.168.0.102:3000/").create(MotorcycleApi.class);
        api.createMotorcycle(newMotorcycle).enqueue(new Callback<Motorcycle>() {
            @Override
            public void onResponse(Call<Motorcycle> call, Response<Motorcycle> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddMotorcycleActivity.this, "Thêm xe máy thành công!", Toast.LENGTH_SHORT).show();
                    finish(); // Kết thúc Activity sau khi thêm thành công
                } else {
                    Toast.makeText(AddMotorcycleActivity.this, "Thêm xe máy thất bại!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Motorcycle> call, Throwable t) {
                Log.e("AddMotorcycleActivity", t.getMessage());
                Toast.makeText(AddMotorcycleActivity.this, "Lỗi kết nối!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
