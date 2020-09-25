package br.usjt.ads20.appfilmes.model;

import java.util.Date;
import java.io.Serializable;

public class Heroi implements Serializable, Comparable<Heroi>{
    private int id;
    private String poderPrincipal;
    private String nome;
    private String descricao;
    private Date dataNascimento;
    private String posterPath;
    private String backdropPath;

    public String getPoderPrincipal() {
        return poderPrincipal;
    }

    public void setPoderPrincipal(String poderPrincipal) {
        this.poderPrincipal = poderPrincipal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    @Override
    public String toString() {
        return "Heroi{" +
                "id=" + id +
                ", titulo='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataLancamento=" + dataNascimento +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                '}';
    }

    @Override
    public int compareTo(Heroi heroi) {
        return getNome().compareTo(heroi.getNome());
    }
}
