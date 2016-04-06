package infsolution.com.br.infbullet.modelo;

/**
 * Created by Cicero on 05/04/2016.
 */
public class Agenda {
    private int id_agenda;
    private String tituloAgenda;
    private String dataAgenda;
    private String assuntoAgenda;

    public Agenda(String tituloAgenda){
        this.tituloAgenda= tituloAgenda;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getTituloAgenda() {
        return tituloAgenda;
    }

    public void setTituloAgenda(String tituloAgenda) {
        this.tituloAgenda = tituloAgenda;
    }

    public String getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(String dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public String getAssuntoAgenda() {
        return assuntoAgenda;
    }

    public void setAssuntoAgenda(String assuntoAgenda) {
        this.assuntoAgenda = assuntoAgenda;
    }

    @Override
    public String toString() {
        return "Assunto: "+getTituloAgenda()+"\nData: "+getDataAgenda()+"\nConteúdo: "+getAssuntoAgenda()+".";
    }
}
