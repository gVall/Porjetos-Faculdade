// import java.awt.*;
// import javax.swing.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Integracao {
    public static void Inicio() throws SQLException {
        DataBase DB = new DataBase();
        Connection Conn = DB.Conexao();

        Scanner Sc = new Scanner(System.in);
        System.out.print("\n1 - Inserir Dados\n2 - Ler Dados\n3 - Atualizar Dados\n4 - Deletar Dados\nSelecione uma ação: ");
        int Op = Sc.nextInt();

        switch (Op) {
            case 1:
                // Inserir
                Inserir(Conn);
                break;
            case 2:
                // Ler
                Ler(Conn);
                break;
            case 3:
                // Atualizar
                // Atualizar();
                break;
            case 4:
                // Deletar
                Deletar(Conn);
                break;
            default: {
                System.out.print("\n\nOpção invalida escolha novamente.");
            }
        }
        Sc.close();
    }

    public static void Inserir(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        Scanner Sc = new Scanner(System.in);
        int rowsInserted = 0;
        String query = "";

        System.out.print("\n1 - Município\n2 - Propriedade\n3 - Produto\n4 - Produção\n5 - Proprietário\n6 - Pessoa_Física\n7 - Pessoa_Jurídica\n8 - Proprietário_Proprieadade\n9 - Dono_Pessoa_Jurídica\nSelecione uma ação: ");
        int Op = Sc.nextInt();

        switch (Op) {
            case 1:
                // Municipio 
                query = "INSERT INTO MUNICIPIO (MUNI_Nome, MUNI_UF) VALUES (?, ?)";

                // Dados a serem inseridos
                System.out.print("\nNome: ");
                String muniNome = Sc.nextLine();
                System.out.print("\nUF: ");
                String muniUF = Sc.nextLine();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, muniNome);
                preparedStatement.setString(2, muniUF);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("\nInserção realizada com sucesso");
                } else {
                    System.out.println("\nFalha ao realizar a inserção");
                }
                    
                break;
            case 2:
                // Propriedade
                query = "INSERT INTO PROPRIEDADE (PORP_Codigo_Municipio, PORP_Nome, PORP_Area, PORP_Distancia_Municipio, PORP_Valor_Aquisicao) VALUES (?, ?, ?, ?, ?)";


                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir : ");
                System.out.print("\nDigite código do município : ");
                int codMuni = Sc.nextInt();
                System.out.print("\nDigite o nome da propriedade : ");
                String nomeProp = Sc.next();
                System.out.print("\nDigite o valor da área da propriedade : ");
                double areaProp = Sc.nextDouble();
                System.out.print("\nDigite a distância da propriedade em relação ao município : ");
                double distProp = Sc.nextDouble();
                System.out.print("\nDigite o valor da aquisição : ");
                double valorProp = Sc.nextDouble();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, codMuni);
                preparedStatement.setString(2, nomeProp);
                preparedStatement.setDouble(3, areaProp);
                preparedStatement.setDouble(4, distProp);
                preparedStatement.setDouble(5, valorProp);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            case 3:
                // Produto4
                query = "INSERT INTO PRODUTO (PROD_Descricao) VALUES (?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir: ");
                System.out.print("\nDigite a nome/descrição do produto: ");
                String desProd = Sc.nextLine();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, desProd);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            case 4:
                // Produção
                query = "INSERT INTO PRODUCAO (PRODC_Codigo_Propriedade, PRODC_Codigo_Produto, PRODC_Mes_Inicio_Previsto_Colheita, PRODC_Mes_Fim_Previsto_Colheita, PRODC_Mes_Inicio_Efetivo_Colheita, PRODC_Mes_Fim_Efetivo_Colheita, PRODC_Quantidade_Previsto_Colheita, PRODC_Quantidade_Efetiva_Colheita) VALUES (?,?,?,?,?,?,?,?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir : ");
                System.out.print("\nDigite código da propriedade : ");
                int codProdcProp= Sc.nextInt();
                System.out.print("\nDigite o código produto : ");
                int codProdcProd = Sc.nextInt();
                System.out.print("\nDigite a data prevista para o início da colheita. Ex: 20-05-2010 : ");
                String dataIniPrev = Sc.next();
                System.out.print("\nDigite a data prevista para o fim da colheita. Ex: 20-05-2010 : ");
                String dataFimPrev = Sc.next();
                System.out.print("\nDigite a data efetivo para o início da colheita. Ex: 20-05-2010 : ");
                String dataIniEfet = Sc.next();
                System.out.print("\nDigite a data efetivo para o fim da colheita. Ex: 20-05-2010 : ");
                String dataFimEfet = Sc.next();
                System.out.print("\nDigite quantidade prevista da colheita : ");
                Float qntPrev= Sc.nextFloat();
                System.out.print("\nDigite quantidade efetiva da colheita : ");
                Float qntEfet= Sc.nextFloat();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, codProdcProp);
                preparedStatement.setInt(2, codProdcProd);
                preparedStatement.setString(3, dataIniPrev);
                preparedStatement.setString(4, dataFimPrev);
                preparedStatement.setString(5, dataIniEfet);
                preparedStatement.setString(6, dataFimEfet);
                preparedStatement.setFloat(7, qntPrev);
                preparedStatement.setFloat(8, qntEfet);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            case 5:
                // Proprietário
                query = "INSERT INTO PROPRIETARIO (PROPT_Nome, PROPT_Telefone, PROPT_Telefone2, PROPT_Telefone3) VALUES (?,?,?,?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir : ");
                System.out.print("\nDigite nome do proprietário : ");
                String nomeProprietario= Sc.next();
                System.out.print("\nDigite o telefone do proprietário : ");
                int telPropr = Sc.nextInt();
                System.out.print("\nDigite outro telefone do proprietário (caso não tenha digite 0) : ");
                int tel2Propr = Sc.nextInt();
                System.out.print("\nDigite outro telefone do proprietário (caso não tenha digite 0) : ");
                int tel3Propr = Sc.nextInt();
        

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, nomeProprietario);
                preparedStatement.setInt(2, telPropr);
                preparedStatement.setInt(3, tel2Propr);
                preparedStatement.setInt(4, tel3Propr);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            case 6:
                // Pessoa_Física
                query = "INSERT INTO PESSOA_FISICA (PESF_Codigo_Proprietario, PESF_Cpf, PESF_Nome, PESF_Data_Nascimento, PESF_Rg, PESF_Codigo_Proprietario_Conjuge) VALUES (?,?,?,?,?,?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir : ");
                System.out.print("\nDigite o código do proprietário : ");
                int codProprietario= Sc.nextInt();
                System.out.print("\nDigite o cpf : ");
                int cpf = Sc.nextInt();
                System.out.print("\nDigite o nome : ");
                String nome = Sc.next();
                System.out.print("\nDigite a data de nascimento. Ex: 20-05-2010 : ");
                String dataNasc = Sc.next();
                System.out.print("\nDigite o rg : ");
                int rg = Sc.nextInt();
                System.out.print("\nDigite o nome da(o) cônjuge : ");
                String nomeConju = Sc.next();
        

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, codProprietario);
                preparedStatement.setInt(2, cpf);
                preparedStatement.setString(3, nome);
                preparedStatement.setString(4, dataNasc);
                preparedStatement.setInt(5, rg);
                preparedStatement.setString(6, nomeConju);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                break;
            case 7:
                // Pessoa_Jurídica
                query = "INSERT INTO PESSOA_JURIDICA (PESJ_Codigo_Proprietario, PESJ_Cnpj, PESJ_Razao_Social, PESJ_Data_Criacao_Cnpj) VALUES (?,?,?,?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir : ");
                System.out.print("\nDigite o código do proprietário : ");
                int codPSJProp = Sc.nextInt();
                System.out.print("\nDigite o cnpj : ");
                int cnpj = Sc.nextInt();
                System.out.print("\nDigite a razão social : ");
                String razaoSoc = Sc.next();
                System.out.print("\nDigite a data de criação cnpj . Ex: 20-05-2010 : ");
                String dataCriCNPJ = Sc.next();
        

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, codPSJProp);
                preparedStatement.setInt(2, cnpj);
                preparedStatement.setString(3, razaoSoc);
                preparedStatement.setString(4, dataCriCNPJ);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            case 8:
                // Proprietário_Proprieadade
                query = "INSERT INTO PROPRIETARIO_PROPRIEDADE (PRPR_Codigo_Proprietario, PRPR_Codigo_Propriedade, PRPR_Data_Aquisicao) VALUES (?,?,?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir : ");
                System.out.print("\nDigite o código do proprietário : ");
                int codPropPropri= Sc.nextInt();
                System.out.print("\nDigite o código da propriedade : ");
                int codPropriP = Sc.nextInt();
                System.out.print("\nDigite a data de aquisição. Ex: 20-05-2010  : ");
                String dataAqui = Sc.next();
        

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, codPropPropri);
                preparedStatement.setInt(2, codPropriP);
                preparedStatement.setString(3, dataAqui);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            case 9:
                // Dono_Pessoa_Jurídica
                query = "INSERT INTO DONO_PESSOA_JURIDICA (DOPJ_Codigo_Proprietario_PESSOA_JURIDICA, DOPJ_Codigo_Proprietario_PESSOA_FISICA) VALUES (?,?)";

                // Dados a serem inseridos
                System.out.println("\nDigite os dados a seguir: ");
                System.out.print("\nDigite o código do proprietário (pessoa jurídica): ");
                int codDonoPropr= Sc.nextInt();
                System.out.print("\nDigite o código do proprietário (pessoa física): ");
                int codDonoProprF= Sc.nextInt();
        

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, codDonoPropr);
                preparedStatement.setInt(2, codDonoProprF);

                rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inserção realizada com sucesso");
                } else {
                    System.out.println("Falha ao realizar a inserção");
                }
                
                break;
            default: {
                System.out.print("\n\nOpção invalida escolha novamente.");
                Inserir(connection);
            }
        }
        Sc.close();
    }
    
    public static void Ler(Connection connection) throws SQLException {

        Scanner Sc = new Scanner(System.in);
        String query = "";
        java.sql.Statement statement = null;
        ResultSet resultSet = null;

        System.out.print("\n1 - Município\n2 - Propriedade\n3 - Produto\n4 - Produção\n5 - Proprietário\n6 - Pessoa_Física\n7 - Pessoa_Jurídica\n8 - Proprietário_Proprieadade\n9 - Dono_Pessoa_Jurídica\nSelecione uma ação: ");
        int Op = Sc.nextInt();
        
        switch (Op) {
            case 1:
                // Municipio 
                query = "SELECT * FROM MUNICIPIO";

                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int muniCodigo = resultSet.getInt("MUNI_Codigo");
                    String nomeMuni = resultSet.getString("MUNI_Nome");
                    String muniUf = resultSet.getString("MUNI_UF");
                   
                    System.out.println("\nCódigo: " + muniCodigo);
                    System.out.println("Nome: " + nomeMuni);
                    System.out.println("UF: " + muniUf);
                    System.out.println("-----------------------");
                }
                
                break;
            case 2:
                // Propriedade
                query = "SELECT * FROM PROPRIEDADE";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int proprCodigo = resultSet.getInt("PORP_Codigo");
                    int codMunic = resultSet.getInt("PORP_Codigo_Municipio");
                    String propNome = resultSet.getString("PORP_Nome");
                    Float area = resultSet.getFloat("PORP_Area");
                    int distMuni = resultSet.getInt("PORP_Distancia_Municipio");
                    Float valorAquis = resultSet.getFloat("PORP_Valor_Aquisicao");
                   
                    System.out.println("\nCódigo propriedade: " + proprCodigo);
                    System.out.println("Código município: " + codMunic);
                    System.out.println("Nom propriedade: " + propNome);
                    System.out.println("Área: " + area);
                    System.out.println("Distância até município : " + distMuni);
                    System.out.println("Valor aquisição : " + valorAquis);
                    System.out.println("-----------------------");
                }
                
                break;
            case 3:
                // Produto
                query = "SELECT * FROM PRODUTO";

                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int codigo = resultSet.getInt("PROD_Codigo");
                    String descricao = resultSet.getString("PROD_Descricao");

                    System.out.println("\nCódigo: " + codigo);
                    System.out.println("Descrição: " + descricao);
                    System.out.println("-----------------------");
                }
                break;
            case 4:
                // Produção
                query = "SELECT * FROM PRODUCAO";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int prodcCod = resultSet.getInt("PRODC_Codigo");
                    int prodcCodPropr = resultSet.getInt("PRODC_Codigo_Propriedade");
                    int prodcCodProd = resultSet.getInt("PRODC_Codigo_Produto");
                    String prodcMesIniP = resultSet.getString("PRODC_Mes_Inicio_Previsto_Colheita");
                    String prodcMesFimP = resultSet.getString("PRODC_Mes_Fim_Previsto_Colheita");
                    String prodcMesIniE = resultSet.getString("PRODC_Mes_Inicio_Efetivo_Colheita");
                    String prodcMesFimE = resultSet.getString("PRODC_Mes_Fim_Efetivo_Colheita");
                    int prodcQntIniP = resultSet.getInt("PRODC_Quantidade_Previsto_Colheita");
                    int prodcQntIniE = resultSet.getInt("PRODC_Quantidade_Efetiva_Colheita");
                  
                   
                    System.out.println("\nCódigo produção : " + prodcCod);
                    System.out.println("Código propriedade : " + prodcCodPropr);
                    System.out.println("Código produto: " + prodcCodProd);
                    System.out.println("Data início previsto : " + prodcMesIniP);
                    System.out.println("Data fim previsto : " + prodcMesFimP);
                    System.out.println("Data início efetivo : " + prodcMesIniE);
                    System.out.println("Data fim previsto : " + prodcMesFimE);
                    System.out.println("Quantidade colheita previsto : " + prodcQntIniP);
                    System.out.println("Quantidade colheita efetivo : " + prodcQntIniE);
                    System.out.println("-----------------------");
                }
                
                break;
            case 5:
                // Proprietário
                query = "SELECT * FROM PROPRIETARIO";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int proptCod = resultSet.getInt("PROPT_Codigo");
                    String proptNome = resultSet.getString("PROPT_Nome");
                    long proptT1 = resultSet.getLong("PROPT_Telefone");
                    long proptT2 = resultSet.getLong("PROPT_Telefone2");
                    long proptT3 = resultSet.getLong("PROPT_Telefone3");
                
            
                    System.out.println("\nCódigo proprietário : " + proptCod);
                    System.out.println("Nome proprietário : " + proptNome);
                    System.out.println("Telefone 1 : " + proptT1);
                    System.out.println("Telefone 2 : " + proptT2);
                    System.out.println("Telefone 3 : " + proptT3);
                    System.out.println("-----------------------");
                }
                
                break;
            case 6:
                // Pessoa_Física
                query = "SELECT * FROM PESSOA_FISICA";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int pesfCod= resultSet.getInt("PESF_Codigo");
                    int pesfCodPropr= resultSet.getInt("PESF_Codigo_Proprietario");
                    long pesfCpf = resultSet.getLong("PESF_Cpf");
                    String pesfNome = resultSet.getString("PESF_Nome");
                    String pesfDataNasc = resultSet.getString("PESF_Data_Nascimento");
                    long pesfRg = resultSet.getLong("PESF_Rg");
                    int pesfCodConj = resultSet.getInt("PESF_Codigo_Proprietario_Conjuge");


                    System.out.println("\nCódigo pessoa física : " + pesfCod);
                    System.out.println("Código propriedade pessoa física : " + pesfCodPropr);
                    System.out.println("CPF pessoa física : " + pesfCpf);
                    System.out.println("Nome pessoa física : " + pesfNome);
                    System.out.println("Data nascimento pessoa física : " + pesfDataNasc);
                    System.out.println("RG pessoa física : " + pesfRg);
                    System.out.println("Código Conjuge: " + pesfCodConj);
                    System.out.println("-----------------------");
                }
                
                break;
            case 7:
                // Pessoa_Jurídica
                query = "SELECT * FROM PESSOA_JURIDICA";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int pesjCod= resultSet.getInt("PESJ_Codigo");
                    int pesjCodPropr= resultSet.getInt("PESJ_Codigo_Proprietario");
                    long pesjCnpj = resultSet.getLong("PESJ_Cnpj");
                    String pesjRazaoSocial = resultSet.getString("PESJ_Razao_Social");
                    String pesjDataCria = resultSet.getString("PESJ_Data_Criacao_Cnpj");

                    System.out.println("\nCódigo pessoa jurídica : " + pesjCod);
                    System.out.println("Código propriedade pessoa jurídica : " + pesjCodPropr);
                    System.out.println("CNPJ pessoa jurídica : " + pesjCnpj);
                    System.out.println("Razão social pessoa jurídica: " + pesjRazaoSocial);
                    System.out.println("Data criação cnpj pessoa jurídica : " + pesjDataCria);
                    System.out.println("-----------------------");
                }
                
                break;
            case 8:
                // Proprietário_Proprieadade
                query = "SELECT * FROM PROPRIETARIO_PROPRIEDADE";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int prprCod= resultSet.getInt("PRPR_Codigo");
                    int prprCodProt= resultSet.getInt("PRPR_Codigo_Proprietario");
                    int prprCodPropd = resultSet.getInt("PRPR_Codigo_Propriedade");
                    String prprDataAq = resultSet.getString("PRPR_Data_Aquisicao");
  
                    System.out.println("\nCódigo proprietário_propriedade : " + prprCod);
                    System.out.println("Código proprietário  : " + prprCodProt);
                    System.out.println("Código propriedade : " + prprCodPropd);
                    System.out.println("Data aquisação : " + prprDataAq);
                    System.out.println("-----------------------");
                }
                
                break;
            case 9:
                // Dono_Pessoa_Jurídica
                query = "SELECT * FROM DONO_PESSOA_JURIDICA";
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    int donoPJCod= resultSet.getInt("DOPJ_Codigo");
                    int donoCodPJ= resultSet.getInt("DOPJ_Codigo_Proprietario_PESSOA_JURIDICA");
                    int donoCodPF = resultSet.getInt("DOPJ_Codigo_Proprietario_PESSOA_FISICA");

                    System.out.println("\nCódigo dono : " + donoPJCod);
                    System.out.println("Código proprietário pessoa jurídica : " + donoCodPJ);
                    System.out.println("Código proprietário pessoa física : " + donoCodPF);
                    System.out.println("-----------------------");
                }
                
                break;
            default: {
                System.out.print("\n\nOpção invalida escolha novamente.");
                Ler(connection);
            }
        }
        Sc.close();
    }

    // public static void Atualizar(Connection connection) throws SQLException {
    //     PreparedStatement preparedStatement = null;
    //     Scanner Sc = new Scanner(System.in);
    //     String query = "";

    //     System.out.print("\n1 - Município\n2 - Propriedade\n3 - Produto\n4 - Produção\n5 - Proprietário\n6 - Pessoa_Física\n7 - Pessoa_Jurídica\n8 - Proprietário_Proprieadade\n9 - Dono_Pessoa_Jurídica\nSelecione uma ação: ");
    //     int Op = Sc.nextInt();

    //     switch (Op) {
    //         case 1:
    //             // Municipio 
    //             query = "UPDATE MUNICIPIO SET MUNI_Nome = ?, MUNI_UF = ? WHERE MUNI_Codigo = ?";
                
    //             // Dados a serem atualizados
    //             System.out.println("\nDigite os dados a seguir: ");
    //             System.out.print("\nDigite o código do municipio a ser atualizado: ");
    //             int municipioCodigo = Sc.nextInt();
    //             System.out.print("\nDigite o nome do municipio: ");
    //             String novoNome = Sc.nextLine();
    //             String novoUF = Sc.nextLine();
    //             System.out.print("\nDigite o UF do municipio: ");

    //             preparedStatement = connection.prepareStatement(query);
    //             preparedStatement.setString(1, novoNome);
    //             preparedStatement.setString(2, novoUF);
    //             preparedStatement.setInt(3, municipioCodigo);

    //             int rowsUpdated = preparedStatement.executeUpdate();

    //             if (rowsUpdated > 0) {
    //                 System.out.println("Atualização realizada com sucesso!");
    //             } else {
    //                 System.out.println("Falha ao realizar a atualização.");
    //             }
    //             break;
    //         default: {
    //             System.out.print("\n\nOpção invalida escolha novamente.");
    //             Atualizar(connection);
    //         }
    //     }
    //     Sc.close();
    // }
    
    public static void Deletar(Connection connection) throws SQLException {
        String query = "";
        int rowsDeleted = 0;
        Scanner Sc = new Scanner(System.in);
        PreparedStatement preparedStatement = null;

        System.out.print("\n1 - Município\n2 - Propriedade\n3 - Produto\n4 - Produção\n5 - Proprietário\n6 - Pessoa_Física\n7 - Pessoa_Jurídica\n8 - Proprietário_Proprieadade\n9 - Dono_Pessoa_Jurídica\nSelecione uma ação: ");
        int Op = Sc.nextInt();

        switch (Op) {
            case 1:
                // Municipio
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM MUNICIPIO WHERE MUNI_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Município: ");
                int municipioCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, municipioCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }

                break;
            case 2:
                // Propriedade
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PROPRIEDADE WHERE PORP_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Propriedade: ");
                int proriedadeCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, proriedadeCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 3:
                // Produto
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PRODUTO WHERE PROD_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Produto: ");
                int produtoCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, produtoCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 4:
                // Produção
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PRODUCAO WHERE PRODC_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Produção: ");
                int producaoCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, producaoCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 5:
                // Proprietário
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PROPRIETARIO WHERE PROPT_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Proprietário: ");
                int proprietarioCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, proprietarioCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 6:
                // Pessoa_Física
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PESSOA_FISICA WHERE PESF_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Pessoa Física: ");
                int PFCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, PFCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 7:
                // Pessoa_Jurídica
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PESSOA_JURIDICA WHERE PESJ_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Pessoa Jurídica: ");
                int PJCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, PJCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 8:
                // Proprietário_Proprieadade
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM PROPRIETARIO_PROPRIEDADE WHERE PRPR_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Proprietário Proprieadade: ");
                int PRPRCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, PRPRCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            case 9:
                // Dono_Pessoa_Jurídica
                System.out.println("\nDigite os dados a seguir:");
                query = "DELETE FROM DONO_PESSOA_JURIDICA WHERE DOPJ_Codigo = ?";

                // Código do município a ser excluído
                System.out.print("Código Dono Pessoa Jurídica: ");
                int DOPJCodigo = Sc.nextInt();

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, DOPJCodigo);

                rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Exclusão realizada com sucesso!");
                } else {
                    System.out.println("Falha ao realizar a exclusão.");
                }
        
                break;
            default: {
                System.out.print("\n\nOpção invalida escolha novamente.");
                Deletar(connection);
            }  
        }
        Sc.close();
    }
}
