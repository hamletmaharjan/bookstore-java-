/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hams
 */
@Entity
@Table(name = "table_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomer.findAll", query = "SELECT t FROM TableCustomer t")
    , @NamedQuery(name = "TableCustomer.findByCId", query = "SELECT t FROM TableCustomer t WHERE t.cId = :cId")
    , @NamedQuery(name = "TableCustomer.findByCName", query = "SELECT t FROM TableCustomer t WHERE t.cName = :cName")
    , @NamedQuery(name = "TableCustomer.findByCUsername", query = "SELECT t FROM TableCustomer t WHERE t.cUsername = :cUsername")
    , @NamedQuery(name = "TableCustomer.findByCEmail", query = "SELECT t FROM TableCustomer t WHERE t.cEmail = :cEmail")
    , @NamedQuery(name = "TableCustomer.findByCPhone", query = "SELECT t FROM TableCustomer t WHERE t.cPhone = :cPhone")
    , @NamedQuery(name = "TableCustomer.findByCPassword", query = "SELECT t FROM TableCustomer t WHERE t.cPassword = :cPassword")})
public class TableCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_id")
    private Long cId;
    @Basic(optional = false)
    @Column(name = "c_name")
    private String cName;
    @Basic(optional = false)
    @Column(name = "c_username")
    private String cUsername;
    @Basic(optional = false)
    @Column(name = "c_email")
    private String cEmail;
    @Basic(optional = false)
    @Column(name = "c_phone")
    private String cPhone;
    @Basic(optional = false)
    @Column(name = "c_password")
    private String cPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<TableOrder> tableOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<TableCart> tableCartList;

    public TableCustomer() {
    }

    public TableCustomer(Long cId) {
        this.cId = cId;
    }

    public TableCustomer(Long cId, String cName, String cUsername, String cEmail, String cPhone, String cPassword) {
        this.cId = cId;
        this.cName = cName;
        this.cUsername = cUsername;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
        this.cPassword = cPassword;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCUsername() {
        return cUsername;
    }

    public void setCUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCPassword() {
        return cPassword;
    }

    public void setCPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    @XmlTransient
    public List<TableOrder> getTableOrderList() {
        return tableOrderList;
    }

    public void setTableOrderList(List<TableOrder> tableOrderList) {
        this.tableOrderList = tableOrderList;
    }

    @XmlTransient
    public List<TableCart> getTableCartList() {
        return tableCartList;
    }

    public void setTableCartList(List<TableCart> tableCartList) {
        this.tableCartList = tableCartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomer)) {
            return false;
        }
        TableCustomer other = (TableCustomer) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.kist_bit.bookstore.entity.TableCustomer[ cId=" + cId + " ]";
    }
    
}
