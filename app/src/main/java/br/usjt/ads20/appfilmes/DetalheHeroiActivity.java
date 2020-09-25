package br.usjt.ads20.appfilmes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.usjt.ads20.appfilmes.model.Heroi;

public class DetalheHeroiActivity extends AppCompatActivity {
    private TextView nome, poderHeroi2, dataNasc2, hq2, textoHeroi;
    private Heroi heroi;

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

        nome.setText(heroi.getNome());
        poderHeroi2.setText(heroi.getPoderPrincipal());
        dataNasc2.setText(heroi.getDataNascimento().toString());
        textoHeroi.setText(heroi.getDescricao());

    }
}