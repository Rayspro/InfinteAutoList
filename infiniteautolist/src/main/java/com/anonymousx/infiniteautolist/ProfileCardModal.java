/*
 *
 *  Created by Ravi Pratap Singh(rayspro143@gmail.com) on 20/5/19 6:32 PM
 *  Copyright (c) 2019 . All right reserved.
 *  Last modified 20/5/19 6:28 PM
 * /
 *
 */

package com.anonymousx.infiniteautolist;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileCardModal implements Serializable {

    private String email;
    private String name;
    private String qualification;
    private Integer userId;
    private String phoneNo;
    private ArrayList<String> coi = null;
    private String profileImage;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ArrayList<String> getCoi() {
        return coi;
    }

    public void setCoi(ArrayList<String> coi) {
        this.coi = coi;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}