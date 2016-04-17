/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import inet.cache.CategoryCache;
import inet.cache.management.CacheFactory;
import inet.dao.GameDAO;
import inet.entities.Category;
import inet.entities.Game;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class CategoryController extends BaseController{
    
    private String osType;
    private int catId= 0;
    private String categoryCode ;
    
    private List<Game> games = new ArrayList();
    
    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
        osType = getParameter("os");
        if(osType == null)
            osType = "android";
        try{
            catId = Integer.valueOf(getParameter("catId"));
        }catch(Exception e){}
        System.out.println("====code "+getParameter("code"));
        categoryCode = getParameter("code");
        CategoryCache cache = (CategoryCache)CacheFactory.getCache("category");
        if(cache != null){
            Category category = cache.getByCode(categoryCode);
            if(category != null){
                System.out.println("====osType ="+osType+"|catId = "+category.getId());
                games = GameDAO.getInstance().findByCategory(category.getId(), osType);
            }
        }
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
    
}
