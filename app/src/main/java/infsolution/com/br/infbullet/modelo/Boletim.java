package infsolution.com.br.infbullet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 05/04/2016.
 */
public class Boletim {
    private int idBoletim;
    private String nomeEscola;
    private double mediaEscola;
    private String situacao;
    private List<Bimestre>bimestres= new ArrayList<>();

    public Boletim(String nomeEscola){
        this.nomeEscola= nomeEscola;
    }

    public int getIdBoletim() {
        return idBoletim;
    }

    public void setIdBoletim(int idBoletim) {
        this.idBoletim = idBoletim;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public double getMediaEscola() {
        return mediaEscola;
    }

    public void setMediaEscola(double mediaEscola) {
        this.mediaEscola = mediaEscola;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<Bimestre> getBimestres() {
        return bimestres;
    }

    public void setBimestres(List<Bimestre> bimestres) {
        this.bimestres = bimestres;
    }

    @Override
    public String toString() {
        return "Situação: "+getSituacao()+".";
    }
}

