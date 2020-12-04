package simple.example.profilpahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKemerdekaan,btnRevolusi;
    public static final String JENIS_GALERI_KEY = "JENIS GALERY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnKemerdekaan = findViewById(R.id.btn_buka_nama_kemerdekaan);
        btnRevolusi = findViewById(R.id.btn_buka_nama_revolusi);
        btnKemerdekaan.setOnClickListener(v -> {
            Log.d("MAIN","Buka activity kemerdekaan");
            Intent intent = new Intent(this, GaleriActivity.class);
            intent.putExtra(JENIS_GALERI_KEY, "Merdeka");
            startActivity(intent);
        });
        btnRevolusi.setOnClickListener(view -> bukaGaleri("Revolusi"));
    }

    private void bukaGaleri(String jenisPahlawan) {
        Log.d("MAIN","Buka activity kemerdekaan");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisPahlawan);
        startActivity(intent);
    }
}