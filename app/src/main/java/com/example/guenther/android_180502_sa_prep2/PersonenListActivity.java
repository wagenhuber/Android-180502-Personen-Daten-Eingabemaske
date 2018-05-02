package com.example.guenther.android_180502_sa_prep2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

public class PersonenListActivity extends Activity {

    private Personen personen;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personen_list);

        listView = findViewById(R.id.lvPersonen);

        Serializable serializable = getIntent().getSerializableExtra("personen");

        if (serializable instanceof Personen) {
            personen = (Personen) serializable;

            ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personen.getPersonenListe());
            listView.setAdapter(arrayAdapter);

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person person = personen.getPerson(i);

                Intent intent = new Intent(PersonenListActivity.this, PersonDetailActivity.class);
                intent.putExtra("person", person);
                startActivity(intent);
            }

            });
    }
}