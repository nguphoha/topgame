/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.dao.impl;

import inet.dao.*;
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
public class CategoryDAOImpl extends Dao {

    private RowMapper<Category> rowMapper;

    public CategoryDAOImpl() throws Exception {
        super(Constant.POOL_NAME_DEFAULT);

        rowMapper = new RowMapper<Category>() {
            Category category;

            @Override
            public Category map(ResultSet rs) throws SQLException {
                category = new Category();
//                seo.setDescription(rs.getString("description"));
//                seo.setKeyword(rs.getString("keyword"));
//                seo.setTitle(rs.getString("title"));
//                seo.setPageDescription(rs.getString("page_description"));
//                seo.setImage(rs.getString("image"));
                return category;
            }
        };
    }

    public Category getByURL(String url) throws Exception {
        String sql = "select * from seo where url = ?";
        List params = new ArrayList();
        params.add(url);
        List<Category> seos = find(sql, params, rowMapper);
        return seos.isEmpty() ? null : seos.get(0);

    }

}
