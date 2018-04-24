package com.example.times.utils;

import android.databinding.BindingAdapter;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Karishma on 17/4/18.
 */

public class BindingUtils {

    @BindingAdapter({"url"})
    public static void loadImage(SimpleDraweeView view,String url){
        if(url != null){
            Uri uri = Uri.parse(url);
            view.setImageURI(uri);
        }
    }
//    @BindingAdapter({"adapter"})
//    public static void setAdapter(RecyclerView view, ArrayList<TopStory>topStories){
//        TopStoryAdapter adapter = new TopStoryAdapter(topStories);
//        view.setAdapter(adapter);
//    }

}
