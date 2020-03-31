package pl.com.bizpol.wspolnota.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author netcom
 */
public class DAOUtils {

    /**
     *
     * @param myConn
     * @param myStmt
     * @param myRs
     * @throws SQLException
     */
    public static void close(Connection myConn, Statement myStmt, ResultSet myRs)
                    throws SQLException {

            if (myRs != null) {
                    myRs.close();
            }

            if (myStmt != null) {

            }

            if (myConn != null) {
                    myConn.close();
            }
    }

    /**
     *
     * @param myStmt
     * @param myRs
     * @throws SQLException
     */
    public static void close(Statement myStmt, ResultSet myRs) throws SQLException {
            close(null, myStmt, myRs);		
    }

    /**
     *
     * @param myStmt
     * @throws SQLException
     */
    public static void close(Statement myStmt) throws SQLException {
            close(null, myStmt, null);		
    }
	
}
