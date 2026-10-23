package Pck_DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {
    private static final String URL =
            "jdbc:mysql://localhost:3306/bd_sevcompany";;

    private static final String USUARIO = "";
    private static final String SENHA = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
