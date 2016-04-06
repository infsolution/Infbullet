package infsolution.com.br.infbullet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import infsolution.com.br.infbullet.dao.DisciplinaDAO;
import infsolution.com.br.infbullet.modelo.Disciplina;

public class MateriaActivity extends AppCompatActivity {
    private ListView listMaterias;
    private Disciplina materia;
    private DisciplinaDAO matDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);
        listMaterias = (ListView)findViewById(R.id.list_materias);
        TextView label = (TextView)findViewById(R.id.titulo);

        registerForContextMenu(listMaterias);
        listMaterias.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MateriaActivity.this, "Clico longo em " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                materia = (Disciplina) parent.getItemAtPosition(position);
                return false;
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        povoaList();
    }
    public void povoaList(){
        listMaterias = (ListView)findViewById(R.id.list_materias);
        matDao = new DisciplinaDAO(this);
        List<Disciplina> materias = matDao.lista();
        ArrayAdapter<Disciplina> adapter = new ArrayAdapter<Disciplina>(this,android.R.layout.simple_list_item_1,materias);
        listMaterias.setAdapter(adapter);
        matDao.close();
    }
    public void newMateria(View v){
        Intent newMat = new Intent(this, NewMateriaActivity.class);
        startActivity(newMat);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);

        return super.onCreateOptionsMenu(menu);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.list_materias){
            MenuItem deletar = menu.add("Excluir discplina");
            MenuItem addProva = menu.add("Adicionar discplina");


            deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    AlertDialog.Builder b = new AlertDialog.Builder(MateriaActivity.this);
                    b.setMessage("A matéria será removida!");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           DisciplinaDAO dao = new DisciplinaDAO(MateriaActivity.this);
                            dao.remover(materia);
                            povoaList();
                            Toast.makeText(MateriaActivity.this, "Disciplina excluida", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b.setNegativeButton("CANCELAR", null);
                    b.show();

                    return false;
                }
            });
            
        }



    }

}
