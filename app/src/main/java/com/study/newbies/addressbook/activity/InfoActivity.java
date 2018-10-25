package com.study.newbies.addressbook.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.study.newbies.addressbook.R;
import com.study.newbies.addressbook.entity.Contact;
import com.study.newbies.addressbook.util.ContactUtil;
import com.study.newbies.addressbook.util.PermissionUtil;
import com.study.newbies.common.base.BaseActivity;
import com.study.newbies.common.util.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * @author NewBies
 * @date 2018/10/13
 */

public class InfoActivity extends BaseActivity {

    @BindView(R.id.phoneNum)
    TextView phone;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.avatar)
    TextView avatar;
    private String contactName;
    private String phoneNum;
    private Bundle bundle = null;

    @SuppressLint("MissingPermission")
    @OnClick(R.id.call)
    public void onCallClick() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

    @OnClick(R.id.delete)
    public void onDeleteClick(){
        ContactUtil.delete(this, contactName);
        showToast("删除成功");
        finish();
    }

    @OnClick(R.id.modify)
    public void onModifyClick(){
        startActivity(ContactModifyActivity.class, bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_contact_info);
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    @Override
    public void initData() {
        bundle = new Bundle();
        phoneNum = getIntent().getStringExtra(Contact.CONTACT_PHONE);
        contactName = getIntent().getStringExtra(Contact.CONTACT_NAME);
        bundle.putString(Contact.CONTACT_PHONE, phoneNum);
        bundle.putString(Contact.CONTACT_NAME, contactName);
    }

    @Override
    public void initView() {
        phone.setText(phoneNum);
        name.setText(contactName);
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
