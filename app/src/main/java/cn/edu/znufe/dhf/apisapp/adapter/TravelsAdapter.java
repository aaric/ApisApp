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
import cn.edu.znufe.dhf.apisapp.model.TravelsObject;
import cn.edu.znufe.dhf.apisapp.util.GlideUtils;

/**
 * Created by Aaric on 2016/3/21.
 */
public class TravelsAdapter extends BaseAdapter {

    private Context mContext;
    private List<TravelsObject> mList;

    public TravelsAdapter(Context context, List<TravelsObject> objects) {
        this.mContext = context;
        this.mList = objects;
    }

    @Override
    public int getCount() {
        return mList.size();
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
        TravelsObject travelsObject = mList.get(i);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.fragment_item_travels, null);
        TextView mTextViewUserName = (TextView) rootView.findViewById(R.id.tv_travels_user_name);
        mTextViewUserName.setText("作者：" + travelsObject.getUserName());
        TextView mTextViewStartTime = (TextView) rootView.findViewById(R.id.tv_travels_start_time);
        mTextViewStartTime.setText(travelsObject.getStartTime());
        ImageView mImageViewHeadImage = (ImageView) rootView.findViewById(R.id.iv_travels_head_image);
        GlideUtils.loadImage(mContext, travelsObject.getHeadImage(), mImageViewHeadImage);
        TextView mTextViewTitle = (TextView) rootView.findViewById(R.id.tv_travels_title);
        mTextViewTitle.setText(travelsObject.getTitle());
        return rootView;
    }

}
