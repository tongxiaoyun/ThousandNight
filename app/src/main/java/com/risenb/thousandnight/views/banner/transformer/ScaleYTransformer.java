package com.risenb.thousandnight.views.banner.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/13
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ScaleYTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9F;

    @Override
    public void transformPage(View page, float position) {

        if (position < -1) {
            page.setScaleY(MIN_SCALE);
        } else if (position <= 1) {
            //
            float scale = Math.max(MIN_SCALE, 1 - Math.abs(position));
            page.setScaleY(scale);
            /*page.setScaleX(scale);
            if(position<0){
                page.setTranslationX(width * (1 - scale) /2);
            }else{
                page.setTranslationX(-width * (1 - scale) /2);
            }*/

        } else {
            page.setScaleY(MIN_SCALE);
        }
    }

}