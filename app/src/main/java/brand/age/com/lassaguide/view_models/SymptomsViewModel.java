package brand.age.com.lassaguide.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import brand.age.com.lassaguide.models.SymptomsModel;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class SymptomsViewModel extends AndroidViewModel {

    private MutableLiveData<String> symptoms;
    private String hausa_version, english_version;
    private SharedPreferenceManager sharedPreferenceManager;

    public SymptomsViewModel(Application application) {
        super(application);
        symptoms = new MutableLiveData<>();
        sharedPreferenceManager = SharedPreferenceManager.getInstance(application);
        hausa_version = "1. ZAZZABI MAI ZAFI\n\n" +
                "2. CIWON KAI MAI TSANANI\n\n" +
                "3. MURA\n\n" +
                "4. TARI\n\n" +
                "5. CIWON JIKI DA GABOBI\n\n" +
                "6. CIWON KIRJI\n\n" +
                "7. CIWON CIKI\n\n" +
                "8. KASALA\n\n" +
                "9. ZAWO MAI JINI\n\n" +
                "10. FITAR JINI DAGA KUNNE, IDO, HANCI, BAKI DA SAURAN SASSAN JIKI";
        english_version = "1. Fever\n\n" +
                "2. Headache\n\n" +
                "3.\tSore throat\n\n" +
                "4.\tChest and muscle pain\n\n" +
                "5.\tNausea, vomiting and diarrhea\n\n" +
                "6.\tFacial swelling\n\n" +
                "7.\tIn severe cases, bleeding from the mouth, nose, vagina, anus";
        if (sharedPreferenceManager.get_language().equals("HA")){
            symptoms.setValue(hausa_version);
        }else if (sharedPreferenceManager.get_language().equals("EN")){
            symptoms.setValue(english_version);
        }
    }

    public LiveData<String> getText() {
        return symptoms;
    }
}