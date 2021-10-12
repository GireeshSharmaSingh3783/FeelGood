package ca.aceapps.it.feelgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView) findViewById(R.id.btn_signup);
        register.setOnClickListener(this);
    }

    public void onClick (View v){
        switch (v.getId()){
            case R.id.btn_signup:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

        }
    }
}