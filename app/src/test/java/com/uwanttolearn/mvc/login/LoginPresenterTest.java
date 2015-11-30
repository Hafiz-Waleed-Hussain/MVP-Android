package com.uwanttolearn.mvc.login;

import com.uwanttolearn.mvc.R;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by hafiz on 30/11/2015.
 */
public class LoginPresenterTest {

    private LoginPresenter mLoginPresenter;
    private LoginContract.View mView;
    private LoginAPI mLoginApi;

    @Before
    public void setUp() throws Exception {

        mView = Mockito.mock(LoginContract.View.class);
        mLoginApi = Mockito.mock(LoginAPI.class);

        mLoginPresenter = new LoginPresenter(mView, mLoginApi);

    }


    @Test
    public void whenUsernameIsEmptyShowError() throws Exception {
        Mockito.when(mView.getUsername()).thenReturn("");
        mLoginPresenter.onLoginButtonClick();
        Mockito.verify(mView).showEmptyUsernameErrorMessage(R.string.empty_username_error);
    }

    @Test
    public void whenPasswordIsEmptyShowError() throws Exception {

        Mockito.when(mView.getUsername()).thenReturn("hafiz");
        Mockito.when(mView.getPassword()).thenReturn("");

        mLoginPresenter.onLoginButtonClick();
        Mockito.verify(mView).showEmptyPasswordErrorMessage(R.string.empty_password_error);
    }


    @Test
    public void whenUsernameAndPasswordNotEmptyTestOnServerWithWrongCredentials() throws Exception {

        Mockito.when(mView.getUsername()).thenReturn("hafiz1");
        Mockito.when(mView.getPassword()).thenReturn("123456");

        Mockito.when(mLoginApi.authenticate("hafiz1","123")).thenReturn(false);
        mLoginPresenter.onLoginButtonClick();
        Mockito.verify(mView).showUnsccessfullAuthenticationMessage();
    }

    @Test
    public void whenUsernameAndPasswordNotEmptyTestOnServerWithRightCredentials() throws Exception {

        Mockito.when(mView.getUsername()).thenReturn("hafiz");
        Mockito.when(mView.getPassword()).thenReturn("123456");

        Mockito.when(mLoginApi.authenticate("hafiz","123456")).thenReturn(true);
        mLoginPresenter.onLoginButtonClick();
        Mockito.verify(mView).startMainActivity();

    }
}