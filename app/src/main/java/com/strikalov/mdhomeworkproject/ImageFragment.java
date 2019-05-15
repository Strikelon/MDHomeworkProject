package com.strikalov.mdhomeworkproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageFragment extends Fragment {

    private static final String ARGS = "ARGS";

    public static ImageFragment newInstance(int tabNumber){
        ImageFragment imageFragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS, tabNumber);
        imageFragment.setArguments(args);
        return imageFragment;
    }

    private ImageView imageView;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_image, container, false);

        imageView = view.findViewById(R.id.fragment_image_view);
        textView = view.findViewById(R.id.fragment_text_description);

        if(getArguments() != null && getArguments().getInt(ARGS)!= 0){

            int tabNumber = getArguments().getInt(ARGS);

            switch (tabNumber){
                case 1:
                    imageView.setImageResource(R.drawable.nature1);
                    textView.setText(R.string.nature1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.nature2);
                    textView.setText(R.string.nature2);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.nature3);
                    textView.setText(R.string.nature3);
                    break;
                default:
                    break;
            }

        }

        return view;
    }

}
