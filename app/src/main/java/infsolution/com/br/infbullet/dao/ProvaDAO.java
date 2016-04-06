package infsolution.com.br.infbullet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infsolution.com.br.infbullet.modelo.Prova;

/**
 * Created by Cicero on 05/04/2016.
 */
public class ProvaDAO {
    private SQLiteDatabase database;
    private String[] columns = {"id_prova", "id_materia", "id_bimestre", "numero_prova","data_prova","nota_prova","tipo_prova"};
    private BulletinDAO bulDao;
    private Prova prova;
    public ProvaDAO(Context context){
        bulDao = new BulletinDAO(context);
    }
    public void open() throws SQLException {
        database = bulDao.getWritableDatabase();
    }

    public void close() {
        bulDao.close();
    }

    public void insert(Prova prova){
        ContentValues cv = new ContentValues();
        cv.put("id_materia",prova.getId_materia());
        cv.put("id_bimestre",prova.getId_bimestre());
        cv.put("numero_prova", prova.getNumeroDaProva());
        cv.put("data_prova",prova.getDataProva());
        cv.put("nota_prova",prova.getNotaProva());
        cv.put("tipo_prova",prova.getTipo());
        bulDao.getWritableDatabase().insert("prova", null, cv);
    }

    public List<Prova>lista(){
        List<Prova> provas = new ArrayList<>();
        String sql = "SELECT * FROM prova;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id_prova"));
            int idmat = c.getInt(c.getColumnIndex("id_materia"));
            int idBime = c.getInt(c.getColumnIndex("id_bimestre"));
            int numPro =c.getInt(c.getColumnIndex("numero_prova"));
            String data = c.getString(c.getColumnIndex("data_prova"));
            double nota = c.getDouble(c.getColumnIndex("nota_prova"));
            String tipo = c.getString(c.getColumnIndex("tipo_prova"));
            Prova prova = new Prova(data);
            prova.setId_prova(id);
            prova.setId_materia(idmat);
            prova.setId_bimestre(idBime);
            prova.setNumeroDaProva(numPro);
            prova.setNotaProva(nota);
            prova.setTipo(tipo);
            provas.add(prova);
        }
        return provas;
    }
    public Prova getProva(){
        String sql = "SELECT * FROM prova;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql, null);
        if(c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id_prova"));
            int idmat = c.getInt(c.getColumnIndex("id_materia"));
            int idBime = c.getInt(c.getColumnIndex("id_bimestre"));
            int numPro =c.getInt(c.getColumnIndex("numero_prova"));
            String data = c.getString(c.getColumnIndex("data_prova"));
            double nota = c.getDouble(c.getColumnIndex("nota_prova"));
            String tipo = c.getString(c.getColumnIndex("tipo_prova"));
            prova = new Prova(data);
            prova.setId_prova(id);
            prova.setId_materia(idmat);
            prova.setId_bimestre(idBime);
            prova.setNumeroDaProva(numPro);
            prova.setNotaProva(nota);
            prova.setTipo(tipo);

        }
        return prova;
    }

    public  void remover(Prova prova){
        String [] dados = {""+prova.getId_prova()};
        bulDao.getWritableDatabase().delete("prova","id_prova = ?",dados);
    }
}
