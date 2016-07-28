package com.example.fragmentlogin;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragmentTAG_";

    private Button loginButton, signUpButton ;
    private EditText userEditxt, passEditxt;
    private String usrName, pass;

    static onLoginListener onLoginListener;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userEditxt = (EditText) view.findViewById(R.id.txt_user);
        passEditxt = (EditText) view.findViewById(R.id.txt_pass);

        loginButton = (Button) view.findViewById(R.id.btn_login);
        signUpButton = (Button) view.findViewById(R.id.btn_register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = userEditxt.getText().toString();
                String pas = passEditxt.getText().toString();
                com.example.fragmentlogin.LoginFragment.onLoginListener.setValues(usr +" "+pas);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                com.example.fragmentlogin.LoginFragment.onLoginListener.pushEd(true);
            }
        });
    }

    public interface onLoginListener{
        public void setValues(String v);

        public void pushEd(boolean b);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onLoginListener = (onLoginListener) context;
        } catch (Exception e){}

    }
}
