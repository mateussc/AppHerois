package br.usjt.ads20.appfilmes.presenter;

import android.content.Context;

import java.util.ArrayList;

import br.usjt.ads20.appfilmes.model.Heroi;
import br.usjt.ads20.appfilmes.model.HeroiDb;
import br.usjt.ads20.appfilmes.view.MainActivityView;

public class MainPresenter implements IMainPresenter {

    MainActivityView view;

    public MainPresenter(MainActivityView view) {
        this.view = view;
    }

    public void salvarHeroisBD(ArrayList<Heroi> herois, Context context) {
        HeroiDb db = new HeroiDb(context);
        db.salvarHerois(herois);
    }

    public ArrayList<Heroi> buscarHeroisBD(Context context) {
        HeroiDb db = new HeroiDb(context);
        return db.buscarHerois();
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
