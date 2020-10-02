package br.usjt.ads20.appfilmes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import br.usjt.ads20.appfilmes.model.Heroi;

public class DetalheHeroiActivity extends AppCompatActivity {
    private TextView nome, poderHeroi2, dataNasc2, hq2, textoHeroi;
    private Heroi heroi;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_heroi);
        Intent intent = getIntent();
        heroi = (Heroi) intent.getSerializableExtra(ListarHeroisActivity.HEROI);

        nome = findViewById(R.id.nomeHeroi);
        poderHeroi2 = findViewById(R.id.poderHeroi2);
        dataNasc2 = findViewById(R.id.dataNascimentoHeroi);
        hq2 = findViewById(R.id.hq2);
        textoHeroi = findViewById(R.id.heroiTexto);

        imageView = findViewById(R.id.imageView);

        nome.setText(heroi.getNome());
        poderHeroi2.setText(heroi.getPoderPrincipal());
        textoHeroi.setText(heroi.getDescricao());

        ImageGetter imageGetter = new ImageGetter();
        imageGetter.execute(heroi.getPosterPath());
        Log.d("posterpath", heroi.getPosterPath());

    }

    private class ImageGetter extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urlS) {
            try {
                URL url = new URL(urlS[0]);
                Log.d("URL DA IMAGEM", url.toString());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Log.d("DETALHE HEROI IMAGEM - 1", "http conection");

                InputStream inputStream = connection.getInputStream();
                Log.d("DETALHE HEROI IMAGEM - 2", "inputStream");
                Bitmap figura = BitmapFactory.decodeStream(inputStream);

                Log.d("DETALHE HEROI IMAGEM - 3", "Final do Doing");
                return figura;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(Bitmap figura) {
            imageView.setImageBitmap(figura);
        }
    }
}