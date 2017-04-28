package by.training.nc.dev3.connectionpool;


import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Win on 10.04.2017.
 */

public class ConnectionPool {

  public static Connection getConnection()
  {
      InitialContext initContext= null;
      try {
          initContext = new InitialContext();
          DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/coffeemachine");
          try {
              Connection conn = ds.getConnection();
              return conn;
          } catch (SQLException e) {
              e.printStackTrace();
          }
      } catch (NamingException e) {
          e.printStackTrace();
      }

      return null;
  }

  public static void closeConnection(Connection connection) {
      if (connection != null) {
          try {
              connection.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

  }






}

