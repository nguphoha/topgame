/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import inet.dao.GameDAO;
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
public class GameController extends BaseController{
    
    private String gameCode;
    
    private String gameId;
    
    private Game game;
    
    private List<Game> gamesRelative = new ArrayList();
    
    /**
     * Creates a new instance of GameController
     */
    public GameController() {
        super();
        initPage();
    }
    
    private void initPage(){
        gameId = getParameter("id");
        if(gameId == null)
            return;
        
        game = gameCache.findById(Integer.valueOf(gameId));
        if(game == null)
            return;
        gamesRelative = gameCache.findByCategory(Integer.valueOf(game.getCategoryId()), "", getCurentPage(), getPageSize());
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Game> getGamesRelative() {
        return gamesRelative;
    }

    public void setGamesRelative(List<Game> gamesRelative) {
        this.gamesRelative = gamesRelative;
    }
    
    
}
