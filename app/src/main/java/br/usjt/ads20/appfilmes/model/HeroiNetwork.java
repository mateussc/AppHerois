package br.usjt.ads20.appfilmes.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HeroiNetwork {

    public static ArrayList<Heroi> buscarHerois(String url) throws IOException {

        ArrayList<Heroi> herois = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject retorno = new JSONObject(json);
            Log.d("retorno", retorno.toString());

            JSONObject data = retorno.getJSONObject("data");
            JSONArray lista = data.getJSONArray("results");

            for (int i = 0; i < lista.length(); i++) {
                Heroi heroi = new Heroi();
                JSONObject item = (JSONObject) lista.get(i);

                int idHeroi = Integer.parseInt(item.get("id").toString());
                heroi.setId(idHeroi);

                String urlImage = item.getJSONObject("thumbnail").get("path").toString();
                String extension = item.getJSONObject("thumbnail").get("extension").toString();

                heroi.setDescricao(item.get("description").toString());
                heroi.setNome(item.get("name").toString());
                heroi.setPosterPath(urlImage+"."+extension);

                herois.add(heroi);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return herois;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager manager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return manager.getActiveNetworkInfo() != null &&
                manager.getActiveNetworkInfo().isConnected();
    }
}
