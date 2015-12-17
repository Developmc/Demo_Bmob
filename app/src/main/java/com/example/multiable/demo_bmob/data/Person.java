package com.example.multiable.demo_bmob.data;

import cn.bmob.v3.BmobObject;

/**用户信息
 * Created by macremote on 2015/12/17.
 */
public class Person extends BmobObject {
    private String name;
    private String address ;
    private String phoneNumber ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
