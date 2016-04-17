/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import com.ocpsoft.pretty.PrettyContext;
import inet.cache.CategoryCache;
import inet.cache.SeoCache;
import inet.cache.management.CacheFactory;
import inet.entities.Category;
import inet.entities.Seo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private String requestUrl;
    
    /**
     * Creates a new instance of MasterPageBean
     */
    public MasterPageController() {
        super();
        PrettyContext context = PrettyContext.getCurrentInstance();
        String viewId = context.getCurrentMapping().getId();
//        try {
//            System.out.println("========viewId "+viewId);
//            Seo seo  = ((SeoCache)CacheFactory.getCache("seo")).get(viewId +".html");
//            if(seo != null){
//                seoTitle = seo.getTitle();
//                seoKeyword = seo.getKeyword();
//                seoDescrption = seo.getDescription();
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(MasterPageController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        categories = ((CategoryCache) CacheFactory.getCache("category")).getAll();
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

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
    
    
}
