package com.example.lginapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (validateInputs(username, password)) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Successful if usẻname true and password true
                }
            }
        });
    }

    private boolean validateInputs(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            usernameInput.setError("Username is required");
            return false;
        }

//        if (!isValidUsername(username)) {
//            usernameInput.setError("Username must contain both letters and numbers or only letters");
//            return false;
//        }

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required");
            return false;
        }

        // Check if password meets the criteria
        if (!isValidPassword(password)) {
            passwordInput.setError("Password must be at least 8 characters, with one uppercase and one lowercase letter");
            return false;
        }

        return true;
    }

//    private boolean isValidUsername(String username) {
//        Pattern usernamePattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)|^[a-zA-Z]+$");
//        return usernamePattern.matcher(username).matches();
//    }

    private boolean isValidPassword(String password) {
        // Password 8 letter and 1 word uppercase 1 lowercase
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).{8,}$");
        return passwordPattern.matcher(password).matches();
    }
}
