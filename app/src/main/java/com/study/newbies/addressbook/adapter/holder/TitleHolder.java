package com.study.newbies.addressbook.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.study.newbies.addressbook.R;

/**
 *
 * @author NewBies
 * @date 2018/10/12
 */

public class TitleHolder extends RecyclerView.ViewHolder{

    public TextView title;

    public TitleHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
    }
}
