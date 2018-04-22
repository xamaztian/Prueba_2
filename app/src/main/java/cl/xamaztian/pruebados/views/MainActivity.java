package cl.xamaztian.pruebados.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.xamaztian.pruebados.R;
import cl.xamaztian.pruebados.views.details.BirdDetailActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = findViewById(R.id.btnNewBird);
        Button btnList = findViewById(R.id.btnBirdList);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BirdDetailActivity.class);
                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BirdListActivity.class);
                startActivity(intent);
            }
        });
    }
}
