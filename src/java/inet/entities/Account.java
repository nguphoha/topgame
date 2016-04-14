/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.entities;

import inet.common.database.annotation.Column;
import inet.common.database.annotation.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
@Table(name = "account")
public class Account {

    @Column(name = "id", PK = true)
    String id;

    @Column(name = "mobile")
    String mobile;

    @Column(name = "password")
    String password;

    @Column(name = "status")
    String status;

    @Column(name = "date_create")
    Timestamp dateCreate;

    @Column(name = "key")
    String key;

    List<AccountService> services;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<AccountService> getServices() {
        return services;
    }

    public void setServices(List<AccountService> services) {
        this.services = services;
    }

}
