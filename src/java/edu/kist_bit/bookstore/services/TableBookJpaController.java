/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.services;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edu.kist_bit.bookstore.entity.TableAuthor;
import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.entity.TableOrder;
import java.util.ArrayList;
import java.util.List;
import edu.kist_bit.bookstore.entity.TableCart;
import edu.kist_bit.bookstore.services.exceptions.IllegalOrphanException;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author hams
 */
public class TableBookJpaController implements Serializable {

    public TableBookJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TableBook tableBook) {
        if (tableBook.getTableOrderList() == null) {
            tableBook.setTableOrderList(new ArrayList<TableOrder>());
        }
        if (tableBook.getTableCartList() == null) {
            tableBook.setTableCartList(new ArrayList<TableCart>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableAuthor authorId = tableBook.getAuthorId();
            if (authorId != null) {
                authorId = em.getReference(authorId.getClass(), authorId.getAId());
                tableBook.setAuthorId(authorId);
            }
            List<TableOrder> attachedTableOrderList = new ArrayList<TableOrder>();
            for (TableOrder tableOrderListTableOrderToAttach : tableBook.getTableOrderList()) {
                tableOrderListTableOrderToAttach = em.getReference(tableOrderListTableOrderToAttach.getClass(), tableOrderListTableOrderToAttach.getOId());
                attachedTableOrderList.add(tableOrderListTableOrderToAttach);
            }
            tableBook.setTableOrderList(attachedTableOrderList);
            List<TableCart> attachedTableCartList = new ArrayList<TableCart>();
            for (TableCart tableCartListTableCartToAttach : tableBook.getTableCartList()) {
                tableCartListTableCartToAttach = em.getReference(tableCartListTableCartToAttach.getClass(), tableCartListTableCartToAttach.getCaId());
                attachedTableCartList.add(tableCartListTableCartToAttach);
            }
            tableBook.setTableCartList(attachedTableCartList);
            em.persist(tableBook);
            if (authorId != null) {
                authorId.getTableBookList().add(tableBook);
                authorId = em.merge(authorId);
            }
            for (TableOrder tableOrderListTableOrder : tableBook.getTableOrderList()) {
                TableBook oldBookIdOfTableOrderListTableOrder = tableOrderListTableOrder.getBookId();
                tableOrderListTableOrder.setBookId(tableBook);
                tableOrderListTableOrder = em.merge(tableOrderListTableOrder);
                if (oldBookIdOfTableOrderListTableOrder != null) {
                    oldBookIdOfTableOrderListTableOrder.getTableOrderList().remove(tableOrderListTableOrder);
                    oldBookIdOfTableOrderListTableOrder = em.merge(oldBookIdOfTableOrderListTableOrder);
                }
            }
            for (TableCart tableCartListTableCart : tableBook.getTableCartList()) {
                TableBook oldBookIdOfTableCartListTableCart = tableCartListTableCart.getBookId();
                tableCartListTableCart.setBookId(tableBook);
                tableCartListTableCart = em.merge(tableCartListTableCart);
                if (oldBookIdOfTableCartListTableCart != null) {
                    oldBookIdOfTableCartListTableCart.getTableCartList().remove(tableCartListTableCart);
                    oldBookIdOfTableCartListTableCart = em.merge(oldBookIdOfTableCartListTableCart);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TableBook tableBook) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableBook persistentTableBook = em.find(TableBook.class, tableBook.getBId());
            TableAuthor authorIdOld = persistentTableBook.getAuthorId();
            TableAuthor authorIdNew = tableBook.getAuthorId();
            List<TableOrder> tableOrderListOld = persistentTableBook.getTableOrderList();
            List<TableOrder> tableOrderListNew = tableBook.getTableOrderList();
            List<TableCart> tableCartListOld = persistentTableBook.getTableCartList();
            List<TableCart> tableCartListNew = tableBook.getTableCartList();
            List<String> illegalOrphanMessages = null;
            for (TableOrder tableOrderListOldTableOrder : tableOrderListOld) {
                if (!tableOrderListNew.contains(tableOrderListOldTableOrder)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TableOrder " + tableOrderListOldTableOrder + " since its bookId field is not nullable.");
                }
            }
            for (TableCart tableCartListOldTableCart : tableCartListOld) {
                if (!tableCartListNew.contains(tableCartListOldTableCart)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TableCart " + tableCartListOldTableCart + " since its bookId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (authorIdNew != null) {
                authorIdNew = em.getReference(authorIdNew.getClass(), authorIdNew.getAId());
                tableBook.setAuthorId(authorIdNew);
            }
            List<TableOrder> attachedTableOrderListNew = new ArrayList<TableOrder>();
            for (TableOrder tableOrderListNewTableOrderToAttach : tableOrderListNew) {
                tableOrderListNewTableOrderToAttach = em.getReference(tableOrderListNewTableOrderToAttach.getClass(), tableOrderListNewTableOrderToAttach.getOId());
                attachedTableOrderListNew.add(tableOrderListNewTableOrderToAttach);
            }
            tableOrderListNew = attachedTableOrderListNew;
            tableBook.setTableOrderList(tableOrderListNew);
            List<TableCart> attachedTableCartListNew = new ArrayList<TableCart>();
            for (TableCart tableCartListNewTableCartToAttach : tableCartListNew) {
                tableCartListNewTableCartToAttach = em.getReference(tableCartListNewTableCartToAttach.getClass(), tableCartListNewTableCartToAttach.getCaId());
                attachedTableCartListNew.add(tableCartListNewTableCartToAttach);
            }
            tableCartListNew = attachedTableCartListNew;
            tableBook.setTableCartList(tableCartListNew);
            tableBook = em.merge(tableBook);
            if (authorIdOld != null && !authorIdOld.equals(authorIdNew)) {
                authorIdOld.getTableBookList().remove(tableBook);
                authorIdOld = em.merge(authorIdOld);
            }
            if (authorIdNew != null && !authorIdNew.equals(authorIdOld)) {
                authorIdNew.getTableBookList().add(tableBook);
                authorIdNew = em.merge(authorIdNew);
            }
            for (TableOrder tableOrderListNewTableOrder : tableOrderListNew) {
                if (!tableOrderListOld.contains(tableOrderListNewTableOrder)) {
                    TableBook oldBookIdOfTableOrderListNewTableOrder = tableOrderListNewTableOrder.getBookId();
                    tableOrderListNewTableOrder.setBookId(tableBook);
                    tableOrderListNewTableOrder = em.merge(tableOrderListNewTableOrder);
                    if (oldBookIdOfTableOrderListNewTableOrder != null && !oldBookIdOfTableOrderListNewTableOrder.equals(tableBook)) {
                        oldBookIdOfTableOrderListNewTableOrder.getTableOrderList().remove(tableOrderListNewTableOrder);
                        oldBookIdOfTableOrderListNewTableOrder = em.merge(oldBookIdOfTableOrderListNewTableOrder);
                    }
                }
            }
            for (TableCart tableCartListNewTableCart : tableCartListNew) {
                if (!tableCartListOld.contains(tableCartListNewTableCart)) {
                    TableBook oldBookIdOfTableCartListNewTableCart = tableCartListNewTableCart.getBookId();
                    tableCartListNewTableCart.setBookId(tableBook);
                    tableCartListNewTableCart = em.merge(tableCartListNewTableCart);
                    if (oldBookIdOfTableCartListNewTableCart != null && !oldBookIdOfTableCartListNewTableCart.equals(tableBook)) {
                        oldBookIdOfTableCartListNewTableCart.getTableCartList().remove(tableCartListNewTableCart);
                        oldBookIdOfTableCartListNewTableCart = em.merge(oldBookIdOfTableCartListNewTableCart);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tableBook.getBId();
                if (findTableBook(id) == null) {
                    throw new NonexistentEntityException("The tableBook with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableBook tableBook;
            try {
                tableBook = em.getReference(TableBook.class, id);
                tableBook.getBId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tableBook with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TableOrder> tableOrderListOrphanCheck = tableBook.getTableOrderList();
            for (TableOrder tableOrderListOrphanCheckTableOrder : tableOrderListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TableBook (" + tableBook + ") cannot be destroyed since the TableOrder " + tableOrderListOrphanCheckTableOrder + " in its tableOrderList field has a non-nullable bookId field.");
            }
            List<TableCart> tableCartListOrphanCheck = tableBook.getTableCartList();
            for (TableCart tableCartListOrphanCheckTableCart : tableCartListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TableBook (" + tableBook + ") cannot be destroyed since the TableCart " + tableCartListOrphanCheckTableCart + " in its tableCartList field has a non-nullable bookId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TableAuthor authorId = tableBook.getAuthorId();
            if (authorId != null) {
                authorId.getTableBookList().remove(tableBook);
                authorId = em.merge(authorId);
            }
            em.remove(tableBook);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TableBook> findTableBookEntities() {
        return findTableBookEntities(true, -1, -1);
    }

    public List<TableBook> findTableBookEntities(int maxResults, int firstResult) {
        return findTableBookEntities(false, maxResults, firstResult);
    }

    private List<TableBook> findTableBookEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TableBook.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TableBook findTableBook(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TableBook.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableBookCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TableBook> rt = cq.from(TableBook.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<TableBook> getCheapestBooks(){
        EntityManager em = getEntityManager();
        List <TableBook> books = null;
        try{
            books = (List<TableBook>) em.createNativeQuery(""
                + "SELECT * FROM table_book inner join table_author on table_book.author_id = table_author.a_id WHERE price <= 1000").getResultList();
        }catch(NoResultException ex){
            books = new ArrayList();
        }
        
        return books;
        
    }
    public List<TableBook> findCheapestBooks(){
        EntityManager em = getEntityManager();
        List <TableBook> books = null;
        try{
            books = (List<TableBook>) em.createNamedQuery("TableBook.findByCheapestBooks").setParameter("price", 1000).getResultList();
        }catch(NoResultException ex){
            books = new ArrayList();
        }
        
        return books;
        
    }
    public List<TableBook> findLatestBooks(){
        long timestamp = 1532516399000l; // 25 July 2018 10:59:59 UTC
        Date date = new Date(timestamp);
        EntityManager em = getEntityManager();
        List <TableBook> books = null;
        try{
            books = (List<TableBook>) em.createNamedQuery("TableBook.findByLatestBooks").setParameter("date",date).getResultList();
        }catch(NoResultException ex){
            books = new ArrayList();
        }
        
        return books;
        
    }
    
    public List<TableBook> findBooksByCategory(String cata){
        EntityManager em = getEntityManager();
        List <TableBook> books = null;
        try{
            books = (List<TableBook>) em.createNamedQuery("TableBook.findByCategories").setParameter("categories", cata).getResultList();
        }catch(NoResultException ex){
            books = new ArrayList();
        }
        
        return books;
        
    }
    
}
