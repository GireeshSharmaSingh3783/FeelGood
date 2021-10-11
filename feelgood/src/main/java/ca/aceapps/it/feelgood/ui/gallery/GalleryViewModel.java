//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
// Brett Kean N01158642
//Eghe Iyobosa N01107171
package ca.aceapps.it.feelgood.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("What are you feeling today?");
    }

    public LiveData<String> getText() {
        return mText;
    }
}