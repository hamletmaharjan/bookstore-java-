/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "table_author")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableAuthor.findAll", query = "SELECT t FROM TableAuthor t")
    , @NamedQuery(name = "TableAuthor.findByAId", query = "SELECT t FROM TableAuthor t WHERE t.aId = :aId")
    , @NamedQuery(name = "TableAuthor.findByAFirstname", query = "SELECT t FROM TableAuthor t WHERE t.aFirstname = :aFirstname")
    , @NamedQuery(name = "TableAuthor.findByALastname", query = "SELECT t FROM TableAuthor t WHERE t.aLastname = :aLastname")
    , @NamedQuery(name = "TableAuthor.findByAge", query = "SELECT t FROM TableAuthor t WHERE t.age = :age")
    , @NamedQuery(name = "TableAuthor.findByEmail", query = "SELECT t FROM TableAuthor t WHERE t.email = :email")
    , @NamedQuery(name = "TableAuthor.findByContact", query = "SELECT t FROM TableAuthor t WHERE t.contact = :contact")})
public class TableAuthor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "a_id")
    private Long aId;
    @Column(name = "a_firstname")
    private String aFirstname;
    @Column(name = "a_lastname")
    private String aLastname;
    @Column(name = "age")
    private BigInteger age;
    @Column(name = "email")
    private String email;
    @Column(name = "contact")
    private String contact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private List<TableBook> tableBookList;

    public TableAuthor() {
    }

    public TableAuthor(Long aId) {
        this.aId = aId;
    }

    public Long getAId() {
        return aId;
    }

    public void setAId(Long aId) {
        this.aId = aId;
    }

    public String getAFirstname() {
        return aFirstname;
    }

    public void setAFirstname(String aFirstname) {
        this.aFirstname = aFirstname;
    }

    public String getALastname() {
        return aLastname;
    }

    public void setALastname(String aLastname) {
        this.aLastname = aLastname;
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @XmlTransient
    public List<TableBook> getTableBookList() {
        return tableBookList;
    }

    public void setTableBookList(List<TableBook> tableBookList) {
        this.tableBookList = tableBookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aId != null ? aId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableAuthor)) {
            return false;
        }
        TableAuthor other = (TableAuthor) object;
        if ((this.aId == null && other.aId != null) || (this.aId != null && !this.aId.equals(other.aId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.kist_bit.bookstore.entity.TableAuthor[ aId=" + aId + " ]";
    }
    
}
