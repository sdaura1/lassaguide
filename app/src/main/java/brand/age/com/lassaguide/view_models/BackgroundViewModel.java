package brand.age.com.lassaguide.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BackgroundViewModel extends ViewModel {

    private MutableLiveData<List<String>> mText;
    List<String> background;

    public BackgroundViewModel() {
        mText = new MutableLiveData<>();
        background = new ArrayList<>();
        background.add("Cutar Lassa cuta ce mai tsanani wadda ke yin kisa da gaggawa");
        background.add("Ana kamuwa da ita ta hanyar fitsari ko kashin bera ko cin bera");
        background.add("Tara shara barkatai da rashin tsaftar muhalli ko ta jiki kan haddasa kwayar cutar");
        mText.setValue(background);
    }

    public LiveData<List<String>> getText() {
        return mText;
    }
}