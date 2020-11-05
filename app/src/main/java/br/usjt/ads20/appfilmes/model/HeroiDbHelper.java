package br.usjt.ads20.appfilmes.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.ads20.appfilmes.model.HeroiContrato.HeroiEntry;

public class HeroiDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Herois.db";
    public static final String SQL_CREATE_HEROI =
            "CREATE TABLE " + HeroiEntry.TABLE_NAME + " ( " +
                    HeroiEntry._ID + " INTEGER PRIMARY KEY," +
                    HeroiEntry.COLUMN_NAME_ID + " INTEGER," +
                    HeroiEntry.COLUMN_NAME_NOME + " TEXT," +
                    HeroiEntry.COLUMN_NAME_DESCRICAO + " TEXT," +
                    HeroiEntry.COLUMN_NAME_IMAGE + " TEXT)";

    public static final String SQL_DROP_HEROI =
            "DROP TABLE IF EXISTS " + HeroiEntry.TABLE_NAME;

    public HeroiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_HEROI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_HEROI);
        db.execSQL(SQL_CREATE_HEROI);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, newVersion, oldVersion);
    }
}
