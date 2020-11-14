package br.usjt.ads20.appfilmes.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.usjt.ads20.appfilmes.model.HeroiContrato.HeroiEntry;

public class HeroiDb {
    HeroiDbHelper dbHelper;

    public HeroiDb(Context context) {
        dbHelper = new HeroiDbHelper(context);
    }

    public void salvarHerois(ArrayList<Heroi> herois) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(HeroiEntry.TABLE_NAME, null, null);

        for (Heroi heroi : herois) {
            ContentValues values = new ContentValues();
            values.put(HeroiEntry.COLUMN_NAME_ID, heroi.getId());
            values.put(HeroiEntry.COLUMN_NAME_NOME, heroi.getNome());
            values.put(HeroiEntry.COLUMN_NAME_DESCRICAO, heroi.getDescricao());
            values.put(HeroiEntry.COLUMN_NAME_IMAGE, heroi.getPosterPath());
            db.insert(HeroiEntry.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Heroi> buscarHerois() {
        ArrayList<Heroi> herois = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {
                HeroiEntry.COLUMN_NAME_ID,
                HeroiEntry.COLUMN_NAME_NOME,
                HeroiEntry.COLUMN_NAME_DESCRICAO,
                HeroiEntry.COLUMN_NAME_IMAGE,
        };
        String where = null;
        String[] conditions = null;
        String order = HeroiEntry.COLUMN_NAME_NOME;
        Cursor c = db.query(HeroiEntry.TABLE_NAME, colunas, where, conditions, order, null, null);

        while (c.moveToNext()) {
            Heroi heroi = new Heroi();
            heroi.setId(c.getInt(c.getColumnIndex(HeroiEntry.COLUMN_NAME_ID)));
            heroi.setNome(c.getString(c.getColumnIndex(HeroiEntry.COLUMN_NAME_NOME)));
            heroi.setDescricao(c.getString(c.getColumnIndex(HeroiEntry.COLUMN_NAME_DESCRICAO)));
            heroi.setPosterPath(c.getString(c.getColumnIndex(HeroiEntry.COLUMN_NAME_ID)));

            herois.add(heroi);
        }
        c.close();
        db.close();
        return herois;
    }
}
