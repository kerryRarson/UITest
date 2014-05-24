package com.example.spinner.app;

import android.widget.AdapterView;
import android.widget.Toast;
import android.view.View;

/**
 * Created by klarsen on 5/21/2014.
 */
public class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener  {
    protected boolean ignoreSelect = true;
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        if ( ignoreSelect ){
            ignoreSelect = false;
        } else {
            Toast.makeText(parent.getContext(), "Item is " +
                    parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
        }

    }
    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}
