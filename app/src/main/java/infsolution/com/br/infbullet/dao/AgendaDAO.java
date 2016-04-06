package infsolution.com.br.infbullet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infsolution.com.br.infbullet.modelo.Agenda;

/**
 * Created by Cicero on 05/04/2016.
 */
public class AgendaDAO {
    private SQLiteDatabase database;
    private String[] columns = {"id_genda", "titulo_agenda", "data_agenda", "assunto_agenda"};
    private BulletinDAO bulDao;

    public AgendaDAO(Context context) {
        bulDao = new BulletinDAO(context);
    }

    public void open() throws SQLException {
        database = bulDao.getWritableDatabase();
    }

    public void close() {
        bulDao.close();
    }

    public void insert(Agenda agenda) {
        ContentValues cv = new ContentValues();
        cv.put("titulo_agenda", agenda.getTituloAgenda());
        cv.put("data_agenda", agenda.getDataAgenda());
        cv.put("assunto_agenda", agenda.getAssuntoAgenda());
        bulDao.getWritableDatabase().insert("agenda", null, cv);

    }

    public List<Agenda> lista() {
        List<Agenda> agenda = new ArrayList<>();
        String sql = "SELECT * FROM agenda;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id_agenda"));
            String data = c.getString(c.getColumnIndex("data_agenda"));
            String titulo = c.getString(c.getColumnIndex("titulo_agenda"));
            String assunto = c.getString(c.getColumnIndex("assunto_agenda"));
            Agenda ag = new Agenda(titulo);
            ag.setId_agenda(id);
            ag.setDataAgenda(data);
            ag.setAssuntoAgenda(assunto);
            agenda.add(ag);
        }
        return agenda;
    }
    public  void remover(Agenda agenda){
        String [] dados = {""+agenda.getId_agenda()};
        bulDao.getWritableDatabase().delete("agenda","id_agenda = ?",dados);
    }
}
