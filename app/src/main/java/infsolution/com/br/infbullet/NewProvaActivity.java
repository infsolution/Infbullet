package infsolution.com.br.infbullet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import infsolution.com.br.infbullet.dao.ProvaDAO;
import infsolution.com.br.infbullet.modelo.Prova;

public class NewProvaActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private Prova prova;
    private ProvaDAO proDao;
    private EditText numer;
    private EditText dat;
    private EditText not;
    private Button btCad;
    private Spinner spin;
    private SeekBar seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_prova);
        numer =(EditText)findViewById(R.id.edt_nume_prova);
        dat = (EditText)findViewById(R.id.edt_dt_prova);
        //not = (EditText)findViewById(R.id.edt_nota_prova);
        btCad = (Button)findViewById(R.id.bt_new_prova);
        spin=(Spinner)findViewById(R.id.spi_tipo_prova);
        seek=(SeekBar)findViewById(R.id.seek_nota_prova);
        seek.setOnSeekBarChangeListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public void newProva(View v){
        int nume = Integer.parseInt(numer.getText().toString());
        String data = dat.getText().toString();
        String tipo =spin.getSelectedItem().toString();
        double nota = Double.parseDouble(not.getText().toString());
        prova = new Prova(data);
        prova.setNumeroDaProva(nume);
        prova.setNotaProva(seek.getProgress());
        prova.setTipo(tipo);
        proDao = new ProvaDAO(this);
        proDao.insert(prova);
        proDao.close();

    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
