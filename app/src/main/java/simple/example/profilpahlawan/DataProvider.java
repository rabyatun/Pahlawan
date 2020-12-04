package simple.example.profilpahlawan;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import simple.example.profilpahlawan.model.Merdeka;
import simple.example.profilpahlawan.model.Pahlawan;
import simple.example.profilpahlawan.model.Revolusi;

public class DataProvider {
    private static List<Pahlawan> pahlawans = new ArrayList<>();

    private static List<Merdeka> initDataKemerdekaan(Context ctx) {
        List<Merdeka> merdekas = new ArrayList<>();
        merdekas.add(new Merdeka("Ir.Soekarno", "Peneleh,Surabaya",
                "Adalah Presiden pertama Republik Indonesia yang menjabat pada periode 1945–1967. Ia memainkan peranan penting dalam memerdekakan bangsa Indonesia dari penjajahan Belanda. ", R.drawable.soekarno));
        merdekas.add(new Merdeka("Mohammad Hatta", "Bukittinngi",
                "Adalah negarawan dan ekonom Indonesia yang menjabat sebagai Wakil Presiden Indonesia pertama.", R.drawable.mohammad_hatta));
        merdekas.add(new Merdeka("Jendral Soedirman", "Bodas Karang Jati",
                "Adalah seorang perwira tinggi Indonesia pada masa Revolusi Nasional Indonesia. Sebagai panglima besar Tentara Nasional Indonesia pertama, ia adalah sosok yang dihormati di Indonesia.", R.drawable.sudirman));
        merdekas.add(new Merdeka("Pangeran Diponegoro", "Yogyakarta",
                "adalah salah seorang pahlawan nasional Republik Indonesia, yang memimpin Perang Diponegoro atau Perang Jawa selama periode tahun 1825 hingga 1830 melawan pemerintah Hindia Belanda. ", R.drawable.pangeran_diponegoro));
        merdekas.add(new Merdeka("Sutomo (Bung Tomo)", "Surabaya",
                "adalah pahlawan yang terkenal karena peranannya dalam membangkitkan semangat rakyat untuk melawan kembalinya penjajah Belanda melalui tentara NICA, yang berakhir dengan pertempuran 10 November 1945 yang hingga kini diperingati sebagai Hari Pahlawan.", R.drawable.sutomo));
        merdekas.add(new Merdeka("R.A Kartini", "Jepara",
                "Adalah seorang tokoh Jawa dan Pahlawan Nasional Indonesia. Kartini dikenal sebagai pelopor kebangkitan perempuan pribumi. ", R.drawable.kartini));
        merdekas.add(new Merdeka("Tjoet Nyak Dien", "Jepara",
                "Adalah seorang Pahlawan Nasional Indonesia dari Aceh yang berjuang melawan Belanda pada masa Perang Aceh. Setelah wilayah VI Mukim diserang, ia mengungsi, sementara suaminya Ibrahim Lamnga bertempur melawan Belanda. ", R.drawable.cutnyak_dien));
        merdekas.add(new Merdeka("Ki Hadjar Dewantara", "Kadipaten Pakualaman, Yogyakarta",
                "Adalah aktivis pergerakan kemerdekaan Indonesia, kolumnis, politisi, dan pelopor pendidikan bagi kaum pribumi Indonesia dari zaman penjajahan Belanda. ", R.drawable.kihajaar));
        return merdekas;
    }

    private static List<Revolusi> initDataRevolusi(Context ctx) {
        List<Revolusi> revolusis = new ArrayList<>();
        revolusis.add(new Revolusi("Jenderal Ahmad Yani", "Kabupaten Purworejo",
                "Adalah komandan Tentara Nasional Indonesia Angkatan Darat, dan dibunuh oleh anggota Gerakan 30 September saat mencoba untuk menculik dia dari rumahnya.", R.drawable.ahmad_yani));
        revolusis.add(new Revolusi("Mayjen R. Suprapto", "Purwokerto ",
                "Adalah seorang pahlawan nasional Indonesia. Ia merupakan salah satu korban dalam G30S/PKI dan dimakamkan di Taman Makam Pahlawan Kalibata, Jakarta.", R.drawable.soeprapto));
        revolusis.add(new Revolusi("Mayjen Mt Haryono", "Surabaya",
                "Adalah salah satu pahlawan revolusi Indonesia yang terbunuh pada persitiwa G30S. Ia dimakamkan di TMP Kalibata - Jakarta. ", R.drawable.haryono));
        revolusis.add(new Revolusi("Mayjen S Parman", "Kabupaten Wonosobo",
                "Adalah salah satu pahlawan revolusi Indonesia dan tokoh militer Indonesia. Ia meninggal dibunuh pada persitiwa Gerakan 30 September dan mendapatkan gelar Letnan Jenderal Anumerta. Ia dimakamkan di TMP Kalibata, Jakarta.", R.drawable.parman));
        revolusis.add(new Revolusi("Drigjen D.I Pandjaitan", "Balige,Toba Samosir",
                "Adalah salah satu pahlawan revolusi Indonesia. Ia dimakamkan di Taman Makam Pahlawan Kalibata, Jakarta Panjaitan lahir di Balige, Toba Samosir, 9 Juni 1925.", R.drawable.panjaitan));
        revolusis.add(new Revolusi("Brigjen Sutoyo Siswomiharjo", "Kabupaten Kebumen",
                "Adalah seorang perwira tinggi TNI-AD yang diculik dan kemudian dibunuh dalam peristiwa Gerakan 30 September di Indonesia.", R.drawable.sutoyo));
        revolusis.add(new Revolusi("Lettu Pierre Tendean ", "Batavia",
                "Adalah seorang perwira militer Indonesia yang menjadi salah satu korban peristiwa Gerakan 30 September pada tahun 1965.", R.drawable.tendean));
        return revolusis;
    }

    private static void initAllPahlawans(Context ctx) {
        pahlawans.addAll(initDataKemerdekaan(ctx));
        pahlawans.addAll(initDataRevolusi(ctx));
    }

    public static List<Pahlawan> getAllHewans(Context ctx) {
        if (pahlawans.size() == 0) {
            initAllPahlawans(ctx);
        }
        return  pahlawans;
    }

    public static List<Pahlawan> getPahlawansByTipe(Context ctx, String jenis) {
        List<Pahlawan> pahlawansByType = new ArrayList<>();
        if (pahlawansByType.size() == 0) {
            initAllPahlawans(ctx);
        }
        for (Pahlawan h : pahlawans) {
            if (h.getJenis().equals(jenis)) {
                pahlawansByType.add(h);
            }
        }
        return pahlawansByType;
    }

}



