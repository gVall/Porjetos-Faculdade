import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        Integracao Con = new Integracao();
        
        Con.Inicio();


        // // Configurações de conexão com o banco de dados
        // String url = "jdbc:postgresql://localhost:5432/BD_Propriedade_Rural"; // Nome do seu banco de dados
        // String username = "postgres"; // Seu usuário2
        // String password = "12345"; // Sua senha
        
        // // Declarações JDBC
        // Connection connection = null;
        // Statement statement = null;
        // ResultSet resultSet = null;
        
        // Scanner Sc = new Scanner(System.in);
        
        // try {
        //     // Carrega o driver JDBC do PostgreSQL
        //     Class.forName("org.postgresql.Driver");

        //     // Estabelece a conexão com o banco de dados
        //     connection = DriverManager.getConnection(url, username, password);

        //     System.out.println("Conexão estabelecida.\n");

        //     // Cria um objeto Statement para executar consultas SQL
        //     statement = connection.createStatement();


        //     // Executa uma consulta
        //     String sql = ("SELECT * FROM MUNICIPIO"); // Nome da tabela que deseja consultar
        //     resultSet = statement.executeQuery(sql);
        //     String coluna0 = "Muni_Codigo";
        //     String coluna1 = "MUNI_Nome";
        //     String coluna2 = "MUNI_UF";

        //     System.out.println("\nTabela: MUNICIPIO");

        //     // Processa os resultados da consulta
        //     while (resultSet.next()) {
        //         // Recupera os valores das colunas por nome ou índice
        //         String Dados = (resultSet.getString(coluna0) + ", " + resultSet.getString(coluna1) + ", " + resultSet.getString(coluna2));
        //         System.out.println(Dados);
        //         // ... processa os valores recuperados ...
        //     }


            

        //     // Executa uma consulta
        //     sql = ("SELECT * FROM MUNICIPIO"); // Nome da tabela que deseja consultar
        //     resultSet = statement.executeQuery(sql);
        //     coluna0 = "Muni_Codigo";
        //     coluna1 = "MUNI_Nome";
        //     coluna2 = "MUNI_UF";

        //     System.out.println("\nTabela: MUNICIPIO");

        //     // Processa os resultados da consulta
        //     while (resultSet.next()) {
        //         // Recupera os valores das colunas por nome ou índice
        //         String Dados = (resultSet.getString(coluna0) + ", " + resultSet.getString(coluna1) + ", " + resultSet.getString(coluna2));
        //         System.out.println(Dados);
        //         // ... processa os valores recuperados ...
        //     }

        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // } finally {
        //     // Fecha os recursos JDBC em ordem inversa
        //     try {
        //         if (resultSet != null)
        //             resultSet.close();
        //         if (statement != null)
        //             statement.close();
        //         if (connection != null){
        //             connection.close();
        //             System.out.println("\nConexão finalizada.\n");
        //         }
        //         Sc.close();
        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
        //     // Interface tela = new Interface();
        //     // tela.Tela();
        // }
    }
}
