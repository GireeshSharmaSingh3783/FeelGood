//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import ca.aceapps.it.feelgood.R;


public class ReviewScreen extends AppCompatActivity {
    private TextView txtRating;
    private RatingBar rbRating;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_screen);



        init();

        rbRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratingValue, boolean b){
                String rating = "Selected Rating - " + ratingValue;
                txtRating.setText(rating);
            }
        });

    }

    private void init(){
        txtRating = findViewById(R.id.TextView4);
        rbRating = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.button);
    }
}