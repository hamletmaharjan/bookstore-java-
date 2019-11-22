/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hams
 */
@Entity
@Table(name = "table_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCart.findAll", query = "SELECT t FROM TableCart t")
    , @NamedQuery(name = "TableCart.findByCaId", query = "SELECT t FROM TableCart t WHERE t.caId = :caId")})
public class TableCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ca_id")
    private Long caId;
    @JoinColumn(name = "customer_id", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private TableCustomer customerId;
    @JoinColumn(name = "book_id", referencedColumnName = "b_id")
    @ManyToOne(optional = false)
    private TableBook bookId;

    public TableCart() {
    }

    public TableCart(Long caId) {
        this.caId = caId;
    }

    public Long getCaId() {
        return caId;
    }

    public void setCaId(Long caId) {
        this.caId = caId;
    }

    public TableCustomer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(TableCustomer customerId) {
        this.customerId = customerId;
    }

    public TableBook getBookId() {
        return bookId;
    }

    public void setBookId(TableBook bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caId != null ? caId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCart)) {
            return false;
        }
        TableCart other = (TableCart) object;
        if ((this.caId == null && other.caId != null) || (this.caId != null && !this.caId.equals(other.caId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.kist_bit.bookstore.entity.TableCart[ caId=" + caId + " ]";
    }
    
}
