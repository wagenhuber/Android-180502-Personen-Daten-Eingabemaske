package com.example.guenther.android_180502_sa_prep2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class PersonDetailActivity extends Activity {

    private Person person;
    private TextView PDAvorname, PDAnachname, PDAdatum, PDAurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        PDAvorname = findViewById(R.id.PDAvorname);
        PDAnachname = findViewById(R.id.PDAnachname);
        PDAdatum = findViewById(R.id.PDAdatum);
        PDAurl = findViewById(R.id.PDAurl);

        Serializable serializable = getIntent().getSerializableExtra("person");

        if (serializable instanceof Person) {
            person = (Person) serializable;
        }

        PDAvorname.setText(person.getVorname());
        PDAnachname.setText(person.getNachname());
        PDAdatum.setText(person.getGebDatum().toString());
        PDAurl.setText(person.getUrl().toString());

        PDAurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(PDAurl.getText().toString()));
                startActivity(browserIntent);
            }
        });

    }
}
