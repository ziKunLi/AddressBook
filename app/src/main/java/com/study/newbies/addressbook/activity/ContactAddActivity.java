package com.study.newbies.addressbook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;

import com.study.newbies.addressbook.util.ContactUtil;
import com.study.newbies.common.base.BaseActivity;
import com.study.newbies.addressbook.R;
import com.study.newbies.common.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * @author NewBies
 * @date 2018/10/13
 */

public class ContactAddActivity extends BaseActivity {

    @BindView(R.id.name)
    AppCompatEditText name;
    @BindView(R.id.phoneNum)
    AppCompatEditText phoneNum;

    @OnClick(R.id.cancelAdd)
    public void onCancelAdd(){
        finish();
    }

    @OnClick(R.id.sureAdd)
    public void onSureAdd(){
        final String contactName = name.getText().toString();
        final String contactPhoneNum = phoneNum.getText().toString();
        if(StringUtil.isNull(contactName)){
            showToast("请输入联系人名字");
        }
        else if(StringUtil.isNull(contactPhoneNum)){
            showToast("请输入电话号码");
        }
        else {
            ContactUtil.addContact(this, contactName, contactPhoneNum);
            showToast("添加成功");
            finish();
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_add_contact);
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

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
