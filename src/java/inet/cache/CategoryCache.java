/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.cache;

import inet.cache.management.Cache;
import inet.entities.Seo;
import java.util.HashMap;
import java.util.Map;
import inet.dao.CategoryDAO;
import inet.entities.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUTL
 */
public class CategoryCache extends Cache {

    private Map<String, Category> datas = new HashMap<String, Category>();
    //private Map<String,List<Category>> cacheCategories = new HashMap<String, List<Category>>();
    private List<Category> categories = new ArrayList();
    
    
    public Category get(String url) throws Exception {
        Category seo = datas.get(url);
        synchronized (datas) {
            if (seo == null) {
                seo = CategoryDAO.getInstance().getByURL(url);
                if (seo != null) {
                    datas.put(url, seo);
                }
            }
            return seo;
        }
    }

    public List<Category> getAll() {
        synchronized(categories){
            if(categories.isEmpty()){
                categories = CategoryDAO.getInstance().find(Category.ACTIVE);
            }
        }
        return categories;
    }
    
    @Override
    public void clearCache() {
        synchronized (this) {
            datas.clear();
        }
    }

}
