/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller;

import inet.constant.Constant;
import inet.dao.GameDAO;
import inet.entities.Game;
import inet.entities.Pagination;
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
    
    private int countGameHOT = 0;
    private int countGameMostView = 0;
    private int countGameMostDownload = 0;
    private int countGameNewest = 0;    
    
    private int categoryId = 0;
    
    private boolean isShowPaging = false;
    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
        super();
        init();
    }

    private void init(){
//        if(getParameter("action") != null && "view-more".equals(getParameter("action"))){
//            isShowPaging = true;
//        }
        isShowPaging = getParameter("typeView") != null;
//        System.out.println("=========="+ getParameter("typeView"));
        if(getParameter("p") != null){
            try{
                setCurentPage(Integer.valueOf(getParameter("p")));
            }catch(Exception e){}
        }        
    }
    
    public List<Game> getGamesNewest() {
        if(gamesNewest.isEmpty()){
            gamesNewest = GameDAO.getInstance().findGameNewest(categoryId, getCurentPage(), getPageSize());
            if(isShowPaging){
                int count = GameDAO.getInstance().countGame();
                pagination(count);
            }
        }
        return gamesNewest;
    }

    public void setGamesNewest(List<Game> gamesNewest) {
        this.gamesNewest = gamesNewest;
    }

    public List<Game> getGamesMostView() {
        if(gamesMostView.isEmpty()){
            gamesMostView = GameDAO.getInstance().findGameMostView(categoryId,getCurentPage(), getPageSize());
            if(isShowPaging){
                int count = GameDAO.getInstance().countGame();
                pagination(count);
            }
        }
        return gamesMostView;
    }

    public void setGamesMostView(List<Game> gamesMostView) {
        this.gamesMostView = gamesMostView;
    }

    public List<Game> getGamesMostDownload() {
        if(gamesMostDownload.isEmpty()){
            gamesMostDownload = GameDAO.getInstance().findGameMostDownload(categoryId,getCurentPage(), getPageSize());
            if(isShowPaging){
                int count = GameDAO.getInstance().countGame();
                pagination(count);
            }
        }
        return gamesMostDownload;
    }

    public void setGamesMostDownload(List<Game> gamesMostDownload) {
        this.gamesMostDownload = gamesMostDownload;
    }

    public List<Game> getGamesHOT() {
        if(gamesHOT.isEmpty()){ 
            gamesHOT = GameDAO.getInstance().findGameHot(categoryId, getCurentPage(), getPageSize());
            if(isShowPaging){
                int count = GameDAO.getInstance().countGameHot();
                pagination(count);
            }
        }
        return gamesHOT;
    }

    public void setGamesHOT(List<Game> gamesHOT) {
        this.gamesHOT = gamesHOT;
    }

    public int getCountGameHOT() {
        return countGameHOT;
    }

    public void setCountGameHOT(int countGameHOT) {
        this.countGameHOT = countGameHOT;
    }

    public int getCountGameMostView() {
        return countGameMostView;
    }

    public void setCountGameMostView(int countGameMostView) {
        this.countGameMostView = countGameMostView;
    }

    public int getCountGameMostDownload() {
        return countGameMostDownload;
    }

    public void setCountGameMostDownload(int countGameMostDownload) {
        this.countGameMostDownload = countGameMostDownload;
    }

    public int getCountGameNewest() {
        return countGameNewest;
    }

    public void setCountGameNewest(int countGameNewest) {
        this.countGameNewest = countGameNewest;
    }

    
    
}
