package com.weipai;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.*;

public class WeipaiTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {

    private String TAG = WeipaiTabActivity.class.getName();
    private RadioButton [] mRadioButtons;
    private TabHost mTabHost;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintabs);

        mTabHost = getTabHost();
        mTabHost.addTab(mTabHost.newTabSpec("updates_tab").setIndicator("Updates").setContent(new Intent(this, BrowseActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("friends_tab").setIndicator("Friends").setContent(new Intent(this, FriendActivity.class)));
//        mTabHost.addTab(mTabHost.newTabSpec("recording_tab").setIndicator("Recording").setContent(new Intent(this, RecordingActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("setting_tab").setIndicator("Setting").setContent(new Intent(this, SettingActivity.class)));
        initRadios();
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d(TAG, "button:" + buttonView.getText().toString() + " isChecked:" + isChecked);

        if(isChecked){
            if(buttonView == mRadioButtons[0]){
                mTabHost.setCurrentTabByTag("updates_tab");
            }else if(buttonView == mRadioButtons[1]){
                mTabHost.setCurrentTabByTag("friends_tab");
            }else if(buttonView == mRadioButtons[2]){
//                mTabHost.setCurrentTabByTag("recording_tab");
                startActivity(new Intent(this, RecordingActivity.class));
            }else if(buttonView == mRadioButtons[4]){
                mTabHost.setCurrentTabByTag("setting_tab");
            }
        }
    }

    private void initRadios() {
        RadioGroup localRadioGroup = (RadioGroup) findViewById(R.id.main_radio);
        RadioButton[] arrayOfRadioButton1 = new RadioButton[5];
        this.mRadioButtons = arrayOfRadioButton1;

        for (int i = 0; i < arrayOfRadioButton1.length; i++) {
            RadioButton radioButton = (RadioButton)localRadioGroup.findViewWithTag("radio_button" + i);
            radioButton.setOnCheckedChangeListener(this);
            mRadioButtons[i] = radioButton;
        }

    }
}