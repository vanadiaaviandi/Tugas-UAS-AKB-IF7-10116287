package com.uas.universe.view;

import com.uas.universe.data.model.Friends;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public interface FriendsDetailView {
    void showDetail(Friends fr);

    void actionCall();

    void actionEmail();

    void actionInstagram();

    void onFriendDeleted();
}
