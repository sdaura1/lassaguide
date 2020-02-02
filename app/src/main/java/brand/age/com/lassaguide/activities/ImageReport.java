package brand.age.com.lassaguide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import brand.age.com.lassaguide.R;
import brand.age.com.lassaguide.utils.Is_Network;

public class ImageReport extends AppCompatActivity {

    byte[] bytes = null;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    LinearLayout image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_report);

        image = findViewById(R.id.dash_image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePictureIntent();
            }
        });

    }

    private void takePictureIntent() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
        }else {
            Intent mIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (mIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(mIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            bytes = outputStream.toByteArray();

            if (new Is_Network().isOnline(this)) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");
                share.putExtra(Intent.EXTRA_STREAM, bytes);
                startActivity(Intent.createChooser(share,"Share via"));
            }else {
                Toast.makeText(this, "Connect to a network", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
