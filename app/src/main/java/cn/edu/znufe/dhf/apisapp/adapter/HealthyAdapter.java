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
import cn.edu.znufe.dhf.apisapp.model.HealthyObject;
import cn.edu.znufe.dhf.apisapp.util.DateUtils;
import cn.edu.znufe.dhf.apisapp.util.GlideUtils;

/**
 * Created by Aaric on 2016/3/21.
 */
public class HealthyAdapter extends BaseAdapter {

    private Context mContext;
    private List<HealthyObject> mList;

    public HealthyAdapter(Context context, List<HealthyObject> objects) {
        this.mContext = context;
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
        HealthyObject healthyObject = mList.get(i);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.fragment_item_healthy, null);
        TextView mTextViewCount = (TextView) rootView.findViewById(R.id.tv_healthy_count);
        mTextViewCount.setText("阅读：" + healthyObject.getCount() + "次");
        TextView mTextViewTime = (TextView) rootView.findViewById(R.id.tv_healthy_time);
        mTextViewTime.setText(DateUtils.getFormatString(healthyObject.getTime()));
        ImageView mImageViewImg = (ImageView) rootView.findViewById(R.id.iv_healthy_img);
        GlideUtils.loadImage(mContext, "http://tnfs.tngou.net/img" + healthyObject.getImg(), mImageViewImg);
        TextView mTextViewTitle = (TextView) rootView.findViewById(R.id.tv_healthy_title);
        mTextViewTitle.setText(healthyObject.getTitle());
        return rootView;
    }

}
