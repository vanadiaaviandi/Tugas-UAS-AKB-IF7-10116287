package com.uas.universe.presenter;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.uas.universe.activity.LoginActivity;
import com.uas.universe.data.model.User;
import com.uas.universe.data.repo.UserRepository;
import com.uas.universe.preference.UserPreference;
import com.uas.universe.view.LoginView;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public class LoginPresenter {

    private LoginView view;
    private UserRepository repo;
    private UserPreference prefs;

    public LoginPresenter(Context context, LoginView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }

    public void login(LoginActivity owner, final String username, final String pass) {
        repo.selectUser(username, pass).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    prefs.setIsLogin(username, pass);
                    view.loginSuccess();
                } else view.loginFail();
            }
        });
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Please fill this box !");
    }

}
