package org.ipchina.qqbaby;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-30
 * Time: 上午12:59
 */
public class Address {
    private String zip;         // 邮编
    private String city;        // 城市
    private String street;      // 街道


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
