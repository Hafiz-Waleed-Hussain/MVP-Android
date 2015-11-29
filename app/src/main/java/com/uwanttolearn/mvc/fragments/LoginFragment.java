package com.uwanttolearn.mvc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uwanttolearn.mvc.R;
import com.uwanttolearn.mvc.activities.MainActivity;
import com.uwanttolearn.mvc.network.LoginAPI;

/**
 * Created by hafiz on 29/11/2015.
 */
public class LoginFragment extends Fragment {

    private EditText mUsernameEdiText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private LoginAPI mLoginAPI;

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
        mLoginAPI = new LoginAPI();
    }

    private View.OnClickListener mLoginButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String username = mUsernameEdiText.getText().toString();
            if (username.isEmpty()) {
                mUsernameEdiText.setError(getString(R.string.empty_username_error));
                return;
            }

            String password = mPasswordEditText.getText().toString();
            if(password.isEmpty()){
                mPasswordEditText.setError(getString(R.string.empty_password_error));
                return;
            }

            if(mLoginAPI.authenticate(username,password)){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                return;
            }

            Toast.makeText(getContext(), R.string.username_or_password_is_incorrect,Toast.LENGTH_SHORT).show();

        }
    };
}
