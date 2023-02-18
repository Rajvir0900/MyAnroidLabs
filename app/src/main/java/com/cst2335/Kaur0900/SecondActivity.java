package com.cst2335.Kaur0900;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button callButton = findViewById(R.id.button);
        TextView topText = findViewById(R.id.textView);
        ImageView picture = findViewById(R.id.imageView);
        Button picturebutton = findViewById(R.id.button2);

        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");

        topText.setText("welcome back" + emailAddress);

        File file = new File(getFilesDir(), "Picture.png");

        if (file.exists()) {
            Bitmap theImage = BitmapFactory.decodeFile(file.getAbsolutePath());
            picture.setImageBitmap(theImage);
        }



   callButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent call = new Intent(Intent.ACTION_DIAL);
           EditText number=findViewById(R.id.editTextPhone);
           String phoneNumber=number.getText().toString();

           call.setData(Uri.parse("tel:" + phoneNumber));
           startActivity(call);
       }

       });



        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {

                            Intent data = result.getData();
                            Bitmap thumbnail = data.getParcelableExtra("data");

                            picture.setImageBitmap(thumbnail);
                        }else if (result.getResultCode()==Activity.RESULT_CANCELED);


                    }

                });



    picturebutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraResult.launch(cameraIntent);

        }


    });





        callButton = findViewById(R.id.button);
        EditText editTextPhone = findViewById(R.id.editTextPhone);

        SharedPreferences prefs = getSharedPreferences("MyPhoneData", Context.MODE_PRIVATE);
        String phoneNumber = prefs.getString("PhoneNumber", "");
        editTextPhone.setText(phoneNumber);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Save the phone number that is currently entered in the EditText
        EditText phoneNumber = (EditText) findViewById(R.id.editTextPhone);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPhoneData", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString("PhoneNumber" , phoneNumber.getText().toString());
        ed.apply();
    }




}



