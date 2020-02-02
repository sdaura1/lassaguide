package brand.age.com.lassaguide.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.logging.SocketHandler;

import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class FirstAidViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    SharedPreferenceManager sharedPreferenceManager;
    String english_version, hausa_version;

    public FirstAidViewModel(Application application) {
        super(application);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(application);
        mText = new MutableLiveData<>();
        english_version = "1.\tSeek health advice immediately\n\n" +
                "2.\tAvoid contact with other people\n\n" +
                "3.\tDrink plenty of fluids\n\n" +
                "4.\tRibavirin, an antiviral drug, can be an effective treatment if given early";
        hausa_version = "1.\tKa guji haduwa da sauran jama’a\n\n" +
                "2.\tNemi taimakon likitoci da gaggawa\n\n" +
                "3.\tKa yawaita shan abu mai ruwa-ruwa\n\n" +
                "4.\tRibavirin, maganin kwayar cutar virus ne, zai iya magance cutar idan ansha shi da wuri.";
        if (sharedPreferenceManager.get_language().equals("HA")){
            mText.setValue(hausa_version);
        }else if (sharedPreferenceManager.get_language().equals("EN")){
            mText.setValue(english_version);
        }
    }

    public LiveData<String> getText() {
        return mText;
    }
}