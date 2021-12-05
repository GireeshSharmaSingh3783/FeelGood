//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood.ui.draw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import ca.aceapps.it.feelgood.R;


public class ReviewScreen extends ViewModel {

    private MutableLiveData<String> mText;

    public ReviewScreen() {
        mText = new MutableLiveData<>();
        mText.setValue("What are you feeling today?");
    }


    public LiveData<String> getText() {
        return mText;
    }
}