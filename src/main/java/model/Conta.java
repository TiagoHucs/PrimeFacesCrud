package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cleiton
 */
@Entity
@Table(name = "CONTA")
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c")
    , @NamedQuery(name = "Conta.findByNumero", query = "SELECT c FROM Conta c WHERE c.numero = :numero")
    , @NamedQuery(name = "Conta.findByDono", query = "SELECT c FROM Conta c WHERE c.dono = :dono")
    , @NamedQuery(name = "Conta.findByLimite", query = "SELECT c FROM Conta c WHERE c.limite = :limite")
    , @NamedQuery(name = "Conta.findBySaldo", query = "SELECT c FROM Conta c WHERE c.saldo = :saldo")})
public class Conta implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "DONO")
    private String dono;

    @Column(name = "LIMITE")
    private Double limite;

    @Column(name = "SALDO")
    private Double saldo;
    
    public Conta() {
    }

    public Conta(Integer numero) {
        this.numero = numero;
    }

    public Conta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the dono
     */
    public String getDono() {
        return dono;
    }

    /**
     * @param dono the dono to set
     */
    public void setDono(String dono) {
        this.dono = dono;
    }

    /**
     * @return the limite
     */
    public Double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(Double limite) {
        this.limite = limite;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getNumero() != null ? getNumero().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.getNumero() == null && other.getNumero() != null) || (this.getNumero() != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Conta[ numero=" + getNumero() + " ]";
    }

}
