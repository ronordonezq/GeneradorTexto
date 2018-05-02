package com.example.ademuz.supertext;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainActivity extends AppCompatActivity {

    TextView texx;
    ImageView urlImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlImagen =  (ImageView)findViewById(R.id.img1);
       

        texx=(TextView)findViewById(R.id.txt1);

        Button but = (Button)findViewById(R.id.btn1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new doit().execute();


            }
        });


    }

    public  class doit extends AsyncTask<Void,Void,Void>{


        String words;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = (Document) Jsoup.connect("http://randomtextgenerator.com/").get();

                Element li= doc.getElementById("generatedtext");
                words = li.text();

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            texx.setText(words);
        }
    }
}
