
import inet.common.database.pool.DBPool;
import inet.dao.SeoDao;
import inet.util.Encrypter;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NewClass {
    public static void main(String[] args) throws Exception {
        //System.out.println(Encrypter.encrypt("M6v2ayEunyLUnuRG"));
        DBPool.loadConfiguration(NewClass.class.getResourceAsStream("/inet/dbpool.properties"));
        Connection con = DBPool.getInstance("bigone").getConnection();
           if(con == null)  {
               System.out.println("fail");
           } else {
               System.out.println("success");
           }
               
    }
}
