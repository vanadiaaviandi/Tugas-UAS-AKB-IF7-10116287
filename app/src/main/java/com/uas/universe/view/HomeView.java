package com.uas.universe.view;

import com.uas.universe.data.model.User;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public interface HomeView {
    void showUser(User user);

    void onSignOut();
}
