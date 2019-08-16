package com.uas.universe.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uas.universe.data.model.User;

/*  NIM                 : 10116287
    NAMA                : Vanadia Aviandi
    KELAS               : IF - 7 / AKB - 7
    Tanggal Pengerjaan  : 16-08-2019
 */

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addUser(User... users);

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    LiveData<User> login(String username, String password);
}
