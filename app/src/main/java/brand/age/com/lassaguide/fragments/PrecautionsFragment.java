package brand.age.com.lassaguide.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;
import brand.age.com.lassaguide.view_models.PrecautionsViewModel;

public class PrecautionsFragment extends Fragment {

    private PrecautionsViewModel precautionsViewModel;
    private SharedPreferenceManager sharedPreferenceManager;
    private TextView heading, textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        precautionsViewModel =
                ViewModelProviders.of(this).get(PrecautionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_precautions, container, false);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(getContext());
        textView = root.findViewById(R.id.text_precautions);
        heading = root.findViewById(R.id.preventions_heading);
        precautionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Matakan Kariya");
        }else {
            heading.setText("Precautions");
        }
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        precautionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Matakan Kariya");
        }else {
            heading.setText("Precautions");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        precautionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Matakan Kariya");
        }else {
            heading.setText("Precautions");
        }
    }
}