package com.univ_amu.myapplication.data;

import android.content.res.Resources;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.univ_amu.myapplication.R;

public class ConverterUtil {
    @BindingAdapter("app:time")
    public static void setTime(TextView view, String time) {
        if (time == null) return;
        Resources resources = view.getContext().getApplicationContext().getResources();
        view.setText(getStringFromDate(resources, time));
    }

    private static String getStringFromDate(Resources resources, String time) {
        int intTime = Integer.parseInt(time);
        int hourCount = intTime / 60;
        int minCount = intTime % 60;

        if (hourCount >= 1)
            return resources.getQuantityString(R.plurals.hours, hourCount, hourCount, minCount);

        return resources.getString(R.string.minutes, minCount);
    }
}
