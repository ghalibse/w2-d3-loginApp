package com.example.fragmentlogin;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements LoginFragment.onLoginListener, FormFragment.onRegisterListener {

    private static final String TAG = "MainActivityTAG_";

     WelcomeFragment welcomeFragment;
     FormFragment formFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeFragment = new WelcomeFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.frm_first, new LoginFragment())
                .add(R.id.frm_second, welcomeFragment)
                .commit();
    }

    @Override
    public void setValues(String v) {

        welcomeFragment.updateInfo(v);
    }

    public void pushEd(boolean b){

        if(b) {
            formFragment = new FormFragment();
            fragmentManager.beginTransaction().remove(welcomeFragment).commit();
            fragmentManager.beginTransaction().add(R.id.frm_second, formFragment).commit();
        }
    }

    @Override
    public void setRegister(String v) {

        welcomeFragment.updateInfo(v);
        fragmentManager.beginTransaction().remove(formFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frm_second, welcomeFragment).commit();
    }
}
