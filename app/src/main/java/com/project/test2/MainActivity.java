package com.project.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonWishLuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonWishLuck = findViewById(R.id.buttonWishLuck);

        buttonWishLuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextName.getText().toString().trim();

                if (userName.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.please_enter_name_toast), Toast.LENGTH_SHORT).show();
                } else {
                    // Navigate to SecondActivity and pass the name
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("USER_NAME", userName);
                    startActivity(intent);
                }
            }
        });
    }
}