//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.SignInButton;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;


import android.content.SharedPreferences;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.GoogleAuthProvider;

import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.common.api.GoogleApiClient;


import com.google.android.gms.common.api.ApiException;




import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.aceapps.it.feelgood.databinding.FragmentHomeBinding;


public class LoginActivity extends AppCompatActivity  {



    EditText mEmail, mPassword;
    Button btSignup, btLogin;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.ed_username);
        mPassword = findViewById(R.id.ed_password);

        fAuth = FirebaseAuth.getInstance();

        btLogin = findViewById(R.id.btn_login);
        btSignup = findViewById(R.id.btn_signup);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mEmail.setError("Please provide a valid email address");
                    mEmail.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    mPassword.setError("Password is required");
                    mPassword.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password should be at least 6 characters long");
                    mPassword.requestFocus();
                    return;
                }

                //Authenticate User

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent (getApplicationContext(), MainActivity.class));
                            }else {
                                Toast.makeText(LoginActivity.this, "invalid login: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                    }
                });

            }
        });

        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getApplicationContext(), SignUpActivity.class));

            }
        });
    }
}