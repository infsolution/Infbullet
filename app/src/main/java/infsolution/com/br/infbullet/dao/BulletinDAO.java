package infsolution.com.br.infbullet.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cicero on 05/04/2016.
 */
public class BulletinDAO extends SQLiteOpenHelper{
    public static final String DB_NAME="infbullet";
    public static int versionDb=2;

    public BulletinDAO(Context context) {
        super(context, DB_NAME, null, versionDb);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlAgenda="CREATE TABLE agenda(id_agenda INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo_agenda VARCHAR (100), data_agenda VARCHAR (12), assunto_agenda VARCHAR (255));";
        db.execSQL(sqlAgenda);
        String sqlAluno="CREATE TABLE aluno (id_aluno INTEGER PRIMARY KEY AUTOINCREMENT, nome_aluno " +
                "VARCHAR (60), matricula_aluno VARCHAR (22), serie_aluno VARCHAR (25), foto_aluno VARCHAR (255), meta_aluno DOUBLE);";
        db.execSQL(sqlAluno);
        String sqlBimestre="CREATE TABLE bimestre (id_bimestre INTEGER PRIMARY KEY AUTOINCREMENT, nome_bimestre VARCHAR (60), " +
                "situacao_bimestre VARCHAR (45));";
        db.execSQL(sqlBimestre);
        String sqlBoletim ="CREATE TABLE boletim (id_boletim INTEGER PRIMARY KEY AUTOINCREMENT, nome_escola VARCHAR (60), " +
                " media_escola DOUBLE, situacao_boeltim VARCHAR (60));";
        db.execSQL(sqlBoletim);
        String sqlDisciplina = "CREATE TABLE disciplina (id_disciplina INTEGER PRIMARY KEY AUTOINCREMENT, id_bimestre INTEGER, " +
                "nome_disciplina VARCHAR (60), media_disciplina DOUBLE);";
        db.execSQL(sqlDisciplina);
        String sqlProva="CREATE TABLE prova (id_prova INTEGER PRIMARY KEY AUTOINCREMENT, id_materia INTEGER, id_bimestre INTEGER, " +
                "numero_prova INTEGER, data_prova VARCHAR (60), nota_prova DOUBLE, tipo_prova VARCHAR (28));";
        db.execSQL(sqlProva);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlUpAgenda="DROP TABLE IF EXISTS agenda;";
        db.execSQL(sqlUpAgenda);
        String sqlUpAluno="DROP TABLE IF EXISTS aluno;";
        db.execSQL(sqlUpAluno);
        String sqlUpBimestre="DROP TABLE IF EXISTS bimestre;";
        db.execSQL(sqlUpBimestre);
        String sqlUpBoletim="DROP TABLE IF EXISTS boletim;";
        db.execSQL(sqlUpBoletim);
        String sqlUpDisciplina="DROP TABLE IF EXISTS disciplina;";
        db.execSQL(sqlUpDisciplina);
        String sqlUpProva="DROP TABLE IF EXISTS prova;";
        db.execSQL(sqlUpProva);
        onCreate(db);
    }
}


