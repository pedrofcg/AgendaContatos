package persistencia;


import entidades.Contatos;
import entidades.Endereco;
import entidades.Telefone;
import entidades.Icrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.conexaoBD;

public class ContatoDao implements Icrud {
    private Connection conexao = null;

    public ContatoDao() throws Exception {
        conexao = conexaoBD.getConexao();
    }

    @Override
    public void incluir(Contatos objeto) throws Exception {
    try {
        String sql = "INSERT INTO contatos(nomeCompleto, email, DDI, DDD, numero, logradouro, numeroEndereco,"
                + " complemento, cep, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, objeto.getNomeCompleto());
        preparedStatement.setInt(3, objeto.getTelefone().getDdi());
        preparedStatement.setInt(4, objeto.getTelefone().getDdd());
        preparedStatement.setInt(5, objeto.getTelefone().getNumero());
        preparedStatement.setString(2, objeto.getEmail());
        preparedStatement.setString(6, objeto.getEndereco().getLogradouro());
        preparedStatement.setInt(7, objeto.getEndereco().getNumero());
        preparedStatement.setString(8, objeto.getEndereco().getComplemento());
        preparedStatement.setInt(9, objeto.getEndereco().getCep());
        preparedStatement.setString(10, objeto.getEndereco().getCidade());
        preparedStatement.setString(11, objeto.getEndereco().getEstado());
        preparedStatement.executeUpdate();
        
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                objeto.setId(generatedKeys.getInt(1));
            }
        
    } catch (SQLException erro) {
        throw new Exception("Erro ao inserir contato no banco de dados: " + erro.getMessage());
    }
}

    @Override
    public void excluir(String nomeCompleto) throws Exception {
        try {
            String sql = "DELETE FROM contatos WHERE nomecompleto=?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nomeCompleto);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    
    @Override
    public void alterar(Contatos contatoNovo) throws Exception {
        
        try {
        String sql = "UPDATE contatos SET nomeCompleto = ?, email = ?, DDI = ?, DDD = ?, numero = ?, logradouro = ?, "
                   + "numeroEndereco = ?, complemento = ?, cep = ?, cidade = ?, estado = ? WHERE id = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, contatoNovo.getNomeCompleto());
        preparedStatement.setString(2, contatoNovo.getEmail());
        preparedStatement.setInt(3, contatoNovo.getTelefone().getDdi());
        preparedStatement.setInt(4, contatoNovo.getTelefone().getDdd());
        preparedStatement.setInt(5, contatoNovo.getTelefone().getNumero());
        preparedStatement.setString(6, contatoNovo.getEndereco().getLogradouro());
        preparedStatement.setInt(7, contatoNovo.getEndereco().getNumero());
        preparedStatement.setString(8, contatoNovo.getEndereco().getComplemento());
        preparedStatement.setInt(9, contatoNovo.getEndereco().getCep());
        preparedStatement.setString(10, contatoNovo.getEndereco().getCidade());
        preparedStatement.setString(11, contatoNovo.getEndereco().getEstado());
        preparedStatement.setInt(12, contatoNovo.getId()); // Assumindo que a PK é o id
        preparedStatement.executeUpdate();
    } catch (SQLException erro) {
        throw new Exception("Erro ao atualizar contato no banco de dados: " + erro.getMessage());
    }
        
    }

    
    @Override
    public List<Contatos> consultar(String email) throws Exception {
    List<Contatos> contatos = new ArrayList<>();
    try {
        String sql = "SELECT * FROM contatos WHERE email LIKE ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, "%" + email + "%");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nomeCompleto = rs.getString("nomecompleto");
            int ddi = rs.getInt("ddi");
            int ddd = rs.getInt("ddd");
            int numero = rs.getInt("numero");
            String emailResult = rs.getString("email");
            String logradouro = rs.getString("logradouro");
            int numeroEndereco = rs.getInt("numeroEndereco");
            String complemento = rs.getString("complemento");
            int cep = rs.getInt("cep");
            String cidade = rs.getString("cidade");
            String estado = rs.getString("estado");
            Telefone telefone = new Telefone(ddi, ddd, numero);
            Endereco endereco = new Endereco(logradouro, numeroEndereco, complemento, cep, cidade, estado);
            Contatos contato = new Contatos(id, nomeCompleto, emailResult, telefone, endereco); 
            contatos.add(contato);
        }
    } catch (SQLException erro) {
        throw new Exception("SQL Erro: " + erro.getMessage());
    }
    return contatos;

}


    
    @Override
    public List<Contatos> listarContatos(String orderBy) throws Exception {
        
    List<Contatos> listaContatos = new ArrayList<>();
    try {
        String sql = "SELECT * FROM contatos ORDER BY " + orderBy;
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Contatos contato = new Contatos();
            contato.setId(resultSet.getInt("id"));
            contato.setNomeCompleto(resultSet.getString("nomecompleto"));
            contato.setEmail(resultSet.getString("email"));
            Telefone telefone = new Telefone(resultSet.getInt("ddi"), resultSet.getInt("ddd"), resultSet.getInt("numero"));
            Endereco endereco = new Endereco(resultSet.getString("logradouro"), resultSet.getInt("numeroendereco"),
                    resultSet.getString("complemento"), resultSet.getInt("cep"),
                    resultSet.getString("cidade"), resultSet.getString("estado"));
            contato.setTelefone(telefone);
            contato.setEndereco(endereco);
            listaContatos.add(contato);
        }
    } catch (SQLException erro) {
        throw new Exception("Erro ao listar contatos do banco de dados: " + erro.getMessage());
    }
    return listaContatos;
    }
    
   
    
}

    

    

    

    

