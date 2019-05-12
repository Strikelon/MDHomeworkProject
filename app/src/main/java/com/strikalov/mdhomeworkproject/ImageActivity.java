package com.strikalov.mdhomeworkproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {

    private static final String IMAGE_ACTIVITY_EXTRAS = "IMAGE_ACTIVITY_EXTRAS";

    public static Intent newIntent(Context context, String pictureName){
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(IMAGE_ACTIVITY_EXTRAS, pictureName);
        return intent;
    }

    private ImageView imageView;
    private TextView textDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.image_view);
        textDescription = findViewById(R.id.text_description);

        if(getIntent() != null){

            String pictureName = null;

            pictureName = getIntent().getStringExtra(IMAGE_ACTIVITY_EXTRAS);

            if(pictureName != null){

                switch (pictureName){
                    case "nav_fruits":
                        imageView.setImageResource(R.drawable.fruits);
                        textDescription.setText(R.string.fruits_description);
                        break;
                    case "nav_vegetables":
                        imageView.setImageResource(R.drawable.vegetables);
                        textDescription.setText(R.string.vegetables_description);
                        break;
                    case "nav_nature":
                        imageView.setImageResource(R.drawable.nature);
                        textDescription.setText(R.string.nature_description);
                        break;
                    default:
                        break;
                }

            }

        }
    }
}
