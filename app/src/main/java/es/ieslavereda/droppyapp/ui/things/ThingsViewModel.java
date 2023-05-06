package es.ieslavereda.droppyapp.ui.things;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThingsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ThingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is things fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}