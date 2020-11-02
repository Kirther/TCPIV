package com.example.songbird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class GameMainMenu extends AppCompatActivity {

    Button menu_startButton;
    Button menu_shopButton;
    Button menu_settingsButton;
    Button menu_creditsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_main_menu);

        menu_startButton = findViewById(R.id.startButton);
        menu_shopButton = findViewById(R.id.shopButton);
        menu_settingsButton = findViewById(R.id.settingsButton);
        menu_creditsButton = findViewById(R.id.creditsButton);

        menu_startButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NotYetImplementedMessage();
            }
        });

        menu_shopButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NotYetImplementedMessage();
            }
        });

        menu_settingsButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NotYetImplementedMessage();
            }
        });

        menu_creditsButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                OpenCreditsScreen();
            }
        });

    }

    private void OpenCreditsScreen() {
        Intent gameScreen = new Intent (this, CreditsScreen.class);
        startActivity(gameScreen);
    }

    private void NotYetImplementedMessage() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, "Button not yet implemented", duration).show();
    }
}