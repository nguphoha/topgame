/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import inet.cache.CategoryCache;
import inet.cache.management.CacheFactory;
import inet.entities.Category;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class MasterPageController extends BaseController {

    private String seoTitle;
    private String seoDescrption;
    private String seoKeyword;
    
    private List<Category> categories;
    
    /**
     * Creates a new instance of MasterPageBean
     */
    public MasterPageController() {
        super();
        categories = ((CategoryCache) CacheFactory.getCache("category")).getAll();
        for(Category cat : categories){
            System.out.println("============"+cat);
        }
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescrption() {
        return seoDescrption;
    }

    public void setSeoDescrption(String seoDescrption) {
        this.seoDescrption = seoDescrption;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
