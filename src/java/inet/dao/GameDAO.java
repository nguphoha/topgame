/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.dao;

import inet.common.database.dao.AbstractDAO;
import inet.common.database.dao.RowMapper;
import inet.constant.Constant;
import inet.entities.Category;
import inet.entities.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TUTL
 */
public class GameDAO extends AbstractDAO {

    public static int ALL = -1;
    public static int INACTIVE = 0;
    public static int ACTIVE = 1;
    
    private static GameDAO _instance = null;
    
    public static GameDAO getInstance(){
        try {
            if(_instance == null)
                _instance = new GameDAO();
            return _instance;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private RowMapper<Game> rowMapper;

    private GameDAO() throws Exception {
        super(Constant.POOL_NAME_DEFAULT);

        rowMapper = new RowMapper<Game>() {
            Game game;

            @Override
            public Game map(ResultSet rs) throws SQLException {
                game = new Game();
                
                game.setId(rs.getString("id"));
                game.setName(rs.getString("name"));
                game.setCode(rs.getString("code"));
                game.setAuthor(rs.getString("author"));
                game.setStatus(rs.getString("status"));
                game.setDateCreate(rs.getTimestamp("date_create"));
                game.setAvatar(rs.getString("avatar"));
                game.setSeoTitle(rs.getString("seo_title"));
                game.setSeoKeyword(rs.getString("seo_keyword"));
                game.setDescription(rs.getString("seo_description"));
                game.setViewCount(rs.getInt("view_count"));
                game.setDownloadCount(rs.getInt("download_count"));
                return game;
            }
        };
    }

    /**
     * Find all game
     * @param status
     * @return 
     */
    public List<Game> find(int status){
        String sql = "Select * from Game ";
        List params = new ArrayList();
        if(status != ALL){
            sql += " where status = ?";
            params.add(status);
        }
        List<Game> games;
        try {
            games = find(sql, params, rowMapper);
            return games.isEmpty() ? null : games;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * find game HOT theo category
     * @param cateId
     * @return 
     */
    public List<Game> findGameHot(int cateId){
        String sql = "SELECT * FROM game WHERE hot = 1";
        List params = new ArrayList();
        
        List<Game> games;
        try {
            games = find(sql, params, rowMapper);
            return games.isEmpty() ? null : games;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public List<Game> findByName(String name){
        String sql = "SELECT * FROM game WHERE upper(game.name) LIKE '%' || upper(?) || '%'";
        List params = new ArrayList();
        params.add(name);
        List<Game> games;
        try {
            games = find(sql, params, rowMapper);
            return games.isEmpty() ? null : games;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
    
    public List<Game> findGameNewest(int cateId){
        String sql = "SELECT * FROM game ORDER BY date_create DESC";
        List params = new ArrayList();
        
        List<Game> games;
        try {
            games = find(sql, params, rowMapper);
            return games.isEmpty() ? null : games;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Game> findGameMostview(int cateId){
        String sql = "SELECT * FROM game ORDER BY view_count DESC";
        List params = new ArrayList();
        
        List<Game> games;
        try {
            games = find(sql, params, rowMapper);
            return games.isEmpty() ? null : games;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Game> findByCategory(int cateId, String cateCode){
        String sql = "SELECT *\n" +
                    "FROM game G\n" +
                    "LEFT JOIN game_category GC ON G.`id` = GC.`game_id`\n" +
                    "LEFT JOIN category C ON GC.`category_id` = C.`id`\n" +
                    "WHERE C.`id` = ? ";
        List params = new ArrayList();
        params.add(cateId);
        List<Game> games;
        try {
            games = find(sql, params, rowMapper);
            return games.isEmpty() ? null : games;
        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
