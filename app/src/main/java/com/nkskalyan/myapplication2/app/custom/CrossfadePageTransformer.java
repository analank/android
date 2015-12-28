package com.nkskalyan.myapplication2.app.custom;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nkskalyan.myapplication2.app.R;

/**
 * Created by knachiappan on 10/9/15.
 */
public class CrossfadePageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();

        View backgroundView = page.findViewById(R.id.background);
        View welcomeText = page.findViewById(R.id.tv_welcome);
        View firstText = page.findViewById(R.id.tv_first_desc);
        View secondText = page.findViewById(R.id.tv_second_desc);
        View thirdText = page.findViewById(R.id.tv_third_desc);

        if(position <= -1.0f || position >= 1.0f) {
        } else if( position == 0.0f ) {
            backgroundView.setScaleX(1);
            backgroundView.setScaleY(1);
        } else {
            if(backgroundView != null) {
                page.setTranslationX(pageWidth * -position);
                backgroundView.setAlpha(1.0f - Math.abs(position));
            }

            //Text both translates in/out and fades in/out
            if (welcomeText != null) {
                welcomeText.setTranslationX(pageWidth * position);
                welcomeText.setAlpha(1.0f - Math.abs(position));
            }

            if (firstText != null) {
                firstText.setTranslationX(pageWidth * position);
                firstText.setAlpha(1.0f - Math.abs(position));
            }

            if (secondText != null) {
                secondText.setTranslationX(pageWidth * position);
                secondText.setAlpha(1.0f - Math.abs(position));
            }

            if (thirdText != null) {
                thirdText.setTranslationX(pageWidth * position);
                thirdText.setAlpha(1.0f - Math.abs(position));
            }
        }
    }
}