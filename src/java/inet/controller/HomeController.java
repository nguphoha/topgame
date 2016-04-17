/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import inet.constant.Constant;
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
public class HomeController extends BaseController{

    private List<Game> gamesNewest = new ArrayList();
    private List<Game> gamesMostView = new ArrayList();
    private List<Game> gamesMostDownload = new ArrayList();
    private List<Game> gamesHOT = new ArrayList();
    
    private int categoryId = 0;
    private int currentPage = 1;
    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
        super();
        
        //load game
        loadGame();
    }

    private void loadGame() {
        gamesHOT = GameDAO.getInstance().findGameHot(categoryId,currentPage, Constant.PAGE_SIZE);
        gamesNewest = GameDAO.getInstance().findGameNewest(categoryId,currentPage, Constant.PAGE_SIZE);
        gamesMostView = GameDAO.getInstance().findGameMostView(categoryId,currentPage, Constant.PAGE_SIZE);
        gamesMostDownload = GameDAO.getInstance().findGameMostDownload(categoryId,currentPage, Constant.PAGE_SIZE);
    }
    
    public List<Game> getGamesNewest() {
        return gamesNewest;
    }

    public void setGamesNewest(List<Game> gamesNewest) {
        this.gamesNewest = gamesNewest;
    }

    public List<Game> getGamesMostView() {
        return gamesMostView;
    }

    public void setGamesMostView(List<Game> gamesMostView) {
        this.gamesMostView = gamesMostView;
    }

    public List<Game> getGamesMostDownload() {
        return gamesMostDownload;
    }

    public void setGamesMostDownload(List<Game> gamesMostDownload) {
        this.gamesMostDownload = gamesMostDownload;
    }

    public List<Game> getGamesHOT() {
        return gamesHOT;
    }

    public void setGamesHOT(List<Game> gamesHOT) {
        this.gamesHOT = gamesHOT;
    }

    
    
}
