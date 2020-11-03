package com.example.songbird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsScreen extends AppCompatActivity {

    Button settingsReturnButton;

    TextView settings_Text;
    TextView music_Text;
    TextView language_Text;

    Spinner language_Select;
    String [] languages = new String[] {"Português", "English"};

    String selected_Language;

    public static final String CREDITS_PREFS = "sharedPrefs";
    public static final String LANGUAGE_CHOICE = "language_choice";
    int spinner_Position = 0;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings_screen);

        settingsReturnButton = (Button) findViewById(R.id.settings_returnButton);

        settings_Text = (TextView) findViewById(R.id.settings_Settings);
        music_Text = (TextView) findViewById(R.id.settings_Sound);
        language_Text = (TextView) findViewById(R.id.settings_Language);

        language_Select = (Spinner) findViewById(R.id.settings_LanguageSelect);

        settingsReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturnToMainMenu();
            }
        });

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language_Select.setAdapter(adapter);
        language_Select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(position)
                {
                    case 0:
                        selected_Language = "Portuguese";
                        UpdateView();
                        saveData();

                        /* Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, "Portuguese Selected", duration).show(); */

                        break;
                    case 1:
                        selected_Language = "English";
                        UpdateView();
                        saveData();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        LoadData();
        UpdateView();

    }

    private void UpdateView() {
        settings_Text.setText(settingsString(selected_Language));
        music_Text.setText(musicString(selected_Language));
        language_Text.setText(languageString(selected_Language));
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(CREDITS_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(LANGUAGE_CHOICE, selected_Language);
        editor.putInt("spinner_Position", language_Select.getSelectedItemPosition());

        /* Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, String.valueOf(language_Select.getSelectedItemPosition()), duration).show(); */

        editor.apply();
    }

    private void LoadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(CREDITS_PREFS, MODE_PRIVATE);

        selected_Language = sharedPreferences.getString(LANGUAGE_CHOICE, "Portuguese");
        index = sharedPreferences.getInt("spinner_Position", 0);
        language_Select.setSelection(index);
    }

    private void ReturnToMainMenu() {
        Intent gameScreen = new Intent (this , GameMainMenu.class);
        startActivity(gameScreen);
    }

    public String settingsString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Configurações";
                break;

            case "English":
                displayText = "Settings";
                break;

            default:
                displayText = "Configurações";
        }
        return displayText;
    }

    public String musicString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Música";
                break;

            case "English":
                displayText = "Music";
                break;

            default:
                displayText = "Música";
        }
        return displayText;
    }
    public String languageString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Língua";
                break;

            case "English":
                displayText = "Language";
                break;

            default:
                displayText = "Língua";
        }
        return displayText;
    }
}