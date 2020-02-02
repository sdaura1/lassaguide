package brand.age.com.lassaguide.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class PrecautionsViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    SharedPreferenceManager sharedPreferenceManager;
    String english_version, hausa_version;

    public PrecautionsViewModel(Application application) {
        super(application);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(application);
        mText = new MutableLiveData<>();
        english_version = "1.\tWash your hands regularly.\n\n" +
                "2.\tStore food in containers.\n\n" +
                "3.\tKeep your home clean and tidy to discourage rats from entering.\n\n" +
                "4.\tKeep a cat.\n\n" +
                "5.\tCook all foods thoroughly.";
        hausa_version = "1.\tWanke hannaye akai-akai\n\n" +
                "2.\tAjiye abinci da kayan abinci a rufaffen wuri\n\n" +
                "3.\tTsaftace gida don kar beraye su dinga shiga\n\n" +
                "4.\tAjiye Kyanwa a gida.\n\n" +
                "5.\tTabbatar abinci ya dahu sosai kafin a sauke.";

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