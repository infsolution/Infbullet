package infsolution.com.br.infbullet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infsolution.com.br.infbullet.modelo.Disciplina;

/**
 * Created by Cicero on 05/04/2016.
 */
public class DisciplinaDAO {
    private Disciplina disciplina;
    private SQLiteDatabase database;
    private String[] columns = {"id_disciplina", "id_bimestre", "nome_disciplina", "media_disciplina"};
    private BulletinDAO bulDao;
    public DisciplinaDAO(Context context){
        bulDao = new BulletinDAO(context);
    }

    public void open() throws SQLException {
        database = bulDao.getWritableDatabase();
    }

    public void close() {
        bulDao.close();
    }

    public void insert(Disciplina disciplina){
        ContentValues cv = new ContentValues();
        cv.put("id_bimestre",disciplina.getId_bimestre());
        cv.put("nome_bimestre",disciplina.getId_bimestre());
        cv.put("media_disciplina",disciplina.getMediaDisciplina());
        bulDao.getWritableDatabase().insert("disciplina", null, cv);
    }

    public List<Disciplina> lista () {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT * FROM agenda;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id_disciplina"));
            int idBim =c.getInt(c.getColumnIndex("id_bimestre"));
            String nome = c.getString(c.getColumnIndex("nome_bimestre"));
            double media = c.getDouble(c.getColumnIndex("media_disciplina"));
            disciplina = new Disciplina(nome);
            disciplina.setId_disciplina(id);
            disciplina.setId_bimestre(idBim);
            disciplina.setMediaDisciplina(media);
            disciplinas.add(disciplina);
        }

        return disciplinas;
    }

    public  void remover(Disciplina disciplina){
        String [] dados = {""+disciplina.getId_disciplina()};
        bulDao.getWritableDatabase().delete("disciplina","id_disciplina = ?",dados);
    }
}
