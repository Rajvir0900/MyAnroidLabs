package ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cst2335.Kaur0900.R;
import com.cst2335.Kaur0900.databinding.ActivityMainBinding;

import data.MainViewModel;

public class MainActivity extends AppCompatActivity {
     private ActivityMainBinding variableBinding;
     private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(owner:this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        variableBinding.mytext.setText(model.editString);
        variableBinding.mybutton.setOnClickListener(click ->
        {
            model.editString = variableBinding.myEditText.getText().toString();
            variableBinding.mytext.setText("Your edit text has:"+model.editString);
        });
        model.editString.observe(this, s -> {
            variableBinding.metext.setText("Your edit text has"+ s );
        });
        model.isSelected.observe( this , selected -> {
            variableBinding.checkBox.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
            variableBinding.switch1.setChecked(selected);
        })



    }

}