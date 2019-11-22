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
@Table(name = "table_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrder.findAll", query = "SELECT t FROM TableOrder t")
    , @NamedQuery(name = "TableOrder.findByOId", query = "SELECT t FROM TableOrder t WHERE t.oId = :oId")
    , @NamedQuery(name = "TableOrder.findByState", query = "SELECT t FROM TableOrder t WHERE t.state = :state")
    , @NamedQuery(name = "TableOrder.findByCity", query = "SELECT t FROM TableOrder t WHERE t.city = :city")
    , @NamedQuery(name = "TableOrder.findByZipCode", query = "SELECT t FROM TableOrder t WHERE t.zipCode = :zipCode")
    , @NamedQuery(name = "TableOrder.findByAddressLine1", query = "SELECT t FROM TableOrder t WHERE t.addressLine1 = :addressLine1")
    , @NamedQuery(name = "TableOrder.findByAddressLine2", query = "SELECT t FROM TableOrder t WHERE t.addressLine2 = :addressLine2")})
public class TableOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "o_id")
    private Long oId;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private Integer zipCode;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @JoinColumn(name = "customer_id", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private TableCustomer customerId;
    @JoinColumn(name = "book_id", referencedColumnName = "b_id")
    @ManyToOne(optional = false)
    private TableBook bookId;

    public TableOrder() {
    }

    public TableOrder(Long oId) {
        this.oId = oId;
    }

    public Long getOId() {
        return oId;
    }

    public void setOId(Long oId) {
        this.oId = oId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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
        hash += (oId != null ? oId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrder)) {
            return false;
        }
        TableOrder other = (TableOrder) object;
        if ((this.oId == null && other.oId != null) || (this.oId != null && !this.oId.equals(other.oId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.kist_bit.bookstore.entity.TableOrder[ oId=" + oId + " ]";
    }
    
}
