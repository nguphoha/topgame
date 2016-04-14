/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.entities;

import inet.common.database.annotation.Column;
import inet.common.database.annotation.Table;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
@Table(name = "account_service")
public class AccountService {

    @Column(name = "id", PK = true)
    String id;

    @Column(name = "account_id")
    String accountId;

    @Column(name = "service_id")
    String serviceId;

    @Column(name = "service_code")
    String serviceCode;

    @Column(name = "mobile")
    String mobile;

    @Column(name = "date_create")
    Timestamp dateCreate;

    @Column(name = "date_renew")
    Timestamp dateRenew;

    @Column(name = "date_cancel")
    Timestamp dateCancel;

    @Column(name = "partner")
    String partner;

    @Column(name = "url_register")
    String urlRegister;

    @Column(name = "status")
    String status;

    @Column(name = "properties")
    String properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Timestamp getDateRenew() {
        return dateRenew;
    }

    public void setDateRenew(Timestamp dateRenew) {
        this.dateRenew = dateRenew;
    }

    public Timestamp getDateCancel() {
        return dateCancel;
    }

    public void setDateCancel(Timestamp dateCancel) {
        this.dateCancel = dateCancel;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getUrlRegister() {
        return urlRegister;
    }

    public void setUrlRegister(String urlRegister) {
        this.urlRegister = urlRegister;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

}
