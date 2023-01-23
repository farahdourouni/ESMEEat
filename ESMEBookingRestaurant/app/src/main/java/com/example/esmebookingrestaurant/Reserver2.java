package com.example.esmebookingrestaurant;


import static java.lang.Integer.parseInt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Reserver2 extends Activity implements AdapterView.OnItemSelectedListener{
    public Button valider_reserver;
    public EditText editNbrePlace;
    public Spinner spinner;
    public int nbrePlace_int;
    public String nbrePlace_string;
    int nbrePlace2_int;
    int value_int;
    int value_int_2;
    int compteur_reservation;

    //Initialisation de la base de données pour les compteurs
    DatabaseReference rootRef = FirebaseDatabase.getInstance("https://esme-eat-default-rtdb.europe-west1.firebasedatabase.app").getReference();
    DatabaseReference userRef = rootRef.child("Etudiants").child("Compteur1");

    DatabaseReference rootRef2 = FirebaseDatabase.getInstance("https://esme-eat-default-rtdb.europe-west1.firebasedatabase.app").getReference();
    DatabaseReference userRef2 = rootRef2.child("Etudiants").child("Compteur2");

    DatabaseReference rootRef3 = FirebaseDatabase.getInstance("https://esme-eat-default-rtdb.europe-west1.firebasedatabase.app").getReference();
    DatabaseReference userRef3 = rootRef3.child("Etudiants").child("Compteur3");

    DatabaseReference rootRef4 = FirebaseDatabase.getInstance("https://esme-eat-default-rtdb.europe-west1.firebasedatabase.app").getReference();
    DatabaseReference userRef4 = rootRef3.child("Etudiants").child("Compteur4");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver2);

        spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Selectionner votre horaire");
        categories.add("12h - 12h30");
        categories.add("12h30 - 13h");
        categories.add("13h - 13h30");
        categories.add("13h30 - 14h");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

/******** COMPTEUR 1 ************/
        userRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue().toString();
                value_int = Integer.parseInt(value);


                valider_reserver = (Button) findViewById(R.id.bouton_validation_reserva);
                editNbrePlace = (EditText) findViewById(R.id.reservation);


                valider_reserver.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v1) {
                        nbrePlace_string = editNbrePlace.getText().toString();
                        nbrePlace_int = Integer.parseInt(nbrePlace_string);
                        compteur_reservation = value_int - nbrePlace_int;
                        if(value_int >=0){

                            if(nbrePlace_int <=5 &&nbrePlace_int !=0){
                                String valueHoraire = String.valueOf(spinner.getSelectedItem());

                                if(valueHoraire == "12h - 12h30"){
                                    userRef.setValue(compteur_reservation);
                                    finish();

                                }else{
                                    /******** COMPTEUR 2 ************/
                                    userRef2.addValueEventListener(new ValueEventListener() {

                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            String value = snapshot.getValue().toString();
                                            value_int_2 = Integer.parseInt(value);


                                            valider_reserver = (Button) findViewById(R.id.bouton_validation_reserva);
                                            editNbrePlace = (EditText) findViewById(R.id.reservation);


                                            valider_reserver.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v2) {
                                                    nbrePlace_string = editNbrePlace.getText().toString();
                                                    nbrePlace_int = Integer.parseInt(nbrePlace_string);
                                                    compteur_reservation = value_int_2 - nbrePlace_int;
                                                    if(value_int >=0){
                                                        if(nbrePlace_int <=5 &&nbrePlace_int !=0){
                                                            String valueHoraire = String.valueOf(spinner.getSelectedItem());
                                                            if(valueHoraire == "12h30 - 13h"){
                                                                userRef2.setValue(compteur_reservation);
                                                                finish();
                                                            }else{

                                                                /******** COMPTEUR 3************/
                                                                userRef3.addValueEventListener(new ValueEventListener() {

                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                        String value = snapshot.getValue().toString();
                                                                        value_int_2 = Integer.parseInt(value);


                                                                        valider_reserver = (Button) findViewById(R.id.bouton_validation_reserva);
                                                                        editNbrePlace = (EditText) findViewById(R.id.reservation);


                                                                        valider_reserver.setOnClickListener(new View.OnClickListener() {
                                                                            public void onClick(View v3) {
                                                                                nbrePlace_string = editNbrePlace.getText().toString();
                                                                                nbrePlace_int = Integer.parseInt(nbrePlace_string);
                                                                                compteur_reservation = value_int_2 - nbrePlace_int;
                                                                                if(value_int >=0){
                                                                                    if(nbrePlace_int <=5){
                                                                                        String valueHoraire = String.valueOf(spinner.getSelectedItem());
                                                                                        if(valueHoraire == "13h - 13h30"){
                                                                                            userRef3.setValue(compteur_reservation);
                                                                                            finish();
                                                                                        }else{
                                                                                            /******** COMPTEUR 4************/
                                                                                            userRef4.addValueEventListener(new ValueEventListener() {

                                                                                                @Override
                                                                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                                                    String value = snapshot.getValue().toString();
                                                                                                    value_int_2 = Integer.parseInt(value);


                                                                                                    valider_reserver = (Button) findViewById(R.id.bouton_validation_reserva);
                                                                                                    editNbrePlace = (EditText) findViewById(R.id.reservation);


                                                                                                    valider_reserver.setOnClickListener(new View.OnClickListener() {
                                                                                                        public void onClick(View v4) {
                                                                                                            nbrePlace_string = editNbrePlace.getText().toString();
                                                                                                            nbrePlace_int = Integer.parseInt(nbrePlace_string);
                                                                                                            compteur_reservation = value_int_2 - nbrePlace_int;
                                                                                                            if(value_int >=0){
                                                                                                                if(nbrePlace_int <=5 &&nbrePlace_int !=0){
                                                                                                                    String valueHoraire = String.valueOf(spinner.getSelectedItem());
                                                                                                                    if(valueHoraire == "13h30 - 14h"){
                                                                                                                        userRef4.setValue(compteur_reservation);
                                                                                                                        finish();
                                                                                                                    }

                                                                                                                }else{
                                                                                                                    alertDialogNbrePlace();
                                                                                                                }
                                                                                                            }else{

                                                                                                            }

                                                                                                        }

                                                                                                    });
                                                                                                }


                                                                                                @Override
                                                                                                public void onCancelled(@NonNull DatabaseError error) {
                                                                                                    Toast.makeText(Reserver2.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                                                                                                }

                                                                                            });
                                                                                        }

                                                                                    }else{
                                                                                        alertDialogNbrePlace();
                                                                                    }
                                                                                }else{

                                                                                }

                                                                            }

                                                                        });
                                                                    }


                                                                    @Override
                                                                    public void onCancelled(@NonNull DatabaseError error) {
                                                                        Toast.makeText(Reserver2.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                                                                    }

                                                                });
                                                            }

                                                        }else{
                                                            alertDialogNbrePlace();
                                                        }
                                                    }else{

                                                    }

                                                }

                                            });
                                        }


                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            Toast.makeText(Reserver2.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                                        }

                                    });
                                }

                            }else{
                                alertDialogNbrePlace();
                            }
                        }else{

                        }

                    }

                });
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Reserver2.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }

        });






    }
    public int getCompteur_reservation(){
        return compteur_reservation;
    }




    private void alertDialogNbrePlace() {
        AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
        dialog1.setMessage("Attention vous pouvez reserver seulement 5 places");
        dialog1.setTitle("AVERTISSEMENT");
        dialog1.setPositiveButton("Fermer",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        AlertDialog alertDialogNbrePlace = dialog1.create();
        alertDialogNbrePlace.show();
    }

    private void CreneauLimite() {
        AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
        dialog1.setMessage("Attention il n'y a plu de places pour ce créneau");
        dialog1.setTitle("AVERTISSEMENT");
        dialog1.setPositiveButton("Fermer",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        AlertDialog alertDialogNbrePlace = dialog1.create();
        alertDialogNbrePlace.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        if (position !=0){
            // On selecting a spinner item
            String item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}




