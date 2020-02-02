package brand.age.com.lassaguide.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.view_models.BackgroundViewModel;

public class ContributorsFragment extends Fragment {

    private BackgroundViewModel backgroundViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        backgroundViewModel =
                ViewModelProviders.of(this).get(BackgroundViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contributors,
                container, false);
        return root;
    }
}
