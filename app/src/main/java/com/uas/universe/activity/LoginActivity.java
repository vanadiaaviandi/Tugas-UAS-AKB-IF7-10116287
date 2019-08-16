package com.uas.universe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.uas.universe.R;
import com.uas.universe.presenter.LoginPresenter;
import com.uas.universe.view.LoginView;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 15-08-2019
 */

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    LoginPresenter presenter;
    EditText etUsername, etPassword;
    TextView tvWrong;
    Button btnLogin, btnSignUp;

    @Override
    public void loginSuccess() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void loginFail() {
        tvWrong.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        presenter = new LoginPresenter(this, this);
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) login();
        else if (v.getId() == R.id.btnSignUp) {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvWrong = findViewById(R.id.tvWrong);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void login() {
        if (!etUsername.getText().toString().isEmpty()) {
            if (!etPassword.getText().toString().isEmpty()) {

                presenter.login(this, etUsername.getText().toString(), etPassword.getText().toString());

            } else presenter.setError(etPassword);
        } else presenter.setError(etUsername);
    }
}
