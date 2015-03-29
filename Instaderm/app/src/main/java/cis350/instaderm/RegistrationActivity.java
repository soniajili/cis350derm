package cis350.instaderm;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Sonia on 3/18/15.
 */
public class RegistrationActivity extends ActionBarActivity implements View.OnClickListener {
    Spinner genderSelection;
    Spinner practiceSettingSelection;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        // Add gender information
        genderSelection = (Spinner) findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSelection.setAdapter(genderAdapter);

        // Add country information
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
        String[] countries = getResources().getStringArray(R.array.country_array);
        ArrayAdapter<String> countryAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(countryAdapter);

        // Add practice setting information
        practiceSettingSelection = (Spinner) findViewById(R.id.setting_spinner);
        ArrayAdapter<CharSequence> settingAdapter = ArrayAdapter.createFromResource(this,
                R.array.setting_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        practiceSettingSelection.setAdapter(settingAdapter);
    }

    @Override
    public void onClick(View v) {

        // Get the spinner selection
        //int gender = genderSelection.getSelectedItemPosition();
        RadioButton viewButton = (RadioButton) findViewById(R.id.viewUser);
        RadioButton submissionButton = (RadioButton) findViewById(R.id.submissionUser);

        if (viewButton.isChecked()) {
            // EDIT THIS LATER
            String temp = "THE CLICK WORKED";
            Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show();
            viewButton.setChecked(true);
            submissionButton.setChecked(false);
        } else {
            // EDIT THIS LATER
            String temp = "THE CLICK WORKED";
            Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show();
            submissionButton.setChecked(true);
            viewButton.setChecked(false);
        }

    }
}