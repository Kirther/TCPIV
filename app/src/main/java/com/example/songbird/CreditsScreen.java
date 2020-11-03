package com.example.songbird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CreditsScreen extends AppCompatActivity {

    Button returnButton;

    TextView credits_Title;
    TextView programadorText;
    TextView artista1Text;
    TextView artista2Text;

    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_credits_screen);

        credits_Title = (TextView) findViewById(R.id.credits_Text);
        programadorText = (TextView) findViewById(R.id.programador_text);
        artista1Text = (TextView) findViewById(R.id.artista1_text);
        artista2Text = (TextView) findViewById(R.id.artista2_Text);

        language = new SettingsScreen().selected_Language;

        returnButton = findViewById(R.id.credits_returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturnToMainMenu();
            }
        });

        LoadData();
        UpdateView();
    }

    private void LoadData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        language = preferences.getString(new SettingsScreen().LANGUAGE_CHOICE, "Portuguese");
    }

    private void UpdateView() {
            credits_Title.setText(creditsString(language));
            programadorText.setText(programadorString(language));
            artista1Text.setText(artistaString(language));
            artista2Text.setText(artistaString(language));
    }

    private void ReturnToMainMenu() {
        Intent gameScreen = new Intent (this , GameMainMenu.class);
        startActivity(gameScreen);
    }

    public String creditsString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Créditos";
                break;

            case "English":
                displayText = "Credits";
                break;

            default:
                displayText = "Créditos";
        }
        return displayText;
    }

    public String programadorString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Programador";
                break;

            case "English":
                displayText = "Programmer";
                break;

            default:
                displayText = "Programador";
        }
        return displayText;
    }

    public String artistaString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Artista";
                break;

            case "English":
                displayText = "Artist";
                break;

            default:
                displayText = "Artista";
        }
        return displayText;
    }
}