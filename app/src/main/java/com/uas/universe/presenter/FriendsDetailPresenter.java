package com.uas.universe.presenter;

import android.content.Context;

import com.uas.universe.data.model.Friends;
import com.uas.universe.data.repo.FriendsRepository;
import com.uas.universe.view.FriendsDetailView;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public class FriendsDetailPresenter {

    private FriendsDetailView view;
    private FriendsRepository repo;

    public FriendsDetailPresenter(Context context, FriendsDetailView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void getFriendsDetail(Friends fr) {
        view.showDetail(fr);
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void removeFriend(Friends friend) {
        repo.deleteFriend(friend);
        view.onFriendDeleted();
    }
}
