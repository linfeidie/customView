package com.stay4it.testtouch3;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/**
 * 原创作者
 * 谷哥的小弟
 *
 * 博客地址
 * http://blog.csdn.net/lfdfhl
 */
public class ViewPagerAdapter extends PagerAdapter{
    private Context mContext;
    private int[] pagesArray = {R.drawable.a,R.drawable.b, R.drawable.c, R.drawable.d};

    public ViewPagerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return pagesArray.length;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, null);
        itemView.setFocusable(true);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setBackgroundResource(pagesArray[position]);
        ((ViewPager) container).addView(itemView);
        return itemView;
    }


    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
