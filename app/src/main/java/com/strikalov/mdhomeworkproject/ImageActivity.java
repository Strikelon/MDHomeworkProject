package com.strikalov.mdhomeworkproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private static final String IMAGE_ACTIVITY_EXTRAS = "IMAGE_ACTIVITY_EXTRAS";

    public static Intent newIntent(Context context, String pictureName){
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(IMAGE_ACTIVITY_EXTRAS, pictureName);
        return intent;
    }

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.image_view);

        if(getIntent() != null){

            String pictureName = null;

            pictureName = getIntent().getStringExtra(IMAGE_ACTIVITY_EXTRAS);

            if(pictureName != null){

                switch (pictureName){
                    case "nav_fruits":
                        imageView.setImageResource(R.drawable.fruits);
                        break;
                    case "nav_vegetables":
                        imageView.setImageResource(R.drawable.vegetables);
                        break;
                    case "nav_nature":
                        imageView.setImageResource(R.drawable.nature);
                        break;
                    default:
                        break;
                }

            }

        }
    }
}
