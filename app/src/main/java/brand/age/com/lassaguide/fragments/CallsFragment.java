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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.adapters.CallAdapter;
import brand.age.com.lassaguide.models.CallModel;
import brand.age.com.lassaguide.view_models.CallsViewModel;

public class CallsFragment extends Fragment {

    private CallsViewModel callsViewModel;
    RecyclerView recyclerView;
    CallAdapter callAdapter;
    LinearLayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        callsViewModel =
                ViewModelProviders.of(this).get(CallsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calls, container, false);
        recyclerView = root.findViewById(R.id.calls_recycler);
        callAdapter = new CallAdapter(getContext(), getActivity());
        callsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<List<CallModel>>() {
            @Override
            public void onChanged(List<CallModel> callModels) {
                if (callModels != null) {
                    callAdapter.setItem(callModels);
                }
            }
        });
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(callAdapter);
        return root;
    }
}