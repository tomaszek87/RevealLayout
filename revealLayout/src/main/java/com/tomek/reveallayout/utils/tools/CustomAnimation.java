package com.tomek.reveallayout.utils.tools;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by Tomek on 20.02.2016.
 */
public class CustomAnimation {

    private static SupportAnimator animator;

    private void prepareAnimation(final LinearLayout llToReveal, final boolean b, int i) {
        int cx, cy;
        if(i==0)
            cx = (llToReveal.getLeft() + llToReveal.getRight() / 2);
        else
            cx = llToReveal.getRight() - 50;
        cy = (llToReveal.getTop() + llToReveal.getBottom()) / 2;
        if(i==2){
            cx = (llToReveal.getLeft() + llToReveal.getRight() / 2);
            cy = llToReveal.getBottom() + 100;
        }
        int radius = Math.max(llToReveal.getWidth(), llToReveal.getHeight());
        if (b)
            animator = ViewAnimationUtils.createCircularReveal(llToReveal, cx, cy, 0, radius);
        else
            animator = ViewAnimationUtils.createCircularReveal(llToReveal, cx, cy, radius, 0);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(400);
        animator.addListener(new SupportAnimator.AnimatorListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                llToReveal.clearAnimation();
                if (!b) {
                    llToReveal.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationCancel() {

            }

            @Override
            public void onAnimationRepeat() {

            }
        });
    }

    public void toggleAnimation(final LinearLayout llToReveal, boolean hidden, int i) {
        if (hidden) {
            prepareAnimation(llToReveal, hidden, i);
            llToReveal.setVisibility(View.VISIBLE);
            animator.start();
        } else {
            prepareAnimation(llToReveal, hidden, i);
            animator.start();
        }
    }

}
