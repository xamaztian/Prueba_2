package cl.xamaztian.pruebados.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import cl.xamaztian.pruebados.R;
import cl.xamaztian.pruebados.adapters.BirdClickListener;
import cl.xamaztian.pruebados.adapters.BirdsAdapter;
import cl.xamaztian.pruebados.views.details.BirdDetailActivity;

public class BirdListActivity extends AppCompatActivity implements BirdClickListener {

    private BirdsAdapter adapter;
    public static final String ID_BIRD = "cl.xamaztian.pruebados.views.details.BirdDetailActivity.KEY.ID_BIRD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_list);

        RecyclerView recyclerView = findViewById(R.id.birdsRvv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new BirdsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public void clickedBird(long id) {
        Intent intent = new Intent(this, BirdDetailActivity.class);
        intent.putExtra(ID_BIRD, id);
        startActivity(intent);
    }
}
