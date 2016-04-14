/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.dao;

import inet.entities.Seo;

/**
 *
 * @author TUTL
 */
public interface SeoDAO{
    
    public Seo getByURL(String url) throws Exception ;

}
