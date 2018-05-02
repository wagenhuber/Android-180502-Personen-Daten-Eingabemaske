package com.example.guenther.android_180502_sa_prep2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {

    private Button btnSave, btnShowList;
    private EditText etVorname, etNachname, datePerson, etUrl;
    private DatePicker datePicker;
    private Personen personen;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);


        btnSave = findViewById(R.id.btnSave);
        btnSave.setEnabled(false);
        btnShowList = findViewById(R.id.btnShowList);
        etVorname = findViewById(R.id.etVorname);

        etVorname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                enableSaveButtion();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etNachname = findViewById(R.id.etNachname);

        etNachname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                enableSaveButtion();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        datePerson = findViewById(R.id.datePerson);
        datePicker = findViewById(R.id.datePicker);
        personen = new Personen();


        btnSave.setOnClickListener(new View.OnClickListener() {
            String vorname, nachname, url;
            Date gebDateum;
            URL urlObject;

            @Override
            public void onClick(View view) {
                if (etVorname.getText() != null) {
                    vorname = etVorname.getText().toString();
                } else {
                    etVorname.setText("Bitte Wert eingeben!");
                }

                if (etNachname.getText() != null) {
                    nachname = etNachname.getText().toString();
                } else {
                    etNachname.setText("Bitte Wert eingeben!");
                }

                if (etUrl.getText() != null) {
                    url = etUrl.getText().toString();
                } else {
                    etUrl.setText("Bitte Wert eingeben!");
                }

                gebDateum = getDate();
                try {
                    urlObject = new URL(url);
                } catch (MalformedURLException e) {
                    System.out.println("URL falsch");
                }

                datePerson.setText(gebDateum.toString());

                if (vorname != null && nachname != null && datePerson != null) {
                    etVorname.setText("");
                    etNachname.setText("");
                    datePerson.setText("");

                    Person person;

                        person = new Person(vorname, nachname, gebDateum, urlObject);

                    personen.addPerson(person);
                    System.out.println(person.toString());
                }
                btnSave.setEnabled(false);

            }
        });




        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePerson.setText(getDate().toString());
            }
        });



        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PersonenListActivity.class);
                intent.putExtra("personen",personen);
                startActivity(intent);
            }
        });


    }//ende oncreate

    private void enableSaveButtion() {
        btnSave.setEnabled(true);
    }

    public Date getDate() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();

    }




}
