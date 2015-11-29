package com.uwanttolearn.mvc.login;

import com.uwanttolearn.mvc.R;

/**
 * Created by hafiz on 29/11/2015.
 */
public class LoginPresenter {

    private final LoginContract.View view;
    private final LoginAPI loginAPI;

    public LoginPresenter(LoginContract.View view, LoginAPI loginAPI) {

        this.view = view;
        this.loginAPI = loginAPI;
    }

    public void onLoginButtonClick() {

        String username = view.getUsername();
        if (username.isEmpty()) {
            view.setEmptyUsernameErrorMessage(R.string.empty_username_error);
            return;
        }

        String password = view.getPassword();
        if (password.isEmpty()) {
            view.setEmptyPasswordErrorMessage(R.string.empty_password_error);
            return;
        }

        if(loginAPI.authenticate(username,password)){
            view.startMainActivity();
            return;
        }

        view.showUnSuccessfullLoginError();

    }
}
