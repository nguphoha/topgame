/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.dao;

import inet.common.database.dao.Dao;
import inet.common.database.dao.RowMapper;
import inet.constant.Constant;
import inet.entities.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUTL
 */
public interface CategoryDAO{

    public Category getByURL(String url) throws Exception;

}
