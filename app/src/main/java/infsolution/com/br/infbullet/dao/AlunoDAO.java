package infsolution.com.br.infbullet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

import infsolution.com.br.infbullet.modelo.Aluno;

/**
 * Created by Cicero on 05/04/2016.
 */
public class AlunoDAO {
    private SQLiteDatabase database;
    private String[] columns = {"id_aluno", "nome_aluno", "matricula_aluno","serie_aluno", "foto_aluno", "meta_aluno"};
    private BulletinDAO bulDao;
    private Aluno aluno;
    public AlunoDAO(Context context){
        bulDao = new BulletinDAO(context);
    }
    public void open() throws SQLException {
        database = bulDao.getWritableDatabase();
    }

    public void close() {
        bulDao.close();
    }

    public String insert(Aluno aluno){
        String result="Aluno já cadastrado";
        if(getAluno()==null) {
            result="Cadastro realizado com sucesso.";
            ContentValues cv = new ContentValues();
            cv.put("nome_aluno", aluno.getNomeAluno());
            cv.put("matricula_aluno",aluno.getMatriculaAluno());
            cv.put("serie_aluno", aluno.getSerieAluno());
            cv.put("foto_aluno", aluno.getFotoAluno());
            cv.put("meta_aluno", aluno.getMetaAluno());
            bulDao.getWritableDatabase().insert("aluno", null, cv);
        }
        return result;
    }
    public Aluno getAluno(){
        String sql ="SELECT * FROM aluno;";
        Cursor c = bulDao.getReadableDatabase().rawQuery(sql,null);
        if(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id_aluno"));
            String nome = c.getString(c.getColumnIndex("nome_aluno"));
            String matricula = c.getString(c.getColumnIndex("matricula_aluno"));
            String serie = c.getString(c.getColumnIndex("serie_aluno"));
            String foto =c.getString(c.getColumnIndex("foto_aluno"));
            double meta = c.getDouble(c.getColumnIndex("meta_aluno"));
            aluno = new Aluno(nome);
            aluno.setMatriculaAluno(matricula);
            aluno.setSerieAluno(serie);
            aluno.setFotoAluno(foto);
            aluno.setMetaAluno(meta);
        }
        return aluno;
    }
    public  void remover(Aluno aluno){
        String [] dados = {""+aluno.getIdAluno()};
        bulDao.getWritableDatabase().delete("aluno","id_aluno = ?",dados);
    }
}

