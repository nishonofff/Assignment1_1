package com.example.garik.assignment1.Adapters;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by GaRiK on 08.08.2018.
 */

public class CustomSetter {

    @BindingAdapter("imgSrc")
    public static void setImgSrc(ImageView view,int resId){
        view.setImageDrawable((view.getContext().getDrawable(resId)));
        Picasso.with(view.getContext())
                .load(resId)
                .into(view);
    }
}
