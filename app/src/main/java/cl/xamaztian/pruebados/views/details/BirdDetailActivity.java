package cl.xamaztian.pruebados.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;

import cl.xamaztian.pruebados.R;
import cl.xamaztian.pruebados.models.Bird;

public class BirdDetailActivity extends AppCompatActivity {

    public static final String ID_BIRD = "cl.xamaztian.pruebados.views.details.BirdDetailActivity.KEY.ID_BIRD";

    private Bird bird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_detail);

        long birdId = getIntent().getLongExtra(ID_BIRD, 0);

        if (birdId > 0){
            bird = Bird.findById(Bird.class, birdId);
            EditText editTextName = findViewById(R.id.editTextBirdName);
            EditText editTextCientificName = findViewById(R.id.editTextBirdScientficalName);
            CheckBox checkBox = findViewById(R.id.checkIsWatched);

            editTextName.setText(bird.getName());
            editTextCientificName.setText(bird.getScientificName());
            checkBox.setChecked(bird.isWatched());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        EditText editTextName = findViewById(R.id.editTextBirdName);
        EditText editTextCientificName = findViewById(R.id.editTextBirdScientficalName);
        CheckBox checkBox = findViewById(R.id.checkIsWatched);

        if (editTextName.getText().toString().trim().length() < 1)
            return;

        if (editTextCientificName.getText().toString().trim().length() < 1)
            return;

        if (bird == null)
            bird = new Bird();

        bird.setWatched(checkBox.isChecked());
        bird.setName(String.valueOf(editTextName.getText()));
        bird.setScientificName(String.valueOf(editTextCientificName.getText()));
        bird.save();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bird != null) {
            EditText editTextName = findViewById(R.id.editTextBirdName);
            EditText editTextCientificName = findViewById(R.id.editTextBirdScientficalName);
            CheckBox checkBox = findViewById(R.id.checkIsWatched);

            checkBox.setChecked(bird.isWatched());
            editTextName.setText(bird.getName());
            editTextCientificName.setText(bird.getScientificName());
        }
    }

    //@Override
    //public void onBackPressed() {
    //    Intent intent = new Intent(BirdDetailActivity.this, BirdListActivity.class);
    //    startActivity(intent);
    //    //super.onBackPressed();
    //}
}
