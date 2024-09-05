
package entidades;

import entidades.Contatos;
import java.util.ArrayList;
import java.util.List;

public interface Icrud {
   
    public void incluir(Contatos contato)throws  Exception;
    public void excluir(String nomeCompleto)throws  Exception;
    public void alterar(Contatos contatoNovo)throws  Exception;
    public List<Contatos> consultar(String email)throws  Exception;
    public List<Contatos> listarContatos(String orderBy) throws Exception;
   
    
    
    
}
