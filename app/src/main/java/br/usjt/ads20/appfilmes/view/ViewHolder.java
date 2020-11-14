package br.usjt.ads20.appfilmes.view;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView imagemHeroi;
    private TextView nomeHeroi, DetalheHeroi;

    public ViewHolder(ImageView imagemHeroi, TextView nomeHeroi, TextView detalheHeroi) {
        this.imagemHeroi = imagemHeroi;
        this.nomeHeroi = nomeHeroi;
        DetalheHeroi = detalheHeroi;
    }

    public ImageView getImagemHeroi() {
        return imagemHeroi;
    }

    public void setImagemHeroi(ImageView imagemHeroi) {
        this.imagemHeroi = imagemHeroi;
    }

    public TextView getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(TextView nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public TextView getDetalheHeroi() {
        return DetalheHeroi;
    }

    public void setDetalheHeroi(TextView detalheHeroi) {
        DetalheHeroi = detalheHeroi;
    }
}
