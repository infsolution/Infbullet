package infsolution.com.br.infbullet;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import infsolution.com.br.infbullet.dao.AgendaDAO;
import infsolution.com.br.infbullet.modelo.Agenda;

public class NewEventActivity extends AppCompatActivity {
    private TextView titulo;
    private TextView data;
    private TextView assunto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        titulo = (TextView)findViewById(R.id.edt_title_agenda);
        data = (TextView)findViewById(R.id.edt_data_agenda);
        assunto = (TextView)findViewById(R.id.edt_assunto_agenda);

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public  void newAgenda(View v){
        AgendaDAO ageDao = new AgendaDAO(this);
        String tit = titulo.getText().toString();
        String dat = data.getText().toString();
        String ass = assunto.getText().toString();
        Agenda ag = new Agenda(tit);
        ag.setDataAgenda(dat);
        ag.setAssuntoAgenda(ass);
        ageDao.insert(ag);
        ageDao.close();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Novo evento salvo");
        builder.setPositiveButton("Retornar!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.show();
    }

}
