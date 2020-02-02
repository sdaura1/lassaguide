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

import java.util.logging.SocketHandler;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;
import brand.age.com.lassaguide.view_models.FirstAidViewModel;

public class FirstAidFragment extends Fragment {

    private FirstAidViewModel firstAidViewModel;
    SharedPreferenceManager sharedPreferenceManager;
    private TextView textView;
    private TextView heading;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        firstAidViewModel =
                ViewModelProviders.of(this).get(FirstAidViewModel.class);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(getContext());
        View root = inflater.inflate(R.layout.fragment_first_aid, container, false);
        textView = root.findViewById(R.id.text_first_aid);
        heading = root.findViewById(R.id.first_aid_heading);
        firstAidViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Taimakon gaggawa");
        }else {
            heading.setText("First Aid");
        }
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        firstAidViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Taimakon gaggawa");
        }else {
            heading.setText("First Aid");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        firstAidViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (sharedPreferenceManager.get_language().equals("HA")){
            heading.setText("Taimakon gaggawa");
        }else {
            heading.setText("First Aid");
        }
    }
}