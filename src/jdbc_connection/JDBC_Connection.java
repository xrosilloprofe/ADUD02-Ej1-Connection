package jdbc_connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBC_Connection {

  public static void muestraErrorSQL(SQLException e) {
    System.err.println("SQL ERROR mensaje: " + e.getMessage());
    System.err.println("SQL Estado: " + e.getSQLState());
    System.err.println("SQL c�digo espec�fico: " + e.getErrorCode());
  }
  
  public static void main(String[] args) {

    String basedatos = "exemples_accessDades";
    String host = "192.168.1.35";
    String port = "3306";
    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
    String user = "xavier";
    String pwd = "1234";

    //Class.forName("com.mysql.jdbc.Driver");    // No necesario desde SE 6.0
    //Class.forName("com.mysql.cj.jdbc.Driver"); // para MySQL 8.0, no necesario
    try (Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {
      System.out.println("Conexi�n realizada.");        
    } catch (SQLException e) {
      System.out.println("SQL mensaje: " + e.getMessage());
      System.out.println("SQL Estado: " + e.getSQLState());
      System.out.println("SQL c�digo espec�fico: " + e.getErrorCode());
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

}