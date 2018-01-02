package com.pethos.pethosdev;

import android.content.Context;
import android.media.Image;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Rahmah Maharani on 1/2/2018.
 */

public class SlidingAd_Adapter extends PagerAdapter {

    private Integer[]  ad = {
            R.drawable.iklan1,
            R.drawable.iklan2,
            R.drawable.iklan3
    };
    private LayoutInflater inflater;
    private Context context;


    public SlidingAd_Adapter(Context context){
        this.context = context;
    }


    public int getCount(){
        return ad.length;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slidingad_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(ad[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }

}

