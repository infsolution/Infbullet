package infsolution.com.br.infbullet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicero on 05/04/2016.
 */
public class Bimestre {
    private int idBimestre;
    private String nomeBimestre;
    private List<Disciplina>disciplinas=new ArrayList<>();
    private String situacaoBimestre;
    public final String MENSAGEM_EX="Excelente voçê está acima da meta";
    public final String MENSAGEM_Ok="Muito bom voçê está dentro da meta";
    public final String MENSAGE_MALERTt="Atenção voçê precisa esturas mais!";
    public Bimestre(String nomeBimestre){
        this.nomeBimestre=nomeBimestre;
    }

    public int getIdBimestre() {
        return idBimestre;
    }

    public void setIdBimestre(int idBimestre) {
        this.idBimestre = idBimestre;
    }

    public String getNomeBimestre() {
        return nomeBimestre;
    }

    public void setNomeBimestre(String nomeBimestre) {
        this.nomeBimestre = nomeBimestre;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getSituacaoBimestre() {
        return situacaoBimestre;
    }

    public void setSituacaoBimestre(String situacaoBimestre) {
        this.situacaoBimestre = situacaoBimestre;
    }

    @Override
    public String toString() {
        return "";
    }
}

