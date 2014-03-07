package org.ipchina.qqbaby;

import org.hibernate.validator.constraints.Length;
import org.ipchina.qqbaby.validation.ValidateLongRange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-24
 * Time: 下午10:31
 */
public class Person {

    @NotNull(message = "用户名不能为空")
//    private String username = "wayaya";
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
//    private String password = "123456";

    @Min(value = 12, message = "年龄不能小于12岁")
    @Max(value = 110, message = "年龄不能大于110岁")
    private int age;

    //    @Min(value = 1)
//    @Max(value = 18)
    @ValidateLongRange(min = 1, max = 18, defaultValue = 13, message = "级别在1到18之间")
//    private Level level=new Level(22);//级别
    private Level level;//级别

    @Value(value = "410007::changsha::laodong road.")
    private Address address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
