/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hams
 */
@Entity
@Table(name = "table_book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableBook.findAll", query = "SELECT t FROM TableBook t")
    , @NamedQuery(name = "TableBook.findByBId", query = "SELECT t FROM TableBook t WHERE t.bId = :bId")
    , @NamedQuery(name = "TableBook.findByTitle", query = "SELECT t FROM TableBook t WHERE t.title = :title")
    , @NamedQuery(name = "TableBook.findByPrice", query = "SELECT t FROM TableBook t WHERE t.price = :price")
    , @NamedQuery(name = "TableBook.findByCategories", query = "SELECT t FROM TableBook t WHERE t.categories = :categories")
    , @NamedQuery(name = "TableBook.findByPages", query = "SELECT t FROM TableBook t WHERE t.pages = :pages")
    , @NamedQuery(name = "TableBook.findByPublishedDate", query = "SELECT t FROM TableBook t WHERE t.publishedDate = :publishedDate")
    , @NamedQuery(name = "TableBook.findByPublisher", query = "SELECT t FROM TableBook t WHERE t.publisher = :publisher")
    , @NamedQuery(name = "TableBook.findByCover", query = "SELECT t FROM TableBook t WHERE t.cover = :cover")
    , @NamedQuery(name = "TableBook.findByCheapestBooks", query = "SELECT t FROM TableBook t WHERE t.price<= :price")
    , @NamedQuery(name = "TableBook.findByLatestBooks", query = "SELECT t FROM TableBook t WHERE t.publishedDate >= :date")})
    
public class TableBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "b_id")
    private Integer bId;
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "categories")
    private String categories;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "published_date")
    @Temporal(TemporalType.DATE)
    private Date publishedDate;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "cover")
    private String cover;
    @JoinColumn(name = "author_id", referencedColumnName = "a_id")
    @ManyToOne(optional = false)
    private TableAuthor authorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TableOrder> tableOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TableCart> tableCartList;

    public TableBook() {
    }

    public TableBook(Integer bId) {
        this.bId = bId;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public TableAuthor getAuthorId() {
        return authorId;
    }

    public void setAuthorId(TableAuthor authorId) {
        this.authorId = authorId;
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
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableBook)) {
            return false;
        }
        TableBook other = (TableBook) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.kist_bit.bookstore.entity.TableBook[ bId=" + bId + " ]";
    }
    
}
