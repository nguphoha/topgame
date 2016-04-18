/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.cache;

import inet.cache.management.Cache;
import inet.dao.GameDAO;
import inet.entities.Game;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class GameCache extends Cache{
    private Map<String, Game> datas = new HashMap<String, Game>();
    private Map<String, Integer> countGameCache = new HashMap<String,Integer>();
    
    public int countGameHot(){
        Integer count = countGameCache.get("hot-nhat");
        synchronized(countGameCache){
            if(count == null){
                count = (Integer) GameDAO.getInstance().countGameHot();
                if(count != null){
                    countGameCache.put("hot-nhat", count);
                }else
                    count = 0;
            }
            return count;
        }
    }
    
    @Override
    public void clearCache() {
        synchronized (this) {
            countGameCache.clear();
        }
    }
}
