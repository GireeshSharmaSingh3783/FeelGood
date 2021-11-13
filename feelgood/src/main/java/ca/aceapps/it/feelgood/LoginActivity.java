//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
// Brett Kean N01158642
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.SignInButton;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient;

import android.content.SharedPreferences;

import com.google.firebase.auth.GoogleAuthProvider;

import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.common.api.GoogleApiClient;



//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;
    SignInButton google_signIn;
    //GoogleSignInClient googleSignInClient;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        savelogincheckbox = (CheckBox)findViewById(R.id.checkBox);
        editor=sharedPreferences.edit();
        google_signIn = findViewById(R.id.google_signIn);


        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        //googleSignInClient = GoogleSignIn.getClient(this, gso);

//       // google_signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                Intent signInIntent = googleSignInClient.getSignInIntent();
              //  startActivityForResult(signInIntent, RC_SIGN_IN);
            //}
     //   });


//        savelogin=sharedPreferences.getBoolean("savelogin",false);
//        if(savelogin==true){
//            savelogincheckbox.setChecked(true);
//            emailET.setText(sharedPreferences.getString("email",null));
//            passwordET.setText(sharedPreferences.getString("password",null));
//        }

        register = (TextView) findViewById(R.id.btn_signup);
        register.setOnClickListener(this);



        signIn = (Button) findViewById(R.id.btn_login);
        signIn.setOnClickListener(this);





        editTextEmail = (EditText) findViewById(R.id.ed_username);
        editTextPassword = (EditText) findViewById(R.id.ed_password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

    }



@Override
    public void onClick (View v){
        switch (v.getId()){
            case R.id.btn_signup:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.btn_login:
                userLogin();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
                

        }
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextPassword.setError("Password should be at least 6 characters long");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.GONE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    //to user profile
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,"Failed to login. PLease check credentials and try again",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void handleRemeberMe(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(savelogincheckbox.isChecked()){
            editor.putBoolean("savelogin",true);
            editor.putString("email",email);
            editor.putString("password",password);
            editor.commit();

        }else{
            editor.remove("savelogin");
            editor.remove("email");
            editor.remove("password");
            editor.commit();
        }

    }


}