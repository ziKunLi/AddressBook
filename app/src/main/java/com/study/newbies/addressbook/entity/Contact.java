package com.study.newbies.addressbook.entity;

/**
 *
 * @author NewBies
 * @date 2018/10/11
 */

public class Contact{

    public final static int TITLE = 0;
    public final static int ITEM = 1;
    public final static String CONTACT_NAME = "contactName";
    public final static String CONTACT_PHONE = "contactPhone";

    private int type;

    private String contactName;

    private String title;

    private String phoneNum;

    public Contact() {
    }

    public Contact(int type, String contactName, String phoneNum,String title) {
        this.type = type;
        this.contactName = contactName;
        this.phoneNum = phoneNum;
        this.title = title;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

}
