package infsolution.com.br.infbullet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

import infsolution.com.br.infbullet.modelo.Boletim;

/**
 * Created by Cicero on 05/04/2016.
 */
public class BoletimDAO {
    private Boletim boletim;
    private SQLiteDatabase database;
    private String[] columns = {"id_boletim", "nome_escola", "media_escola", "situacao_boletim"};
    private BulletinDAO bulDao;
    public BoletimDAO(Context context){
        bulDao = new BulletinDAO(context);
    }
    public void open() throws SQLException {
        database = bulDao.getWritableDatabase();
    }

    public void close() {
        bulDao.close();
    }

    public void insert(Boletim boletim){
        ContentValues cv = new ContentValues();
        cv.put("nome_escola",boletim.getNomeEscola());
        cv.put("media_escola",boletim.getMediaEscola());
        cv.put("situacao_boletim",boletim.getSituacao());
        bulDao.getWritableDatabase().insert("boletim", null, cv);
    }
    public Boletim getBoletim(){
        String sql ="SELECT * FROM aluno;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql,null);
        if(c.moveToNext()){
            int id=c.getInt(c.getColumnIndex("id_boletim"));
            String nomeEsc = c.getString(c.getColumnIndex("nome_escola"));
            double medESc =c.getDouble(c.getColumnIndex("media_escola"));
            String situa = c.getString(c.getColumnIndex("situacao_boletim"));
            boletim = new Boletim(nomeEsc);
            boletim.setMediaEscola(medESc);
            boletim.setSituacao(situa);
        }
        return boletim;
    }

    public  void remover(Boletim boletim){
        String [] dados = {""+boletim.getIdBoletim()};
        bulDao.getWritableDatabase().delete("boletim", "id_boletim = ?", dados);
    }
}

