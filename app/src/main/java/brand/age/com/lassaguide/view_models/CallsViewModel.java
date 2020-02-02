package brand.age.com.lassaguide.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import brand.age.com.lassaguide.models.CallModel;

public class CallsViewModel extends ViewModel {

    private MutableLiveData<List<CallModel>> calls;
    private List<CallModel> callModels;

    public CallsViewModel() {
        calls = new MutableLiveData<>();
        callModels = new ArrayList<>();
        callModels.add(new CallModel("","08099793292"));
        callModels.add(new CallModel("", "08039704476"));
        callModels.add(new CallModel("", "08034988560"));
        callModels.add(new CallModel("", "08050595019"));
        calls.setValue(callModels);
    }

    public LiveData<List<CallModel>> getText() {
        return calls;
    }
}