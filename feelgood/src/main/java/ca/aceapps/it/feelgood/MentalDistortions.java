//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;

public class MentalDistortions extends AppCompatActivity {
    Button nxtbt, learnMore;
    CheckBox aOn, filter, label, disPo, ovrGen, caT, mindRe, forTel, bNw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_distortions);

        nxtbt = (Button) findViewById(R.id.nxtBtn02);
        nxtbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getApplicationContext(), Reflection.class));
            }
        });

        learnMore = (Button) findViewById(R.id.learnmore);
        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/cognitive-distortions#how-to-change"));
                startActivity(intent);

            }
        });



    }
}