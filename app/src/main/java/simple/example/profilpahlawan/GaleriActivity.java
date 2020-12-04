package simple.example.profilpahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import simple.example.profilpahlawan.model.*;

public class GaleriActivity extends AppCompatActivity {

    List<Pahlawan> pahlawans;
    int indeksTampil = 0;
    String jenisPahlawan;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txNama,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoPahlawan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);
        Intent intent = getIntent();
        jenisPahlawan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        pahlawans = DataProvider.getPahlawansByTipe(this,jenisPahlawan);
        inisialisasiView();
        tampilkanProfil();

    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> pahlawanPertama());
        btnTerakhir.setOnClickListener(view -> pahlawanTerakhir());
        btnSebelumnya.setOnClickListener(view -> pahlawanSebelumnya());
        btnBerikutnya.setOnClickListener(view -> pahlawanBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txNama = findViewById(R.id.txNama);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoPahlawan = findViewById(R.id.gambarPahlawan);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Pahlawan "+jenisPahlawan);
    }


    private void tampilkanProfil() {
        Pahlawan k = pahlawans.get(indeksTampil);
        Log.d("KEMERDEKAAN","Menampilkan pahlawan "+k.getJenis());
        txJenis.setText(k.getJenis());
        txNama.setText(k.getNama());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoPahlawan.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void pahlawanPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void pahlawanTerakhir() {
        int posAkhir = pahlawans.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void pahlawanBerikutnya() {
        if (indeksTampil == pahlawans.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void pahlawanSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}
