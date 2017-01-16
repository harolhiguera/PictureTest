package com.lazada.picturetest.helpers;

import android.content.Context;
import android.graphics.Typeface;

import com.lazada.picturetest.application.App;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public class Utils {

    public static Typeface AdventProRegular = Typeface.createFromAsset(App.resources.getAssets(), "fonts/AdventPro-Regular.ttf");
    public static Typeface AdventProSemiBold = Typeface.createFromAsset(App.resources.getAssets(), "fonts/AdventPro-SemiBold.ttf");



    public static int dpFromPx(final Context context, final int px) {
        return (int) (px / context.getResources().getDisplayMetrics().density);
    }

    public static int pxFromDp(final Context context, final int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

}
