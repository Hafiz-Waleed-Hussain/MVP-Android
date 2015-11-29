package com.uwanttolearn.mvc.login;

import android.support.annotation.StringRes;

/**
 * Created by hafiz on 29/11/2015.
 */
public class LoginContract {

    public interface View{

        String getUsername();

        void setEmptyUsernameErrorMessage(@StringRes int resId);

        String getPassword();

        void setEmptyPasswordErrorMessage(@StringRes int resId);

        void startMainActivity();

        void showUnSuccessfullLoginError();
    }
}
