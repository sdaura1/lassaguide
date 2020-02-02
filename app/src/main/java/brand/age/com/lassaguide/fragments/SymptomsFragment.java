package brand.age.com.lassaguide.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.logging.SocketHandler;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;
import brand.age.com.lassaguide.view_models.SymptomsViewModel;

public class SymptomsFragment extends Fragment {

    private SymptomsViewModel symptomsViewModel;
    private SharedPreferenceManager sharedPreferenceManager;
    private TextView textView;
    private TextView heading;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        symptomsViewModel =
                ViewModelProviders.of(this).get(SymptomsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_symptoms, container, false);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(getContext());
        textView = root.findViewById(R.id.sym_text);
        heading = root.findViewById(R.id.symptom_heading);
        symptomsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String symptomsModels) {
                textView.setText(symptomsModels);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("ALAMUN ZAZZABIN LASSA");
        }else if (sharedPreferenceManager.get_language().equals("EN")){
            heading.setText("SYMPTOMS");
        }
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        symptomsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String symptomsModels) {
                textView.setText(symptomsModels);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("ALAMUN LASSA");
        }else if (sharedPreferenceManager.get_language().equals("EN")){
            heading.setText("SYMPTOMS");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        symptomsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String symptomsModels) {
                textView.setText(symptomsModels);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("ALAMUN LASSA");
        }else if (sharedPreferenceManager.get_language().equals("EN")){
            heading.setText("SYMPTOMS");
        }
    }
}