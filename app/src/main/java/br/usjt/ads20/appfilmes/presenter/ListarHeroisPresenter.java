package br.usjt.ads20.appfilmes.presenter;

import java.util.ArrayList;

import br.usjt.ads20.appfilmes.model.Dados;
import br.usjt.ads20.appfilmes.model.Heroi;
import br.usjt.ads20.appfilmes.view.ListaerHeroisView;

public class ListarHeroisPresenter implements IMainPresenter {

    ListaerHeroisView view;
    Heroi[] lista;

    public ListarHeroisPresenter(ListaerHeroisView view) {
        this.view = view;
    }

    public Heroi[] carregarHerois(ArrayList<Heroi> herois, String chave) {
        Dados.setHerois(herois);
        lista = Dados.buscarHerois(chave);
        return lista;
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
