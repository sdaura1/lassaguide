package brand.age.com.lassaguide.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.models.CallModel;
import brand.age.com.lassaguide.utils.SharedPreferenceManager;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.viewHolder> {

    private static final String TAG = "Call Adapter";
    private Context context;
    private List<CallModel> callModels;
    private Activity activity;
    SharedPreferenceManager sharedPreferenceManager;

    public CallAdapter(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        this.sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
        this.callModels = new ArrayList<>();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_calls_item, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder,
                                 final int position) {
        holder.bind(callModels.get(position));
    }

    @Override
    public int getItemCount() {
        return callModels.size();
    }

    public void setItem(List<CallModel> callModels){
        if (this.callModels != null){
            this.callModels = callModels;
            notifyDataSetChanged();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        final View v;
        TextView model_call_name, model_call_number;
        FloatingActionButton call, msg;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            v = itemView;
            model_call_name= v.findViewById(R.id.call_name);
            model_call_number= v.findViewById(R.id.call_number);
            call = v.findViewById(R.id.call_button);
            msg = v.findViewById(R.id.msg_button);
        }

        void bind(final CallModel callModel){
            if (callModel != null){
                model_call_name.setText(callModel.getName());
                model_call_number.setText(callModel.getNumber());
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String number = model_call_number.getText().toString().trim();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:+234" + number.substring(1)));

                        if (ActivityCompat.checkSelfPermission(context,
                                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(activity,
                                    new String[] {Manifest.permission.CALL_PHONE}, 1);
                        }else {
                            context.startActivity(callIntent);
                        }
                    }
                });
                msg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String number = model_call_number.getText().toString().trim();
                        String message = "";
                        if (sharedPreferenceManager.get_language().equals("EN")){
                            message = "Clear and write your report";
                        }else {
                            message = "Gogo ka rubuta rahoton ka";
                        }
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number.substring(1)));
                        intent.putExtra("sms_body", message);
                        context.startActivity(intent);
                    }
                });
            }
        }
    }
}
