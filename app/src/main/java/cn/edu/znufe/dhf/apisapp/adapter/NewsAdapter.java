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
import cn.edu.znufe.dhf.apisapp.model.NewsObject;
import cn.edu.znufe.dhf.apisapp.util.GlideUtils;

/**
 * Created by Aaric on 2016/3/21.
 */
public class NewsAdapter extends BaseAdapter {

    private Context mContext;
    private List<NewsObject> mList;

    public NewsAdapter(Context context, List<NewsObject> objects) {
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
        NewsObject newsObject = mList.get(i);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.fragment_item_news, null);
        TextView mTextViewTitle = (TextView) rootView.findViewById(R.id.tv_news_title);
        mTextViewTitle.setText(newsObject.getTitle());
        ImageView mImageViewPic = (ImageView) rootView.findViewById(R.id.iv_news_pic);
        GlideUtils.loadImage(mContext, newsObject.getPicUrl(), mImageViewPic);
        TextView mTextViewDescription = (TextView) rootView.findViewById(R.id.tv_news_description);
        mTextViewDescription.setText(newsObject.getDescription());
        TextView mTextViewCtime = (TextView) rootView.findViewById(R.id.tv_news_ctime);
        mTextViewCtime.setText(newsObject.getCtime());
        return rootView;
    }

}
