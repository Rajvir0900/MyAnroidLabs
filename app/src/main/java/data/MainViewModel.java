package data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> editString = new MutableLiveData<>();
      model.editString.qbserve(owner:this, new Observer<String>(){
        @Override
        public void onChanged(String s){

        }
      });
}
