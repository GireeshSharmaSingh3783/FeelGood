package ca.aceapps.it.feelgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MentalDistortions extends AppCompatActivity {
    Button nxtbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_distortions);

        nxtbt = (Button) findViewById(R.id.nxtBtn02);
        nxtbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MentalDistortions.this, BrightSide.class);
                startActivity(intent);
            }
        });
    }
}