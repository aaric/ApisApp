package cn.edu.znufe.dhf.apisapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.znufe.dhf.apisapp.R;
import cn.edu.znufe.dhf.apisapp.model.NewsObject;

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
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.fragment_item_news, null);
        TextView newsTitle = (TextView) rootView.findViewById(R.id.news_title);
        newsTitle.setText(mList.get(i).getTitle());
        TextView newsTime = (TextView) rootView.findViewById(R.id.news_time);
        newsTime.setText(mList.get(i).getCtime());
        return rootView;
    }

}
