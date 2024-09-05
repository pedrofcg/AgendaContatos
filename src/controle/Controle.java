package controle;

import entidades.Contatos;
import entidades.Endereco;
import entidades.Icrud;
import entidades.Telefone;
import java.util.List;
import persistencia.ContatoDao;
import util.conexaoBD;
import javax.swing.JOptionPane;

public class Controle implements Icrud {

    private Icrud acesso;

    public Controle(Icrud acesso) {
        this.acesso = acesso;
    }

    @Override
    public void incluir(Contatos contato) throws Exception {
        String erro = verificar(contato);
        if (!erro.isEmpty()) {
            JOptionPane.showMessageDialog(null, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;  // Evita que o método continue após encontrar um erro
        }

        try {
            acesso.incluir(contato);
        } catch (Exception e) {
            throw new Exception("Erro ao incluir contato: " + e.getMessage(), e);
        }
    }

    @Override
    public void excluir(String nomeCompleto) throws Exception {
        if (nomeCompleto == null || nomeCompleto.isEmpty()) {
            String erro = "Insira o nome do cliente a ser excluído.\n";
            JOptionPane.showMessageDialog(null, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;  // Evita que o método continue após encontrar um erro
        }

        // Verificar conexão com o banco de dados
        if (conexaoBD.getConexao() == null) {
            throw new Exception("Não foi possível conectar ao banco de dados.");
        }

        acesso.excluir(nomeCompleto);
    }

    @Override
    public void alterar(Contatos contatoNovo) throws Exception {
        String erro = verificar(contatoNovo);
        if (!erro.isEmpty()) {
            JOptionPane.showMessageDialog(null, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;  // Evita que o método continue após encontrar um erro
        }

        // Verificar conexão com o banco de dados
        if (conexaoBD.getConexao() == null) {
            throw new Exception("Não foi possível conectar ao banco de dados.");
        }

        acesso.alterar(contatoNovo);
    }

    @Override
    public List<Contatos> consultar(String nome) throws Exception {
        // Verificar conexão com o banco de dados
        if (conexaoBD.getConexao() == null) {
            throw new Exception("Não foi possível conectar ao banco de dados.");
        }

        return acesso.consultar(nome);
    }

    @Override
    public List<Contatos> listarContatos(String orderBy) throws Exception {
        // Verificar conexão com o banco de dados
        if (conexaoBD.getConexao() == null) {
            throw new Exception("Não foi possível conectar ao banco de dados.");
        }

        return acesso.listarContatos(orderBy);
    }

    public String verificar(Contatos contato) {
    StringBuilder erro = new StringBuilder();

    // Verificação do campo nome completo
    if (contato.getNomeCompleto().isEmpty()) 
        erro.append("Esse campo (nome) é obrigatório, não pode estar vazio.\n");
    if (!contato.getNomeCompleto().matches("^[a-zA-Z ]+$")) 
        erro.append("Esse campo (nome) somente aceita letras.\n");

    // Verificação do campo email
    if (contato.getEmail().isEmpty()) 
        erro.append("Esse campo (email) é obrigatório, não pode estar vazio.\n");
    // Regex robusta para email
    if (!contato.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) 
        erro.append("Email inválido.\n");

    // Verificação dos campos de telefone
    Telefone telefone = contato.getTelefone();
    if (telefone == null) {
        erro.append("Telefone não pode ser nulo.\n");
    } else {
        if (telefone.getDdi() <= 0) 
            erro.append("Esse campo (DDI) é obrigatório e deve ser um número positivo.\n");
        if (telefone.getDdd() <= 0) 
            erro.append("Esse campo (DDD) é obrigatório e deve ser um número positivo.\n");
        String numeroStr = String.valueOf(telefone.getNumero());
        if (numeroStr.isEmpty()) 
            erro.append("Esse campo (número) é obrigatório e não pode estar vazio.\n");
        if (!numeroStr.matches("[0-9]+")) 
            erro.append("Esse campo (número) somente aceita números.\n");
        if (numeroStr.length() != 9) 
            erro.append("Numero Invalido! \n");
    }

    // Verificação dos campos de endereço
    Endereco endereco = contato.getEndereco();
    if (endereco == null) {
        erro.append("Endereço não pode ser nulo.\n");
    } else {
        if (endereco.getLogradouro().isEmpty()) 
            erro.append("Esse campo (logradouro) é obrigatório, não pode estar vazio.\n");
        if (endereco.getNumero() <= 0) 
            erro.append("Esse campo (número) deve ser um número positivo.\n");
        if (endereco.getCep() <= 0) 
            erro.append("Esse campo (CEP) é obrigatório e deve ser um número positivo.\n");
        if (endereco.getCidade().isEmpty()) 
            erro.append("Esse campo (cidade) é obrigatório, não pode estar vazio.\n");
        if (endereco.getEstado().isEmpty()) 
            erro.append("Esse campo (estado) é obrigatório, não pode estar vazio.\n");
    }

    return erro.toString();
}
}
