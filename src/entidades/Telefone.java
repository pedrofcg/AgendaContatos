package entidades;


public class Telefone {
  private int ddi = 0;
  private int ddd = 0;
  private int numero = 0;  
  
  public Telefone(int ddi, int ddd, int numero){
    this.ddi = ddi;
    this.ddd = ddd;
    this.numero = numero;
  }

  public int getDdi() {
    return ddi;
  }

  public void setDdi(int ddi) throws Exception {
        if (ddi <= 0) throw new Exception("DDI deve ser positivo.");
        this.ddi = ddi;
    }

  public int getDdd() {
    return ddd;
  }

  public void setDdd(int ddd) throws Exception {
        if (ddd <= 0) throw new Exception("DDD deve ser positivo.");
        this.ddd = ddd;
    }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) throws Exception {
        if (numero <= 0) throw new Exception("Número deve ser positivo.");
        this.numero = numero;
    }   
  

  @Override
  public String toString() {
    return "+"+ddi+"("+ ddd+")"+numero;
  }
}
