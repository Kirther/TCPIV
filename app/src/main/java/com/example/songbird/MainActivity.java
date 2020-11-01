package com.example.songbird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Button goToMainMenuButton = findViewById(R.id.GoToMainMenuButton);

        goToMainMenuButton.setOnClickListener(new View.OnClickListener()
                                              {
                                                  public void onClick(View v)
                                                  {
                                                      OpenMainMenu();
                                                  }
                                              }
        );
    }

    private void OpenMainMenu() {
        Intent gameScreen = new Intent (this , GameMainMenu.class);
        startActivity(gameScreen);
    }


}