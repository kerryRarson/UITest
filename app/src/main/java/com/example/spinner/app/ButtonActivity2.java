package com.example.spinner.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class ButtonActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_activity2);
        //button handler
        Button btnHome = (Button)findViewById(R.id.btnBottom);
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Player player = savePlayer();

                Intent btnPage = new Intent(ButtonActivity2.this, MainActivity.class);
                btnPage.putExtra("player", player);
                ButtonActivity2.this.startActivity(btnPage);
            }
        });
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
        return p;
    }
}
