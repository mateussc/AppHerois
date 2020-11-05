package br.usjt.ads20.appfilmes.view;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import br.usjt.ads20.appfilmes.R;
import br.usjt.ads20.appfilmes.model.Heroi;
import br.usjt.ads20.appfilmes.model.HeroiNetwork;
import br.usjt.ads20.appfilmes.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private EditText txtNome;
    public static final String NOME = "br.usjt.ads20.appfilmes.nome";
    public static final String HEROIS = "br.usjt.ads20.appfilmes.herois";
    private ProgressBar progressBar;
    Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

    MainPresenter presenter = new MainPresenter(this);

    private String url = "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=599e05da22e3f6d6bfeedfce95286e91&hash=e9686e5f71f04765ae44432fe2dd8f5f";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarMainActivity);
        txtNome = (EditText) findViewById(R.id.busca_fila);
        context = this;
        presenter.onCreate();
    }

    public void buscarHerois(View view) {
        progressBar.setVisibility(View.VISIBLE);
        if (HeroiNetwork.isConnected(this)) {
            new DownloadJsonHerois().execute(url);
        } else {
            new CarregarHeroisDb().execute();
        }
    }

    @Override
    public void salvarHeroisBD() {

    }

    @Override
    public void buscarHeroisBD() {

    }

    private class DownloadJsonHerois extends AsyncTask<String, Void, ArrayList<Heroi>> {
        @Override
        protected ArrayList<Heroi> doInBackground(String... strings) {
            ArrayList<Heroi> herois = new ArrayList<>();
            try {
                herois = HeroiNetwork.buscarHerois(strings[0]);
                presenter.salvarHeroisBD(herois, context);
//                HeroiDb db = new HeroiDb(context);
//                db.salvarHerois(herois);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return herois;
        }

        @Override
        protected void onPostExecute(ArrayList<Heroi> herois) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(context, ListarHeroisActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(HEROIS, herois);
            startActivity(intent);
        }
    }

    private class CarregarHeroisDb extends AsyncTask<String, Void, ArrayList<Heroi>> {

        @Override
        protected ArrayList<Heroi> doInBackground(String... strings) {
            return presenter.buscarHeroisBD(context);
        }

        @Override
        protected void onPostExecute(ArrayList<Heroi> herois) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(context, ListarHeroisActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(HEROIS, herois);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }
}