package brand.age.com.lassaguide.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class DashboardFragment extends Fragment {

    SharedPreferenceManager sharedPreferenceManager;
    private TextView r, s, p, f, t, c;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard,
                container, false);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(getContext());
        LinearLayout report, symptoms, precautions, firstaid, transmission, contributors;

        r = root.findViewById(R.id.dash_text_report);
        s = root.findViewById(R.id.dash_text_symptoms);
        p = root.findViewById(R.id.dash_text_precaution);
        f = root.findViewById(R.id.dash_text_first_aid);
        t = root.findViewById(R.id.dash_text_transmission);
        c = root.findViewById(R.id.dash_text_contributors);

        contributors = root.findViewById(R.id.dash_contributors);
        report = root.findViewById(R.id.dash_report);
        symptoms = root.findViewById(R.id.dash_symptoms);
        precautions = root.findViewById(R.id.dash_precaution);
        firstaid = root.findViewById(R.id.dash_first_aid);
        transmission = root.findViewById(R.id.dash_transmission);

        if (sharedPreferenceManager.get_language().equals("HA")){
            r.setText("Rahoto");
            p.setText("Hanyoyin\nKariya");
            s.setText("Alamun\nciwo");
            f.setText("Taimakon\ngaggawa");
            t.setText("Hanyoyin\nKamuwa");
            c.setText("Masu\nGudunmawa");
        }else {
            r.setText("Report");
            p.setText("Preventive measures");
            s.setText("Symptoms");
            f.setText("First Aid");
            t.setText("Transmission");
            c.setText("Contributors");
        }

        contributors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContributorsFragment contributorsFragment = new ContributorsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, contributorsFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        transmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransmissionFragment transmissionFragment = new TransmissionFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, transmissionFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallsFragment callsFragment = new CallsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, callsFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstAidFragment firstAidFragment = new FirstAidFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, firstAidFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SymptomsFragment symptomsFragment = new SymptomsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, symptomsFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        precautions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecautionsFragment precautionsFragment = new PrecautionsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, precautionsFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (sharedPreferenceManager.get_language().equals("HA")){
            r.setText("Rahoto");
            p.setText("Hanyoyin\nKariya");
            s.setText("Alamun\nCiwo");
            f.setText("Taimakon\ngaggawa");
            t.setText("Hanyoyin\nKamuwa");
            c.setText("Masu\nGudunmawa");
        }else {
            r.setText("Report");
            p.setText("Preventive measures");
            s.setText("Symptoms");
            f.setText("First Aid");
            t.setText("Transmission");
            c.setText("Contributors");
        }
    }
}
