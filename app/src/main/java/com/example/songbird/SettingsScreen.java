package com.example.songbird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SettingsScreen extends AppCompatActivity {

    Button settingsReturnButton;

    TextView settings_Text;
    TextView music_Text;
    TextView language_Text;

    Spinner language_Select;
    String [] languages = new String[] {"Português", "English"};

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
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, "Portuguese Selected", duration).show();
                        break;
                    case 1:
                        Context context2 = getApplicationContext();
                        int duration2 = Toast.LENGTH_SHORT;
                        Toast.makeText(context2, "English Selected", duration2).show();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void ReturnToMainMenu() {
        Intent gameScreen = new Intent (this , GameMainMenu.class);
        startActivity(gameScreen);
    }
}