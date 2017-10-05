package com.example.venom.aplikasirsepmakanan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by VENOM on 10/4/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    //deklarasi variable context

    private final Context context;

    String [] name={"Leker","Omlete","Seblak","Sempolan","Steak BlackPapper","jamurtiram"};
    String [] deskripsi={"Crepes adalah jenis roti yang sangat tipis, biasanya terbuat dari tepung terigu. Asal mula kata Crepe adalah dari Perancis dengan sebutan crispa, yang berarti meringkuk.  Sedangkan Crepes berasal dari bahasa Inggris. Crepes sudah terkenal di seluruh benua Eropa dan kini mulai merambah ke seluruh dunia.Crepes merupakan jajanan ringan yang berisi berbagai varian topping.",
            "Siapa yang tak kenal dengan omelet telur? Ya, hidangan yang biasanya dijadikan sebagai menu sarapan diberbagai belahan dunia barat ini sudah mulai terkenal di Indonesia dan kian menjadi trend terbaru yang juga dijadikan menu makanan dipagi hari.",
            "Resep Seblak Basah Pedas Jajanan Bandung Sederhana Spesial Asli Enak Banget. Seblak adalah kerupuk mentah yang sengaja dibantatkan dengan cara direndam air panas. Cemilan ini sedang populer di sunda Jawa Barat di kota Bandung, Cimahi, Soreang, Cileunyi kemudian menyebar ke kota Bogor, Jakarta, Denpasar Bali, Surabaya, dan kota lainnya di seluruh Indonesia.",
            "Sempolan adalah merupakan salah satu jajanan tradisional murah meriah namun mempunyai rasa yang enak dan gurih. Jajanan sempolan ini enak banget dimakan pada saat musim hujan dan masih anget-angetnya",
            "Penggemar steak,pasti sudah tidak asing lagi dengan sirloin atau tenderloin steak.Mana yang paling anda suka ? Sirloin ataupun tenderloin, jika anda penggemar daging yang berada pada bagian belakang sebelum kaki belakang ini, anda dapat mengenali pemilihan sirloin yaitu sirloin atas,top sirloin ataupun bottom sirloin .",
              "Hanya dengan 5 ons jamur tiram di tambah dengan bumbu-bumbu pilihan lalu di tumis di dalam api sedang dengan sedikit minyak zaitun anda bisa menikmati hidangan yang satu ini."};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name
    Integer [] gambar={R.drawable.lekercepres,R.drawable.omlettelor,R.drawable.seblak,R.drawable.sempolan,R.drawable.steakblackpaper,R.drawable.jamurtiram};
    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.tampilanrecycle, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv2.setText(deskripsi[position]);
        holder.tv2.setOnClickListener(clickListener);

        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.tv2.setTag(holder);
        holder.imageView.setTag(holder);
        holder.imageView.setImageResource(gambar[position]);

    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();

            Bundle b = new Bundle();

            // mengeset gambar ke bundle
            b.putInt("gambar",gambar[position]);
            b.putString("label","Resep "+name[position]);


            Intent intent = new Intent(context , DetailkuActivity.class);
            intent.putExtras(b);
            context.startActivity(intent);


            //Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();


        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}
