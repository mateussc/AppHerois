package br.usjt.ads20.appfilmes.model;

import android.provider.BaseColumns;

public class HeroiContrato {
    public static abstract class HeroiEntry implements BaseColumns{
        public static final String TABLE_NAME = "heroi";
        public static final String COLUMN_NAME_ID = "idHeroi";
        public static final String COLUMN_NAME_NOME = "nomeHeroi";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_IMAGE = "imagem";
    }
}
