package com.uas.universe.presenter;

import android.content.Context;
import android.widget.EditText;

import com.uas.universe.data.model.User;
import com.uas.universe.data.repo.UserRepository;
import com.uas.universe.view.SignUpView;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public class SignUpPresenter {

    private SignUpView view;
    private UserRepository repo;

    public SignUpPresenter(Context context, SignUpView view) {
        this.view = view;
        repo = new UserRepository(context);
    }

    public void signUp(User user) {
        try {
            repo.insertUser(user);
            view.signUpSuccess();
        } catch (Exception ex) {
            view.signUpFailed();
        }
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Please fill this box !");
    }

    public void setPassError(EditText editText) {
        editText.requestFocus();
        editText.setError("Password length minimal 8 character !");
    }
}
