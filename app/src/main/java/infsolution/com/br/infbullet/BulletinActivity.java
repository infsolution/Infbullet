package infsolution.com.br.infbullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BulletinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin);
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
        Intent goToCad = new Intent(this,NewProvaActivity.class);
        startActivity(goToCad);
    }
}
