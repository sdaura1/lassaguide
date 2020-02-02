package brand.age.com.lassaguide.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class SharedPreferenceManager {
    private SharedPreferences prefs;
    private static final String PREFS = "prefs";
    private static final String LANGUAGE = "language";
    private static SharedPreferenceManager Instance =  null;

    private SharedPreferenceManager(@NonNull Context context){
        this.prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        Instance = this;
    }

    public static SharedPreferenceManager getInstance(@NonNull Context context){
        if (Instance == null){
            Instance = new SharedPreferenceManager(context);
        }
        return Instance;
    }

    public void save_language(String languatge){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LANGUAGE, languatge);
        editor.apply();
    }

    public String get_language(){
        return prefs.getString(LANGUAGE, "HA");
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
