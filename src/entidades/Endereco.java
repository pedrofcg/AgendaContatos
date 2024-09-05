/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author gusta
 */
public class Endereco {
  private String logradouro = "";
  private int numero = 0;
  private String complemento = "";
  private int cep = 0;
  private String cidade = "";
  private String estado = "";
  
  public Endereco(String logradouro, int numero, String complemento, int cep, String cidade, String estado){
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro)throws Exception {
    if (logradouro == null || logradouro.isEmpty()) throw new Exception("Logradouro não pode estar vazio.");
        this.logradouro = logradouro;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) throws Exception {
        if (numero <= 0) throw new Exception("Número deve ser positivo.");
        this.numero = numero;
    }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public int getCep() {
    return cep;
  }

  public void setCep(int cep) throws Exception {
        if (cep <= 0) throw new Exception("CEP deve ser positivo.");
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        if (cidade == null || cidade.isEmpty()) throw new Exception("Cidade não pode estar vazia.");
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if (estado == null || estado.isEmpty()) throw new Exception("Estado não pode estar vazio.");
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "logradouro = " + logradouro +"," + " numero = " + numero +"," + " complemento = " + complemento +"," + " cep = " + cep +"," + " cidade = " + cidade +"," + " estado = " + estado ;
    }

}
