package com.study.newbies.addressbook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;

import com.study.newbies.addressbook.entity.Contact;
import com.study.newbies.common.base.BaseActivity;
import com.study.newbies.addressbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * @author NewBies
 * @date 2018/10/13
 */

public class ContactModifyActivity extends BaseActivity {

    @BindView(R.id.name)
    AppCompatEditText name;
    @BindView(R.id.phoneNum)
    AppCompatEditText num;
    @BindView(R.id.avatar)
    TextView avatar;

    private String phoneNum;
    private String contactName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_contact);
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    @Override
    public void initData() {
        phoneNum = getIntent().getStringExtra(Contact.CONTACT_PHONE);
        contactName = getIntent().getStringExtra(Contact.CONTACT_NAME);
    }

    @Override
    public void initView() {
        name.setText(contactName);
        num.setText(phoneNum);
        avatar.setText(String.valueOf(contactName.charAt(0)));
    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
