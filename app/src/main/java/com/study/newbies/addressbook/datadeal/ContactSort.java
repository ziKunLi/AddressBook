package com.study.newbies.addressbook.datadeal;

import com.study.newbies.addressbook.entity.Contact;
import com.study.newbies.addressbook.util.ChineseUtil;
import com.study.newbies.addressbook.util.ContactUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author NewBies
 * @date 2018/10/12
 */

public class ContactSort {

    public static ArrayList<Contact> sort(ArrayList<ContactUtil.ContactBean> contactBeans){
        ArrayList<Contact> contacts = new ArrayList<>();
        Collections.sort(contactBeans, new ChineseSortComparator());
        final int size = contactBeans.size();
        char currentChar = ' ';
        for(int i = 0; i < size; i++){
            char tempChar = ChineseUtil.getChineseFirstChar(contactBeans.get(i).getName().charAt(0));
            if(tempChar != currentChar){
                contacts.add(new Contact(Contact.TITLE, "","", String.valueOf(tempChar).toUpperCase()));
                currentChar = tempChar;
            }
            contacts.add(new Contact(Contact.ITEM, contactBeans.get(i).getName(),contactBeans.get(i).getPhoneNum(), ""));
        }
        return contacts;
    }

    static class ChineseSortComparator implements Comparator<ContactUtil.ContactBean>{

        @Override
        public int compare(ContactUtil.ContactBean o1, ContactUtil.ContactBean o2) {
            char o1Char = ChineseUtil.getChineseFirstChar(o1.getName().charAt(0));
            char o2Char = ChineseUtil.getChineseFirstChar(o2.getName().charAt(0));
            if(Character.isLetter(o1Char)&&!Character.isLetter(o2Char)){
                return -1;
            }
            else if(!Character.isLetter(o1Char)&&Character.isLetter(o2Char)){
                return 1;
            }
            else {
                if(o1Char > o2Char){
                    return 1;
                }
                else if(o1Char < o2Char){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}
