package com.uwanttolearn.mvc.login;

import com.uwanttolearn.mvc.R;

/**
 * Created by hafiz on 30/11/2015.
 */
public class LoginPresenter {

    private final LoginContract.View view;
    private final LoginAPI mLoginAPI;

    public LoginPresenter(LoginContract.View view, LoginAPI mLoginAPI) {

        this.view = view;
        this.mLoginAPI = mLoginAPI;
    }

    public void onLoginButtonClick() {

        String username = view.getUsername();
        if(username.isEmpty()){
            view.showEmptyUsernameErrorMessage(R.string.empty_username_error);
            return;
        }

        String password = view.getPassword();
        if(password.isEmpty()){
            view.showEmptyPasswordErrorMessage(R.string.empty_password_error);
            return;
        }

        if(mLoginAPI.authenticate(username,password)){
            view.startMainActivity();
            return;
        }

        view.showUnsccessfullAuthenticationMessage();

    }
}
