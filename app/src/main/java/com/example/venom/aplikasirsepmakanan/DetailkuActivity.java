package com.example.venom.aplikasirsepmakanan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailkuActivity extends AppCompatActivity {
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailku);
          Bundle b = getIntent().getExtras();
        gambar=(ImageView)findViewById(R.id.gambar);
         gambar.setImageResource(b.getInt("gambar"));
        setTitle(b.getString("label"));
    }

}
