/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class LoginController extends BaseController{

    private String username, password;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public void login(){
        System.out.println("==========================");
        System.out.println("log in action");
        System.out.println("==========================");
    }
    
    public void register(){
        System.out.println("==========================");
        System.out.println("register in action");
        System.out.println("==========================");
    }
    
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
    
}
