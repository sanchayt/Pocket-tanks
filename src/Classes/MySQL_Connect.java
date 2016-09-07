package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mazerunner_977
 */
public class MySQL_Connect {

       public static ArrayList<Weapons> list = new ArrayList<>();
       
      public static void addWeapons(String name, int power, int missedPow, String url, String description) {
        list.add(new Weapons(name,power,missedPow,url,description));
        
    }
      
      public static Player1 pl1 = new Player1();
      public static void addWeaponstoP1(Weapons w ){
          pl1.selectedWeapons.add(w);
      }
      public static void clearP1(){
          pl1.selectedWeapons.clear();
      }
      public static void clearP2(){
          pl2.selectedWeapons.clear();
      }
      public static Weapons getP1(int index){
          return pl1.selectedWeapons.get(index);
      }
      public static Weapons getP2(int index){
          return pl2.selectedWeapons.get(index);
      }
      public static Player1 pl2 = new Player1();
      public static void addWeaponstoP2(Weapons w ){
          pl2.selectedWeapons.add(w);
      }
    public static void weaponsEntry() {
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
//            String query = "";
//            stmt.executeUpdate(query);

            String query2 = "select * from weapons ;";
             ResultSet rs = stmt.executeQuery(query2);
             
             
            while (rs.next()) {
                String name = rs.getString(2);
                int power = Integer.parseInt(rs.getString(3));
                int missedpow = Integer.parseInt(rs.getString(4));
                String url = rs.getString(5);
                String description = rs.getString(6);
                MySQL_Connect.addWeapons(name, power, missedpow, url, description);
            }
            
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static final String USERNAME = "sanchayt";
    private static final String PASSWORD = "yoyoyo";
    private static final String M_CONN = "jdbc:mysql://db4free.net:3306/pockettanks";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(M_CONN, USERNAME, PASSWORD);
    }

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }

    public static Connection getConnection(int TYPE_SCROLL_INSENSITIVE, int CONCUR_READ_ONLY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
