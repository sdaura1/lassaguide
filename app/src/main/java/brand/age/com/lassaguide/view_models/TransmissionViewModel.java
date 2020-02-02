package brand.age.com.lassaguide.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class TransmissionViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    String english_version, hausa_version;
    SharedPreferenceManager sharedPreferenceManager;

    public TransmissionViewModel(Application application) {
        super(application);
        mText = new MutableLiveData<>();
        sharedPreferenceManager = SharedPreferenceManager.getInstance(application);
        english_version = "1. Direct contact with urine, faeces" +
                ", saliva or blood of infected rodents (Rats).\n\n" +
                "2. Ingesting food and drinks contaminated with urine," +
                " faeces, saliva or blood of infected rats.\n\n" +
                "3. Contact with objects, household items or surfaces contaminated " +
                "with urine, faeces, saliva or blood of infected rats.\n\n" +
                "4. Person-to-person transmission can also occur through " +
                "contact with blood, urine," +
                " faeces, vomitus and other body fluids of an infected person," +
                " particularly in hospital environment where infection prevention" +
                " and control practices are not optimal.\n\n" +
                "5. Catching and preparing infected rats as food";

        hausa_version = "1. Ta'ammali da fitsari, kashi, yawu ko jinin bera mai dauke" +
                " da cutar.\n\n" +
                "2. Hadiyar gurbataccen abinci ko abin sha wanda ya cudanya da fitsari," +
                " kashi, yawu ko jinin bera mai dauke da cutar.\n\n" +
                "3. Cudanya da duk wani abu ko guraben da suka cudanya da fitsari," +
                " kashi, yawu ko jinin bera mai dauke da cutar.\n\n" +
                "4. Yaduwa daga mutum zuwa mutum ma zai iya faruwa tahanyar taba  fitsari," +
                " bayan gari, yawu, jinin ko wani ruwa na jikin mai zazzabin Lassa," +
                " musamman a asubitotin da babu kyakkyawar hanyar kariya ko " +
                "isassun kayan aikin kare kai.\n\n\n\n" +

                "Matakin Haduran kamuwa\n\n1. Babu hatsarin kamuwa dan ka gifta daga inda mai cutar yake. \n\n" +
                "Misali: zama akan mazauni daya a motar haya ko benci matsawar babu" +
                " cudanyar hada jiki.\n\n" +
                "2. Mai yiwuwa a samu hadarin kamuwa ta hanyar hada jiki.\n\n" +
                "Misali: Hada fiska da fuska, sumbata, awon jini ko tempreture.\n\n" +
                "3. Akwai hatsarin kamuwa ta hanyar zama kusa da kusa kamar hada jiki " +
                "da mai zazzabin lassa wanda yake tari, amai, gudawa ko zubar jini.\n\n" +
                "Akwai matukar hatsarin kamuwa da lassa ga wanda jininsa ya cudanya da" +
                " abubuwa masu kaifi ko tsine wadanda suka shafi mai tsananin zazzabin" +
                " lassa kamar jini, yawu, majina, amai, bayan gida ko duk wani ruwan jikin" +
                " sa ko samfurin tutar daga laboratory ko wata hanyar gwaji.";

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