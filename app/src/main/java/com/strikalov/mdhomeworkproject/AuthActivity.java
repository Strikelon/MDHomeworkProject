package com.strikalov.mdhomeworkproject;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {

    private static final int maxLength = 20;

    private View coordinatorLayout;
    private EditText editText;
    private Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int editTextLength = editText.getText().length();

                if(editTextLength == 0){
                    showSnackbar(R.string.edit_text_empty_error);
                }else if(editTextLength > 20){
                    showSnackbar(R.string.edit_text_max_length_error);
                }else {
                    startMainNavigationActivity();
                }

            }
        });
    }

    private void initViews(){
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        editText = findViewById(R.id.editText);
        enterButton = findViewById(R.id.enter_button);
    }

    private void showSnackbar(int message){
        final Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(R.string.snackbar_ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    private void startMainNavigationActivity(){
        Intent intent = new Intent(this, MainNavigationActivity.class);
        startActivity(intent);
    }
}
