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

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;
import brand.age.com.lassaguide.view_models.TransmissionViewModel;

public class TransmissionFragment extends Fragment {

    private TransmissionViewModel transmissionViewModel;
    private SharedPreferenceManager sharedPreferenceManager;
    private TextView heading, textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        transmissionViewModel =
                ViewModelProviders.of(this).get(TransmissionViewModel.class);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(getContext());
        View root = inflater.inflate(R.layout.fragment_transmission, container, false);
        textView = root.findViewById(R.id.trans_text);
        heading = root.findViewById(R.id.transmission_heading);
        transmissionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        transmissionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Hanyoyin Kamuwa");
        }else {
            heading.setText("Transmission");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        transmissionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Hanyoyin Kamuwa");
        }else {
            heading.setText("Transmission");
        }
    }
}