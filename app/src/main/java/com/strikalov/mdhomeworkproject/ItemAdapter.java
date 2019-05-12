package com.strikalov.mdhomeworkproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList){
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public ItemHolder(View view){
            super(view);

            imageView = view.findViewById(R.id.image_view);
            textView = view.findViewById(R.id.text_description);
        }

        public void bind(int position){

            Item item = itemList.get(position);

            textView.setText(item.getDescription());

            switch (item.getPicture()){
                case FRUIT1:
                    imageView.setImageResource(R.drawable.fruit1);
                    break;
                case FRUIT2:
                    imageView.setImageResource(R.drawable.fruit2);
                    break;
                case FRUIT3:
                    imageView.setImageResource(R.drawable.fruit3);
                    break;
                case VEGETABLE1:
                    imageView.setImageResource(R.drawable.vegetable1);
                    break;
                case VEGETABLE2:
                    imageView.setImageResource(R.drawable.vegetable2);
                    break;
                case VEGETABLE3:
                    imageView.setImageResource(R.drawable.vegetable3);
                    break;
                case NATURE1:
                    imageView.setImageResource(R.drawable.nature1);
                    break;
                case NATURE2:
                    imageView.setImageResource(R.drawable.nature2);
                    break;
                case NATURE3:
                    imageView.setImageResource(R.drawable.nature3);
                    break;
            }

        }

    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        itemHolder.bind(i);
    }
}
