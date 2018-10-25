package com.study.newbies.addressbook.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pipikou.library.AdapterStick;
import com.study.newbies.addressbook.adapter.holder.ContactHolder;
import com.study.newbies.addressbook.adapter.holder.TitleHolder;
import com.study.newbies.addressbook.entity.Contact;
import com.study.newbies.addressbook.R;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author NewBies
 * @date 2018/10/11
 */

public class ContactAdapter extends RecyclerView.Adapter implements AdapterStick{

    private Context context;
    private List<Contact> contacts;
    private OnItemClickListener onItemClickListener;
    private HashMap<Character, Integer> titlePosition = null;

    public void setContacts(List<Contact> contacts){
        this.contacts = contacts;
    }

    public ContactAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
        titlePosition = new HashMap<>();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == Contact.TITLE){
            viewHolder = new TitleHolder(LayoutInflater.from(context).inflate(R.layout.title_item, parent, false));
        }
        else {
            viewHolder = new ContactHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == Contact.TITLE){
            ((TitleHolder)holder).title.setText(contacts.get(position).getTitle());
            titlePosition.put(contacts.get(position).getTitle().charAt(0), position);
        }
        else {
            ((ContactHolder)holder).contactName.setText(contacts.get(position).getContactName());
            ((ContactHolder)holder).contactName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return contacts.get(position).getType();
    }

    /**
     * 请返回实际HeadView数量
     * @return
     */
    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public boolean isPinnedViewType(int viewType) {
        //DO..... 需要吸顶viewType相关逻辑,返回true表示需要吸顶
        return viewType == Contact.TITLE;
    }

    public int getTitleIndex(char titleChar){
        if(!titlePosition.containsKey(titleChar)){
            return -1;
        }
        return this.titlePosition.get(titleChar);
    }
}
