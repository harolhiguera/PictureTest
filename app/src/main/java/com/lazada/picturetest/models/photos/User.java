
package com.lazada.picturetest.models.photos;


public class User {

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String city;
    private String country;
    private int usertype;
    private String fullname;
    private String userpicUrl;
    private String userpicHttpsUrl;
    private String coverUrl;
    private int upgradeStatus;
    private boolean storeOn;
    private int affection;
    private Avatars avatars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserpicUrl() {
        return userpicUrl;
    }

    public void setUserpicUrl(String userpicUrl) {
        this.userpicUrl = userpicUrl;
    }

    public String getUserpicHttpsUrl() {
        return userpicHttpsUrl;
    }

    public void setUserpicHttpsUrl(String userpicHttpsUrl) {
        this.userpicHttpsUrl = userpicHttpsUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(int upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }

    public boolean isStoreOn() {
        return storeOn;
    }

    public void setStoreOn(boolean storeOn) {
        this.storeOn = storeOn;
    }

    public int getAffection() {
        return affection;
    }

    public void setAffection(int affection) {
        this.affection = affection;
    }

    public Avatars getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }

}
