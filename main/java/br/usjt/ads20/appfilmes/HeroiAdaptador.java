package br.usjt.ads20.appfilmes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import br.usjt.ads20.appfilmes.model.Heroi;

public class HeroiAdaptador extends BaseAdapter implements SectionIndexer {
    private Heroi[] herois;
    private Context context;
    private Object[] sectionHeaders;
    private Hashtable<Integer, Integer> positionForSectionMap;
    private Hashtable<Integer, Integer> sectionForPositionMap;

    public HeroiAdaptador(Context context, Heroi[] herois) {
        this.herois = herois;
        this.context = context;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(herois);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(herois);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPosition(herois);
    }

    @Override
    public int getCount() {
        return herois.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >=0 && i < herois.length) {
            return herois[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.heroi_view, viewGroup, false);
            ImageView posterFilme = (ImageView) view.findViewById(R.id.imagem_heroi);
            TextView nomeFilme = (TextView) view.findViewById(R.id.nome_heroi);
            TextView detalheFilme = (TextView) view.findViewById(R.id.detalhe_heroi);
            view.setTag(new ViewHolder(posterFilme, nomeFilme, detalheFilme));
        }
        ViewHolder holder = (ViewHolder) view.getTag();

        Drawable drawable = Util.getDrawable(context,
                herois[i].getPosterPath().toLowerCase());

        holder.getImagemHeroi().setImageDrawable(drawable);
        holder.getNomeHeroi().setText(herois[i].getNome());
//        holder.getDetalheHeroi().setText(String.format("Poder: %s", herois[i].getPoderPrincipal()));

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
