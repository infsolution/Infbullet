package infsolution.com.br.infbullet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 05/04/2016.
 */
public class Disciplina {
    private int id_disciplina;
    private int id_bimestre;
    private String nomeDisciplina;
    private double mediaDisciplina;
    private List<Prova>provas= new ArrayList<>();
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina=nomeDisciplina;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getId_bimestre() {
        return id_bimestre;
    }

    public void setId_bimestre(int id_bimestre) {
        this.id_bimestre = id_bimestre;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    public double getMediaDisciplina() {
        return mediaDisciplina;
    }

    public void setMediaDisciplina(double getMediaDisciplina) {
        this.mediaDisciplina = getMediaDisciplina;
    }

    @Override
    public String toString() {

        return getNomeDisciplina()+" - Média: "+mediaDisciplina;
    }
}

