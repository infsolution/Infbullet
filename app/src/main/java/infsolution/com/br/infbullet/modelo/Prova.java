package infsolution.com.br.infbullet.modelo;

/**
 * Created by Cicero on 05/04/2016.
 */
public class Prova {
    private int id_prova;
    private int id_materia;
    private int id_bimestre;
    private int numeroDaProva;
    private String dataProva;
    private double notaProva;
    private String tipo;
    public Prova(String dataProva){
        this.dataProva=dataProva;
    }

    public int getId_prova() {
        return id_prova;
    }

    public void setId_prova(int id_prova) {
        this.id_prova = id_prova;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_bimestre() {
        return id_bimestre;
    }

    public void setId_bimestre(int id_bimestre) {
        this.id_bimestre = id_bimestre;
    }

    public int getNumeroDaProva() {
        return numeroDaProva;
    }

    public void setNumeroDaProva(int numeroDaProva) {
        this.numeroDaProva = numeroDaProva;
    }

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(double notaProva) {
        this.notaProva = notaProva;
    }

    @Override
    public String toString() {
        return "Data: "+getDataProva()+"- Nota: "+getNotaProva()+";";
    }
}

