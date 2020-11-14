package br.usjt.ads20.appfilmes.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.usjt.ads20.appfilmes.R;
import br.usjt.ads20.appfilmes.model.Dados;
import br.usjt.ads20.appfilmes.model.Heroi;

public class ListarHeroisActivity extends AppCompatActivity {
    public static final String HEROI = "br.usjt.ads20.appfilmes.descricao";
    private String url = "";
    Heroi[] lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_herois);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);

        ArrayList<Heroi> herois =(ArrayList<Heroi>) intent.getSerializableExtra(MainActivity.HEROIS);
        Dados.setHerois(herois);
        lista = Dados.buscarHerois(chave);
        BaseAdapter adapter = new HeroiAdaptador(this, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalheHeroiActivity.class);
                intent1.putExtra(HEROI , lista[i]);
                startActivity(intent1);
            }
        });
    }
}