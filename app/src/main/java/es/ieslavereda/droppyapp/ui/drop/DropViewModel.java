package es.ieslavereda.droppyapp.ui.drop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DropViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DropViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is drop fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}