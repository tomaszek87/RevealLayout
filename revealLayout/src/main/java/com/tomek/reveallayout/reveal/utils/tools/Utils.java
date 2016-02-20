package com.tomek.reveallayout.reveal.utils.tools;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Tomek on 13.02.2016.
 */
public class Utils {

    public static WindowManager.LayoutParams setDialogLayoutParams(Activity activity, Dialog dialog, double v)
    {
        try
        {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point screenSize = new Point();
            display.getSize(screenSize);
            int width = screenSize.x;
            int height = screenSize.y;

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = (width);
            layoutParams.height = (int) (height * v);
            return layoutParams;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
