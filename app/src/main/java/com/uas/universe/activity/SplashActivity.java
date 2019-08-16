package com.uas.universe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.uas.universe.R;
import com.uas.universe.data.model.Friends;
import com.uas.universe.data.model.FriendsData;
import com.uas.universe.data.repo.FriendsRepository;
import com.uas.universe.preference.UserPreference;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 15-08-2019
 */

public class SplashActivity extends AppCompatActivity {

    FriendsRepository repo;
    UserPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        repo = new FriendsRepository(this);
        prefs = new UserPreference(this);

        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            Friends friends;
            for (String[] aData : FriendsData.initFriendsData) {
                friends = new Friends(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);
                repo.insertFriend(friends);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }, 2000);
    }
}
