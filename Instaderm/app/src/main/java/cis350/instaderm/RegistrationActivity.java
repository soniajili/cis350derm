package cis350.instaderm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Sonia on 3/18/15.
 */
public class RegistrationActivity extends Activity implements View.OnClickListener{
    Spinner genderSelection;
    Spinner countrySelection;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        // Access the spinner
        genderSelection = (Spinner) findViewById(R.id.gender_spinner);
        countrySelection = (Spinner) findViewById(R.id.country_spinner);


    }

    @Override
    public void onClick(View v) {

        // Get the spinner selection
        int gender = genderSelection.getSelectedItemPosition();


    }
    }