package com.einfochips.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.einfochips.exam4.databinding.ActivitySetMessageBinding;

public class SetMessage extends AppCompatActivity {
    ActivitySetMessageBinding setMessageBinding;
    private static final String PREFS_FILE_NAME = "MyPrefsFile";
    private static final String KEY_TEXT = "storedText";

    private EditText editText;
    private Button saveButton;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMessageBinding = ActivitySetMessageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_set_message);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);


        sharedPreferences = getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                saveText(text);
                Toast.makeText(SetMessage.this, "text save", Toast.LENGTH_SHORT).show();
            }
        });

        // Display the stored text, if available
        String storedText = getStoredText();
        editText.setText("Stored Text: " + storedText);
    }



    private void saveText(String text) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TEXT, text);
        editor.apply();
        editText.setText(text);
    }

    private String getStoredText() {
        return sharedPreferences.getString(KEY_TEXT, "");
    }
}