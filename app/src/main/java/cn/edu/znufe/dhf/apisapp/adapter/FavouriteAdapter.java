package cn.edu.znufe.dhf.apisapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.znufe.dhf.apisapp.R;
import cn.edu.znufe.dhf.apisapp.entity.FavouriteData;
import cn.edu.znufe.dhf.apisapp.util.GlideUtils;

/**
 * Created by aaric on 16/4/24.
 */
public class FavouriteAdapter extends BaseAdapter {

    private Context mContext;
    private List<FavouriteData> mList;

    public FavouriteAdapter(Context mContext, List<FavouriteData> objects) {
        this.mContext = mContext;
        this.mList = objects;
    }

    @Override
    public int getCount() {
        return null == mList? 0: mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FavouriteData favouriteDataObject = mList.get(i);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.listview_item_favourite, null);
        TextView mTextViewTagNamge = (TextView) rootView.findViewById(R.id.tv_favourite_tagname);
        mTextViewTagNamge.setText(favouriteDataObject.getTagName());
        TextView mTextViewDate = (TextView) rootView.findViewById(R.id.tv_favourite_date);
        mTextViewDate.setText(favouriteDataObject.getDate());
        ImageView mImageViewImage = (ImageView) rootView.findViewById(R.id.tv_favourite_image);
        GlideUtils.loadImage(mContext, favouriteDataObject.getImageUrl(), mImageViewImage);
        TextView mTextViewTitle = (TextView) rootView.findViewById(R.id.tv_favourite_title);
        mTextViewTitle.setText(favouriteDataObject.getTitle());
        return rootView;
    }

}
