package infsolution.com.br.infbullet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import infsolution.com.br.infbullet.dao.ProvaDAO;
import infsolution.com.br.infbullet.modelo.Prova;

public class ProvaActivity extends AppCompatActivity {
    private ListView listProva;
    private Prova prova;
    private ProvaDAO proDao;
    private Button btGoProva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);
        listProva =(ListView)findViewById(R.id.list_provas);
        registerForContextMenu(listProva);
        listProva.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                 prova= (Prova) parent.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    public void povoaList(){
        proDao = new ProvaDAO(this);
        List<Prova> provas = proDao.lista();
        proDao.close();
        ArrayAdapter<Prova> adapter = new ArrayAdapter<Prova>(this, android.R.layout.simple_list_item_1,provas);
        listProva.setAdapter(adapter);
    }
}
