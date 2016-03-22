package cn.edu.znufe.dhf.apisapp.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.edu.znufe.dhf.apisapp.R;

/**
 * Created by Aaric on 2016/3/22.
 */
public class GlideUtils {

    /**
     * Load image.
     *
     * @param context
     * @param url
     * @param view
     */
    public static void loadImage(Context context, String url, ImageView view) {
        Glide.with(context).load(url).placeholder(R.drawable.glide_loading_white).centerCrop().crossFade().into(view);
    }

}
