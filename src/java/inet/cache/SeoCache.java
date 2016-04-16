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
import inet.dao.SeoDAO;
import inet.dao.SeoDAO;

/**
 *
 * @author TUTL
 */
public class SeoCache extends Cache {

    private Map<String, Seo> datas = new HashMap<String, Seo>();

    public Seo get(String url) throws Exception {

        Seo seo = datas.get(url);
        synchronized (datas) {
            if (seo == null) {
                SeoDAO seoDao = new SeoDAO();
                seo = seoDao.getByURL(url);
                if (seo != null) {
                    datas.put(url, seo);
                }
            }
            return seo;
        }
    }

    @Override
    public void clearCache() {
        synchronized (this) {
            datas.clear();
        }
    }

}
