package infsolution.com.br.infbullet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import infsolution.com.br.infbullet.dao.BimestreDAO;
import infsolution.com.br.infbullet.dao.DisciplinaDAO;
import infsolution.com.br.infbullet.modelo.Bimestre;
import infsolution.com.br.infbullet.modelo.Disciplina;

public class BimestreActivity extends AppCompatActivity {
    private ListView listBimestre;
    private Bimestre bimestre;
    private BimestreDAO biDao;
    private Disciplina disciplina;
    private DisciplinaDAO disDao;
    private EditText nomBim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimestre);
        nomBim = (EditText)findViewById(R.id.edt_nome_bimestre);
        listBimestre =(ListView)findViewById(R.id.list_bimestre);
        registerForContextMenu(listBimestre);
        listBimestre.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                bimestre = (Bimestre) parent.getItemAtPosition(position);
                return false;
            }
        });
    }
    protected void onResume() {
        super.onResume();
        povoaList();
    }
    public void povoaList(){
    BimestreDAO ageDao = new BimestreDAO(this);
    List<Bimestre> agenda = ageDao.lista();
    ageDao.close();
    ArrayAdapter<Bimestre> adapter = new ArrayAdapter<Bimestre>(this, android.R.layout.simple_list_item_1,agenda);
    listBimestre.setAdapter(adapter);
    }


    public void newBimestre(View v){
        String nome = nomBim.getText().toString();
        bimestre= new Bimestre(nome);
        biDao = new BimestreDAO(this);
        biDao.insert(bimestre);
        biDao.close();

    }
}
