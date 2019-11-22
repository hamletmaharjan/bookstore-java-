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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hams
 */
@Entity
@Table(name = "table_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableContact.findAll", query = "SELECT t FROM TableContact t")
    , @NamedQuery(name = "TableContact.findById", query = "SELECT t FROM TableContact t WHERE t.id = :id")
    , @NamedQuery(name = "TableContact.findByFullName", query = "SELECT t FROM TableContact t WHERE t.fullName = :fullName")
    , @NamedQuery(name = "TableContact.findByEmail", query = "SELECT t FROM TableContact t WHERE t.email = :email")
    , @NamedQuery(name = "TableContact.findByMessage", query = "SELECT t FROM TableContact t WHERE t.message = :message")})
public class TableContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "message")
    private String message;

    public TableContact() {
    }

    public TableContact(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableContact)) {
            return false;
        }
        TableContact other = (TableContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.kist_bit.bookstore.entity.TableContact[ id=" + id + " ]";
    }
    
}
