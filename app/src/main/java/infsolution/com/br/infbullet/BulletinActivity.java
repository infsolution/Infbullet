package infsolution.com.br.infbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import infsolution.com.br.infbullet.dao.AlunoDAO;
import infsolution.com.br.infbullet.modelo.Aluno;
import infsolution.com.br.infbullet.modelo.Boletim;
import infsolution.com.br.infbullet.modelo.Disciplina;

public class BulletinActivity extends AppCompatActivity {
    private TextView nomeAluno;
    private TextView media;
    private Aluno aluno;
    private AlunoDAO aluDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin);
        nomeAluno =(TextView)findViewById(R.id.txt_nome_aluno);
        media = (TextView)findViewById(R.id.txt_media);
        aluDao = new AlunoDAO(this);
        aluno = aluDao.getAluno();
        aluDao.close();
        if(aluno==null){
            nomeAluno =(TextView)findViewById(R.id.txt_nome_aluno);
            media = (TextView)findViewById(R.id.txt_media);
        }else{
            nomeAluno.setText(aluno.getNomeAluno().toString());
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public void goForProfile(View v){
        Intent goToCad = new Intent(this,ProfileActivity.class);
        startActivity(goToCad);
    }
    public void goForAgenda(View v){
        Intent goToCad = new Intent(this,AgendaActivity.class);
        startActivity(goToCad);
    }
    public void goForBoletim(View v){
        Intent goToCad = new Intent(this, BulletinActivity.class);
        startActivity(goToCad);
    }
    public void goForProva(View v){
        Intent goToCad = new Intent(this,NewProvaActivity.class);
        startActivity(goToCad);
    }
    public void goForMateria(View v){
        Intent goToCad = new Intent(this, MateriaActivity.class);
        startActivity(goToCad);
    }
}
