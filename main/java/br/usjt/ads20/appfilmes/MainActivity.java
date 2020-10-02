package br.usjt.ads20.appfilmes;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import br.usjt.ads20.appfilmes.model.Heroi;
import br.usjt.ads20.appfilmes.model.HeroiNetwork;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    public static final String NOME = "br.usjt.ads20.appfilmes.nome";
    public static final String HEROIS = "br.usjt.ads20.appfilmes.herois";
    Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    String ts = currentTimestamp.toString();
    String publicKey = "6c4efd05281dc8ae96a507ea7fcfdc04";

    private String url = "http://gateway.marvel.com/v1/public/comics?ts=1&apikey=6c4efd05281dc8ae96a507ea7fcfdc04&hash=f4fdf644440829c0fadbb27c0075815e";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText) findViewById(R.id.busca_fila);

        context = this;
    }

    public void buscarFilmes(View view) throws NoSuchAlgorithmException {
        new DownloadJsonHerois().execute(url);
    }

    private class DownloadJsonHerois extends AsyncTask<String, Void, ArrayList<Heroi>> {
        @Override
        protected ArrayList<Heroi> doInBackground(String... strings) {
            ArrayList<Heroi> herois = new ArrayList<>();
            try {
                herois = HeroiNetwork.buscarHerois(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return herois;
        }

        @Override
        protected void onPostExecute(ArrayList<Heroi> filmes) {
            Intent intent = new Intent(context, ListarHeroisActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(HEROIS, filmes);
            startActivity(intent);
        }
    }

    private String getKey() {
        return publicKey;
    }

    private String getTS() {
        return currentTimestamp.toString();
    }
}