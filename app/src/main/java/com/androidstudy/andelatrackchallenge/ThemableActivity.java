package com.androidstudy.andelatrackchallenge;

import android.content.res.Resources;
import android.support.annotation.StyleRes;

import com.androidstudy.andelatrackchallenge.settings.Settings;

import timber.log.Timber;

/**
 * Created by anonymous on 11/2/17.
 */

public abstract class ThemableActivity extends BaseActivity {
    public static final int[] themes = {R.style.AppTheme, R.style.AppTheme_Light};
    private int themeIndex = Settings.themeIndex();

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, getThemeRes(themeIndex), first);
    }

    @Override
    protected boolean shouldRestart() {
        return themeIndex != Settings.themeIndex();
    }

    @StyleRes
    protected int getThemeRes(int index) {
        try {
            return themes[index];
        } catch (Exception e) {
            Timber.e(e);
            return themes[0];
        }
    }
}
