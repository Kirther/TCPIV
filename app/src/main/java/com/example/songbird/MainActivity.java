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

public class MainActivity extends AppCompatActivity {

    TextView continueText;

    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Button goToMainMenuButton = findViewById(R.id.GoToMainMenuButton);

        continueText = (TextView) findViewById(R.id.mainContinueText);

        goToMainMenuButton.setOnClickListener(new View.OnClickListener()
                                              {
                                                  public void onClick(View v)
                                                  {
                                                      OpenMainMenu();
                                                  }
                                              }
        );
        
        LoadData();
        UpdateView();
    }

    private void LoadData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        language = preferences.getString(new SettingsScreen().LANGUAGE_CHOICE, "Portuguese");
    }

    private void UpdateView() {
        continueText.setText(continueString(language));
    }

    private void OpenMainMenu() {
        Intent gameScreen = new Intent (this , GameMainMenu.class);
        startActivity(gameScreen);
    }

    public String continueString(String args)
    {
        String text = args;
        String displayText;
        switch (text) {
            case "Portuguese":
                displayText = "Clique para Continuar";
                break;

            case "English":
                displayText = "Tap to Continue";
                break;

            default:
                displayText = "Clique para Continuar";
        }
        return displayText;
    }


}