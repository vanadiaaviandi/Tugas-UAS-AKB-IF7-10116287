package com.uas.universe.view;

import android.widget.EditText;

import com.uas.universe.data.model.Friends;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public interface AddEditFriendsView {
    void showData();

    void onFriendAdded();

    void onFriendUpdated(Friends friend);

    void showError(EditText et);

    void showFailed(String msg);
}
