package infsolution.com.br.infbullet;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import infsolution.com.br.infbullet.dao.AlunoDAO;
import infsolution.com.br.infbullet.modelo.Aluno;

public class ProfileActivity extends AppCompatActivity {
    private Button bt_new;
    private Button bt_update;
    private Button bt_del;
    private EditText nome;
    private String nomAluno;
    private EditText matric;
    private String marAluno;
    private EditText serie;
    private String serAluno;
    private EditText meta;
    private double metAluno;
    private String path;
    private static int IMAGE_SELECT=101;
    private ImageButton imb;
    private Aluno aluno;
    private AlunoDAO aluDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imb =(ImageButton)findViewById(R.id.ibt_foto_profile);
        nome =(EditText)findViewById(R.id.edt_nome_user);
        matric=(EditText)findViewById(R.id.edt_matricula);
        meta=(EditText)findViewById(R.id.edt_meta);
        serie =(EditText)findViewById(R.id.edt_serie);
        bt_new=(Button)findViewById(R.id.cad_profile);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setAluno();
    }
    public void setAluno(){
        aluDao = new AlunoDAO(this);
        aluno=aluDao.getAluno();
        aluDao.close();
        if(aluno==null){
            imb =(ImageButton)findViewById(R.id.ibt_foto_profile);
            nome =(EditText)findViewById(R.id.edt_nome_user);
            matric=(EditText)findViewById(R.id.edt_matricula);
            meta=(EditText)findViewById(R.id.edt_meta);
            serie =(EditText)findViewById(R.id.edt_serie);
        }else{
            imb.setImageBitmap(BitmapFactory.decodeFile(aluno.getFotoAluno()));
            nome.setText(aluno.getNomeAluno());
            matric.setText(aluno.getMatriculaAluno());
            meta.setText(String.valueOf(aluno.getMetaAluno()));
            serie.setText(aluno.getSerieAluno());}
    }
    public void selectImage(View v){
        Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_SELECT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == IMAGE_SELECT && resultCode == RESULT_OK
                    && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                path = cursor.getString(columnIndex);
                cursor.close();
                imb = (ImageButton) findViewById(R.id.ibt_foto_profile);
                imb.setImageBitmap(BitmapFactory
                        .decodeFile(path));
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    public void newUser(View v){
        nomAluno=nome.getText().toString();
        marAluno=matric.getText().toString();
        metAluno = Double.parseDouble(meta.getText().toString());
        serAluno=serie.getText().toString();
        aluno = new Aluno(nomAluno);
        aluno.setMatriculaAluno(marAluno);
        aluno.setMetaAluno(metAluno);
        aluno.setSerieAluno(serAluno);
        aluno.setFotoAluno(path);
        AlunoDAO aDao = new AlunoDAO(this);
        aDao.insert(aluno);
        aDao.close();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Aluno salvo.");
        builder.setPositiveButton("Retornar!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.show();
    }
}
