package com.dalafarm.vendor.model.frontend;

/**
 * Created by LeeU on 9/3/2017.
 */
public class Info {
    private String address;

    private String email;

    private String paymentType;

    private String name;

    private String province;

    private String additionalNote;

    private String verificationCode;

    private String phone2CountryCode;

    private String district;

    private String districtId;

    private String phone1;

    private String phone1CountryCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAdditionalNote() {
        return additionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        this.additionalNote = additionalNote;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPhone2CountryCode() {
        return phone2CountryCode;
    }

    public void setPhone2CountryCode(String phone2CountryCode) {
        this.phone2CountryCode = phone2CountryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone1CountryCode() {
        return phone1CountryCode;
    }

    public void setPhone1CountryCode(String phone1CountryCode) {
        this.phone1CountryCode = phone1CountryCode;
    }

    @Override
    public String toString() {
        return "ClassPojo [address = " + address + ", email = " + email + ", paymentType = " + paymentType + ", name = " + name + ", province = " + province + ", additionalNote = " + additionalNote + ", verificationCode = " + verificationCode + ", phone2CountryCode = " + phone2CountryCode + ", district = " + district + ", phone1 = " + phone1 + ", phone1CountryCode = " + phone1CountryCode + "]";
    }
}
