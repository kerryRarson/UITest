package com.example.spinner.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class ButtonActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_activity2);
        //button handlers
        final Intent homeIntent = new Intent(ButtonActivity2.this, MainActivity.class);

        //Save
        Button btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Player player = savePlayer();

                homeIntent.putExtra("player", player);
                ButtonActivity2.this.startActivity(homeIntent);
            }
        });
        //cancel
        Button btnCancel = (Button)findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ButtonActivity2.this.startActivity(homeIntent);
                }
            }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.button_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getBaseContext(), "Settings!", Toast.LENGTH_SHORT );
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Player savePlayer(){
        String name = ((EditText)findViewById(R.id.txtName)).getText().toString();
        String pos = ((Spinner)findViewById(R.id.cboPos)).getSelectedItem().toString();
        String team = ((EditText)findViewById(R.id.txtTeam)).getText().toString();
        String hgt = " " ,wgt = " ",spd = " ";

        Player p = new Player(name, team, pos, hgt, wgt, spd);

        try {
            String fileName = getResources().getString(R.string.PlayerFile);
            //does the player already exist?
            FileOutputStream hFile = openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(hFile);
            osw.write(p.Serialize());
            osw.flush();
            osw.close();
        } catch (IOException writeErr) {
            writeErr.printStackTrace();
        }

        return p;
    }
}
