package brand.age.com.lassaguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class Language extends AppCompatActivity {

    SharedPreferenceManager sharedPreferenceManager;
    String[] languages;
    Button save_language;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        languages = new String[]{"HAUSA", "ENGLISH"};

        sharedPreferenceManager = SharedPreferenceManager.getInstance(this);
        spinner = findViewById(R.id.language_spinner);
        save_language = findViewById(R.id.save_language);
        spinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, languages));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().toLowerCase().contains("ha")){
                    sharedPreferenceManager.save_language("HA");
                }else if (adapterView.getItemAtPosition(i).toString().toLowerCase().contains("en")){
                    sharedPreferenceManager.save_language("EN");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        save_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Language.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPreferenceManager.get_language() != null){
            if (sharedPreferenceManager.get_language().toLowerCase().equals("en")){
                spinner.setSelection(1);
            }else if (sharedPreferenceManager.get_language().toLowerCase().equals("ha")){
                spinner.setSelection(0);
            }
        }
    }
}
