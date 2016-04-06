package infsolution.com.br.infbullet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import java.util.List;

import infsolution.com.br.infbullet.dao.AgendaDAO;
import infsolution.com.br.infbullet.modelo.Agenda;

public class AgendaActivity extends AppCompatActivity {
    private ListView listAgenda;
    private Agenda agenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        listAgenda =(ListView)findViewById(R.id.list_agenda);
        registerForContextMenu(listAgenda);
        listAgenda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                agenda = (Agenda) parent.getItemAtPosition(position);
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
        listAgenda = (ListView)findViewById(R.id.list_agenda);
        AgendaDAO ageDao = new AgendaDAO(this);
        List<Agenda> agenda = ageDao.lista();
        ageDao.close();
        ArrayAdapter<Agenda> adapter = new ArrayAdapter<Agenda>(this, android.R.layout.simple_list_item_1,agenda);
        listAgenda.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.new_event){
            Intent newEv = new Intent(this, NewEventActivity.class);
            startActivity(newEv);
        }

        return super.onOptionsItemSelected(item);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.list_agenda){
            MenuItem deletar = menu.add("Remover Evento");
            deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    AlertDialog.Builder b = new AlertDialog.Builder(AgendaActivity.this);
                    b.setMessage("O evento será descartado!");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AgendaDAO dao = new AgendaDAO(AgendaActivity.this);
                            dao.remover(agenda);
                            povoaList();
                            Toast.makeText(AgendaActivity.this, "Evento descartado!", Toast.LENGTH_SHORT).show();
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
