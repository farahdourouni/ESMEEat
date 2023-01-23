package com.example.esmebookingrestaurant;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Calendar cal = Calendar.getInstance();

    int millisecond = cal.get(Calendar.MILLISECOND);
    int second = cal.get(Calendar.SECOND);
    int minute = cal.get(Calendar.MINUTE);
    //24 hour format
    int hourofday = cal.get(Calendar.HOUR_OF_DAY);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /***acces a la reservation**/
        Button reserver = (Button) findViewById(R.id.bouton_reservation);
        reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                //if (hourofday >=6 && hourofday <12){
                    Intent intention = new Intent(MainActivity2.this, Reserver2.class);
                    startActivity(intention);
                //}
                //else{
                    //AccèsReserver();
                //}

            }
        });



        DatabaseReference rootRef2 = FirebaseDatabase.getInstance("https://esme-eat-default-rtdb.europe-west1.firebasedatabase.app").getReference();
        DatabaseReference userRef2 = rootRef2.child("Etudiants").child("Compteur3");


        textView= (TextView) findViewById(R.id.nbre_reservation);
        // Read from the database et visualisation du compteur dans le textView
        userRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue().toString();
                textView.setText(String.valueOf(value));

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }

    private void AccèsReserver() {
        AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
        dialog1.setMessage("Attention vous pouvez seulement entre 6h et 12h");
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

}
