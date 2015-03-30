package cis350.instaderm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQuery;

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

                ParseObject newuser = new ParseObject("derpyderm"); // TODO: FIGURE OUT OBJECT NAMES
                newuser.put("Gender", genderSelection.getSelectedItem().toString());
                newuser.put("Country", textView.getText().toString()); //TODO: ASK ABOUT RETRIEVING COUNTRY INFO
                newuser.put("Setting", practiceSettingSelection.getSelectedItem().toString());

                newuser.saveInBackground();

                ParseQuery<ParseObject> query = ParseQuery.getQuery("derpyderm");
                //query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() { //TODO: ADJUST THESE
                  //  public void done(ParseObject object, ParseException e) {
                    //    if (e == null) {
                            // object will be your game score
                      //  } else {
                            // something went wrong
                        //}
                //    }
                //});

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