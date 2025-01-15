import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public Connection Conexao() {
        // Declarações JDBC
        Connection Conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/BD_Propriedade_Rural"; // Nome do seu banco de dados
            String username = "postgres"; // Seu usuário
            String password = "12345"; // Sua senha

            // Carrega o driver JDBC do PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Estabelece a conexão com o banco de dados
            Conn = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Conn;
    }
}


// public static void Conexao() {
//     // Configurações de conexão com o banco de dados
//     String url = "jdbc:postgresql://localhost:5432/BD_Propriedade_Rural"; // Nome do seu banco de dados
//     String username = "postgres"; // Seu usuário
//     String password = "12345"; // Sua senha
    
//     // Declarações JDBC
//     Connection connection = null;
//     Statement statement = null;
//     ResultSet resultSet = null;

//     try {
//         // Carrega o driver JDBC do PostgreSQL
//         Class.forName("org.postgresql.Driver");

//         // Estabelece a conexão com o banco de dados
//         connection = DriverManager.getConnection(url, username, password);

//         System.out.println("Conexão estabelecida.\n");

//         Inicio();

//     } catch (ClassNotFoundException e) {
//         e.printStackTrace();
//     } catch (SQLException e) {
//         e.printStackTrace();
//     } finally {
//         // Fecha os recursos JDBC em ordem inversa
//         try {
//             if (resultSet != null)
//                 resultSet.close();
//             if (statement != null)
//                 statement.close();
//             if (connection != null){
//                 connection.close();
//                 System.out.println("\nConexão finalizada.\n");
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }