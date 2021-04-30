package com.xfactor.lably.entity;

public class Lab{
    private String name;
    private String address;
    private String phone;
    private String pincode;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setPincode(String pincode)
    {
        this.pincode = pincode;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getPincode()
    {
        return pincode;
    }
    
}