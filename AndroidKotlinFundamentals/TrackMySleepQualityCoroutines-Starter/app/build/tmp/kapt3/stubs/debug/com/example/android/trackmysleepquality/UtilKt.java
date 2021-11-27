package com.example.android.trackmysleepquality;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"convertLongToDateString", "", "systemTime", "", "convertNumericQualityToString", "quality", "", "resources", "Landroid/content/res/Resources;", "app_debug"})
public final class UtilKt {
    
    /**
     * Returns a string representing the numeric quality rating.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String convertNumericQualityToString(int quality, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources resources) {
        return null;
    }
    
    /**
     * Take the Long milliseconds returned by the system and stored in Room,
     * and convert it to a nicely formatted string for display.
     *
     * EEEE - Display the long letter version of the weekday
     * MMM - Display the letter abbreviation of the nmotny
     * dd-yyyy - day in month and full year numerically
     * HH:mm - Hours and minutes in 24hr format
     */
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    public static final java.lang.String convertLongToDateString(long systemTime) {
        return null;
    }
}