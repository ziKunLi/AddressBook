package com.study.newbies.addressbook.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;

import com.pipikou.library.PinnedHeaderItemDecoration;
import com.study.newbies.addressbook.R;
import com.study.newbies.addressbook.adapter.ContactAdapter;
import com.study.newbies.addressbook.adapter.OnItemClickListener;
import com.study.newbies.addressbook.datadeal.ContactSort;
import com.study.newbies.addressbook.entity.Contact;
import com.study.newbies.addressbook.util.ContactUtil;
import com.study.newbies.addressbook.util.LogUtil;
import com.study.newbies.addressbook.util.PermissionUtil;
import com.study.newbies.common.base.BaseActivity;
import com.study.newbies.common.view.WaveSideBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.topSearchView)
    SearchView topSearchView;
    @BindView(R.id.rvContact)
    RecyclerView rvContact;
    @BindView(R.id.wsvIndex)
    WaveSideBarView wsvIndex;
    private ContactAdapter adapter = null;
    private List<Contact> contacts = null;
    private LinearLayoutManager linearLayoutManager = null;
    private Bundle bundle = null;

    @OnClick(R.id.addContact)
    public void onAddContactClick(){
        startActivity(ContactAddActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adapter != null){
            contacts = ContactSort.sort(ContactUtil.readContacts(this));
            adapter.setContacts(contacts);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initData() {
        contacts = new ArrayList<>();
        //动态获取读取联系人权限
        PermissionUtil.getReadContactsPermission(this, 1);
        PermissionUtil.getCallPhonePermission(this, 1);
        contacts = ContactSort.sort(ContactUtil.readContacts(this));
        bundle = new Bundle();
    }

    @Override
    public void initView() {
        adapter = new ContactAdapter(this, contacts);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                bundle.putString(Contact.CONTACT_NAME, contacts.get(position).getContactName());
                bundle.putString(Contact.CONTACT_PHONE, contacts.get(position).getPhoneNum());
                startActivity(InfoActivity.class, bundle);
                LogUtil.v("position : " + String.valueOf(position));
            }
        });
        rvContact.addItemDecoration(PinnedHeaderItemDecoration.builder().adapterProvider(adapter).build());
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvContact.addItemDecoration(dividerItemDecoration);
        linearLayoutManager = new LinearLayoutManager(this);
        rvContact.setLayoutManager(linearLayoutManager);
        rvContact.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        wsvIndex.setOnTouchLetterChangeListener(new WaveSideBarView.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                int position = adapter.getTitleIndex(letter.charAt(0));
                if(position != -1){
                    linearLayoutManager.scrollToPositionWithOffset(position, 0);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
