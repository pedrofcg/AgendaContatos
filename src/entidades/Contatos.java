package entidades;

public class Contatos {
    private int id = 0;
    private String nomeCompleto = "";
    private String email = "";
    private Telefone telefone = null;
    private Endereco endereco = null;

    public Contatos(int id, String nomeCompleto, String email, Telefone telefone, Endereco endereco) {
        this.id = id;
        this.nomeCompleto = nomeCompleto.toUpperCase();
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Contatos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id <= 0) throw new Exception("ID deve ser um número positivo.");
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) throws Exception {
        if (nomeCompleto == null || nomeCompleto.isEmpty()) throw new Exception("Nome completo não pode estar vazio.");
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || email.isEmpty()) throw new Exception("Email não pode estar vazio.");
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) throws Exception {
        if (telefone == null) throw new Exception("Telefone não pode ser nulo.");
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) throws Exception {
        if (endereco == null) throw new Exception("Endereço não pode ser nulo.");
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Contatos{" + "id=" + id + ", nomeCompleto=" + nomeCompleto + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
}