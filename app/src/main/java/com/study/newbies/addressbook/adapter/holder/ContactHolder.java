package com.study.newbies.addressbook.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.study.newbies.addressbook.R;
/**
 *
 * @author NewBies
 * @date 2018/10/12
 */

public class ContactHolder extends RecyclerView.ViewHolder{

    public TextView contactName;

    public ContactHolder(View itemView) {
        super(itemView);
        contactName = itemView.findViewById(R.id.contactName);
    }
}
