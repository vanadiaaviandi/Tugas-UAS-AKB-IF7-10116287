package com.uas.universe.presenter;

import com.uas.universe.view.AboutView;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

public class AboutPresenter {

    private AboutView view;

    public AboutPresenter(AboutView view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showApp();
        } else {
            view.showCreator();
        }
    }
}
