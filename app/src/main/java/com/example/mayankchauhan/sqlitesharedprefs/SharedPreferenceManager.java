package com.example.mayankchauhan.sqlitesharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mayankchauhan on 03/03/17.
 */

public class SharedPreferenceManager {

    private Context context;
    private SharedPreferences preferences;
    private static final int ERROR  = -1;

    public SharedPreferenceManager(Context context , String requiredPref)
    {
        this.context = context;
        preferences = context.getSharedPreferences(requiredPref,Context.MODE_PRIVATE);
    }

    public void addValue(String key , int value)
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public int getValue(String key)
    {

        return preferences.getInt(key,ERROR);
    }

    public void clearPreferences()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
    }
    public void remove(String key)
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
    }

}
