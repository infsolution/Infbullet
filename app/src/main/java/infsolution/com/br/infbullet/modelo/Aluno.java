package infsolution.com.br.infbullet.modelo;

/**
 * Created by Cicero on 05/04/2016.
 */
public class Aluno {
    private int idAluno;
    private String nomeAluno;
    private String matriculaAluno;
    private String serieAluno;
    private double metaAluno;
    private String fotoAluno="@drawable/nobody";
    public Aluno(String nome){
        this.nomeAluno=nome;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getSerieAluno() {
        return serieAluno;
    }

    public void setSerieAluno(String serieAluno) {
        this.serieAluno = serieAluno;
    }

    public double getMetaAluno() {
        return metaAluno;
    }

    public void setMetaAluno(double metaAluno) {
        this.metaAluno = metaAluno;
    }

    public String getFotoAluno() {
        return fotoAluno;
    }

    public void setFotoAluno(String foto) {
        this.fotoAluno = foto;
    }

    @Override
    public String toString() {
        return getNomeAluno()+" - Serie: "+getSerieAluno();
    }
}

