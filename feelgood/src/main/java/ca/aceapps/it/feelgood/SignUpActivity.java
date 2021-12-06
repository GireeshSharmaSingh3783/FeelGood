//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
//////////////////////////////////
package ca.aceapps.it.feelgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private TextView banner;
    private ProgressBar progressBar;


    //Variables
    TextInputLayout editTextFullName, editTextAge, editTextGender, editTextEmail, editTextPassword;

    Button registerUser;

    FirebaseDatabase rootNode;
    DatabaseReference refDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

      //banner = (TextView) findViewById(R.id.Banner);
      //banner.setOnClickListener(this);


        editTextFullName = findViewById(R.id.fullName);
        editTextAge = findViewById(R.id.age);
        editTextGender = findViewById(R.id.gender);
        editTextEmail = findViewById(R.id.emailreg);
        editTextPassword = findViewById(R.id.passreg);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        registerUser = (Button) findViewById(R.id.reguser);
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                refDB = rootNode.getReference("users");

                //Getting values from text fields
                String name = editTextFullName.getEditText().getText().toString().trim();
                String age = editTextAge.getEditText().getText().toString().trim();
                String phoneNumber = editTextGender.getEditText().getText().toString().trim();
                String email = editTextEmail.getEditText().getText().toString().trim();
                String password = editTextPassword.getEditText().getText().toString().trim();


                if (name.isEmpty()) {
                    editTextFullName.setError("Full name is required");
                    editTextFullName.requestFocus();
                    return;
                }

                if (age.isEmpty()) {
                    editTextAge.setError("Age is required");
                    editTextAge.requestFocus();
                    return;
                }

                if (phoneNumber.isEmpty()) {
                    editTextGender.setError("Please provide your gender");
                    editTextGender.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    editTextEmail.setError("Email is required");
                    editTextEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setError("Please provide a valid email address");
                    editTextEmail.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    editTextPassword.setError("Password is required");
                    editTextPassword.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    editTextPassword.setError("Password should be at least 6 characters long");
                    editTextPassword.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    User users = new User(name, age, phoneNumber, email, password);

                                    FirebaseDatabase.getInstance().getReference("users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(SignUpActivity.this, "User has been added", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }else{
                            Toast.makeText(SignUpActivity.this,"Failed to register. Please try again",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                                   // refDB.child(phoneNumber).setValue("users");
                                }
                            }
                        });



            }
        });


    }
}



