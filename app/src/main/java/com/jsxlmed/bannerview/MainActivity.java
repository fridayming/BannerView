package com.jsxlmed.bannerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jsxlmed.bannerview.view.CustomBanner;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private CustomBanner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner=findViewById(R.id.banner);
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner5);
        images.add(R.mipmap.banner6);

        setBean(images);
        banner.isTurning();
        banner.startTurning(2000);
        banner.setOnPageClickListener(new CustomBanner.OnPageClickListener() {
            @Override
            public void onPageClick(int position, Object o) {
                //banner.stopTurning();
                Toast.makeText(getApplicationContext(),"第"+position+"张",Toast.LENGTH_SHORT).show();
            }
        });

    }

    //设置普通指示器
    private void setBean(final ArrayList<Integer> beans) {
        banner.setPages(new CustomBanner.ViewCreator<Integer>() {
            @Override
            public View createView(Context context, int position) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
            @Override
            public void updateUI(Context context, View view, int position, Integer entity) {
                Glide.with(context).load(entity).into((ImageView) view);
            }
        }, beans);
    }


}
