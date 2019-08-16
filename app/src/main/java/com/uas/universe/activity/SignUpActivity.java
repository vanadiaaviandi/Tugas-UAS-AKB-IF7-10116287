package com.uas.universe.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.uas.universe.R;
import com.uas.universe.data.model.User;
import com.uas.universe.presenter.SignUpPresenter;
import com.uas.universe.view.SignUpView;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 15-08-2019
 */

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    SignUpPresenter presenter;
    EditText etUsername, etName, etPassword;
    TextView tvFailed;
    Button btnSignUp;

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void signUpFailed() {
        tvFailed.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();

        presenter = new SignUpPresenter(this, this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvFailed = findViewById(R.id.tvFailed);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void signUp() {
        String username = etUsername.getText().toString();
        String name = etName.getText().toString();
        String pass = etPassword.getText().toString();

        User user = new User(username, name, pass);

        if (!username.isEmpty()) {
            if (!name.isEmpty()) {
                if (pass.length() >= 8) {

                    presenter.signUp(user);

                } else presenter.setPassError(etPassword);
            } else presenter.setError(etName);
        } else presenter.setError(etUsername);
    }
}
