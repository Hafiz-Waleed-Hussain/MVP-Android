package com.uwanttolearn.mvc.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uwanttolearn.mvc.R;
import com.uwanttolearn.mvc.home.MainActivity;

/**
 * Created by hafiz on 29/11/2015.
 */
public class LoginFragment extends Fragment implements LoginContract.View{

    private EditText mUsernameEdiText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private LoginPresenter mLoginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mUsernameEdiText = (EditText) view.findViewById(R.id.FragmentLogin_username_edittext);
        mPasswordEditText = (EditText) view.findViewById(R.id.FragmentLogin_password_edittext);
        mLoginButton = (Button) view.findViewById(R.id.FragmentLogin_login_button);
        mLoginButton.setOnClickListener(mLoginButtonClickListener);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoginPresenter = new LoginPresenter(this, new LoginAPI());
    }

    private View.OnClickListener mLoginButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLoginPresenter.onLoginButtonClick();
        }
    };


    @Override
    public String getUsername() {
        return mUsernameEdiText.getText().toString();
    }

    @Override
    public void setEmptyUsernameErrorMessage(@StringRes int resId) {
        mUsernameEdiText.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return mPasswordEditText.getText().toString();
    }

    @Override
    public void setEmptyPasswordErrorMessage(int resId) {
        mPasswordEditText.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showUnSuccessfullLoginError() {
        Toast.makeText(getContext(), R.string.username_or_password_is_incorrect,Toast.LENGTH_SHORT).show();
    }
}
