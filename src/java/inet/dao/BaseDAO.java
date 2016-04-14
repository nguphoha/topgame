/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.dao;

import java.sql.Connection;

/**
 *
 * @author Admin
 */
public interface BaseDAO<T> {
    public <T> int insert(T entity) throws Exception;
    
    public <T> int insert(T entity, Connection connection) throws Exception ;
    
    public <T> int update(T entity) throws Exception;
    
    public <T> int delete(T entity) throws Exception ;
}
