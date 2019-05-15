package com.strikalov.mdhomeworkproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    private static final String IMAGE_ACTIVITY_EXTRAS = "IMAGE_ACTIVITY_EXTRAS";

    public static Intent newIntent(Context context, String pictureName){
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(IMAGE_ACTIVITY_EXTRAS, pictureName);
        return intent;
    }

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(getIntent() != null){

            String pictureName = null;

            pictureName = getIntent().getStringExtra(IMAGE_ACTIVITY_EXTRAS);

            if(pictureName != null){

                switch (pictureName){
                    case "nav_fruits":
                        itemList = createFruitsList();
                        break;
                    case "nav_vegetables":
                        itemList = createVegetablesList();
                        break;
                    case "nav_nature":
                        itemList = createNatureList();
                        break;
                    default:
                        itemList = new ArrayList<>();
                        break;
                }

            }

            itemAdapter = new ItemAdapter(itemList);
            recyclerView.setAdapter(itemAdapter);

        }
    }

    private List<Item> createFruitsList(){
        List<Item> itemList = new ArrayList<>();
        String itemDescription1 = getString(R.string.fruit1);
        String itemDescription2 = getString(R.string.fruit2);
        String itemDescription3 = getString(R.string.fruit3);
        itemList.add(new Item(Picture.FRUIT1, itemDescription1));
        itemList.add(new Item(Picture.FRUIT2, itemDescription2));
        itemList.add(new Item(Picture.FRUIT3, itemDescription3));
        return itemList;
    }

    private List<Item> createVegetablesList(){
        List<Item> itemList = new ArrayList<>();
        String itemDescription1 = getString(R.string.vegetable1);
        String itemDescription2 = getString(R.string.vegetable2);
        String itemDescription3 = getString(R.string.vegetable3);
        itemList.add(new Item(Picture.VEGETABLE1, itemDescription1));
        itemList.add(new Item(Picture.VEGETABLE2, itemDescription2));
        itemList.add(new Item(Picture.VEGETABLE3, itemDescription3));
        return itemList;
    }

    private List<Item> createNatureList(){
        List<Item> itemList = new ArrayList<>();
        String itemDescription1 = getString(R.string.nature1);
        String itemDescription2 = getString(R.string.nature2);
        String itemDescription3 = getString(R.string.nature3);
        itemList.add(new Item(Picture.NATURE1, itemDescription1));
        itemList.add(new Item(Picture.NATURE2, itemDescription2));
        itemList.add(new Item(Picture.NATURE3, itemDescription3));
        return itemList;
    }
}
