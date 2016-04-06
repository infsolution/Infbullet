package infsolution.com.br.infbullet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

import infsolution.com.br.infbullet.modelo.Bimestre;

/**
 * Created by Cicero on 05/04/2016.
 */
public class BimestreDAO {
    private  Bimestre bimestre;
    private SQLiteDatabase database;
    private String[] columns = {"id_bimestre", "nome_bimestre", "situacao_bimestre"};
    private BulletinDAO bulDao;
    public BimestreDAO(Context context){
        bulDao = new BulletinDAO(context);
    }
    public void open() throws SQLException {
        database = bulDao.getWritableDatabase();
    }

    public void close() {
        bulDao.close();
    }
    public void insert(Bimestre bimestre) {
        ContentValues cv = new ContentValues();
        cv.put("nome_bimestre", bimestre.getNomeBimestre());
        cv.put("situacao_bimestre", bimestre.getSituacaoBimestre());
        bulDao.getWritableDatabase().insert("bimestre", null, cv);

    }
    public Bimestre getBimestre(){
        String sql ="SELECT * FROM bimestre;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql,null);
        if(c.moveToNext()){
            int id=c.getInt(c.getColumnIndex("id_bimestre"));
            String nome = c.getString(c.getColumnIndex("nome_bimestre"));
            String situa = c.getString(c.getColumnIndex("situacao_bimestre"));
            bimestre = new Bimestre(nome);
            bimestre.setIdBimestre(id);
            bimestre.setSituacaoBimestre(situa);

        }
        return bimestre;
    }
    public  void remover(Bimestre bimestre){
        String [] dados = {""+bimestre.getIdBimestre()};
        bulDao.getWritableDatabase().delete("agenda","id_bimestre = ?",dados);
    }

}
