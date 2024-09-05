/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexaoBD {
  private static Connection conexao = null;
    private conexaoBD(){}
    
    public static Connection getConexao() throws Exception{
      try
        {
            if(conexao == null){
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/agendaContatos";
                String user = "postgres";
                String password = "123321"; 
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
                JOptionPane.showMessageDialog(null, "Conectado com Sucesso");
            }               
        }
        catch(ClassNotFoundException erro){
            //Erro de não encontrar o drive do banco no projeto
            throw new Exception("Drive: "+erro.getMessage());
        }
        catch(SQLException erro){
            //Erro no banco de dados: usuario, senha ou banco de dados 
            throw new Exception("Banco: " + erro.getMessage());
        }
      return conexao;
    }  
}
