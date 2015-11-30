package com.uwanttolearn.mvc.login;

import android.support.annotation.StringRes;

/**
 * Created by hafiz on 30/11/2015.
 */
public class LoginContract {

    public interface View{

        String getUsername();

        void showEmptyUsernameErrorMessage(@StringRes  int resId);

        String getPassword();

        void showEmptyPasswordErrorMessage(@StringRes  int resId);

        void showUnsccessfullAuthenticationMessage();

        void startMainActivity();
    }
}
