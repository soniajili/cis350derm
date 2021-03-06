package cis350.instaderm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.text.ParseException;

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

        //initialize Parse
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "fviaFJ9B1jQdWCCnS419jkZ8dFVquHBd1lu0Y1jF", "p6dYSbB0KVF7KPvstO2ui7B32RanUEj9vmS28DLi");


        //Get email information
        final EditText email = (EditText) findViewById(R.id.emailLabel);

        // Add gender information
        genderSelection = (Spinner) findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSelection.setAdapter(genderAdapter);

        // Add country information
        // TODO: Ensure that final doesn't limit the capabilities of textView
        final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
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

        register = (Button) findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("foo", "bar");
                testObject.saveInBackground();


                String username = email.getText().toString();


                ParseObject newuser = new ParseObject(username); // TODO: FIGURE OUT OBJECT NAMES

                newuser.put("Gender", genderSelection.getSelectedItem().toString());
                newuser.put("Country", textView.getText().toString()); //TODO: ASK ABOUT RETRIEVING COUNTRY INFO
                newuser.put("Setting", practiceSettingSelection.getSelectedItem().toString());

                newuser.saveInBackground();

                String objectId = newuser.getObjectId();

                Intent intent = new Intent(getApplicationContext(), DisclaimerActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {

        // Get the spinner selection
        //int gender = genderSelection.getSelectedItemPosition();
        RadioButton viewButton = (RadioButton) findViewById(R.id.viewUser);
        RadioButton submissionButton = (RadioButton) findViewById(R.id.submissionUser);

        if (viewButton.isChecked()) {
            // TODO: EDIT THIS LATER
            viewButton.setChecked(true);
            submissionButton.setChecked(false);
        } else {
            // TODO: EDIT THIS LATER
            submissionButton.setChecked(true);
            viewButton.setChecked(false);
        }

    }


}