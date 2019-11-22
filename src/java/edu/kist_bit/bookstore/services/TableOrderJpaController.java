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
import edu.kist_bit.bookstore.entity.TableCustomer;
import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.entity.TableOrder;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author hams
 */
public class TableOrderJpaController implements Serializable {

    public TableOrderJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TableOrder tableOrder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableCustomer customerId = tableOrder.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCId());
                tableOrder.setCustomerId(customerId);
            }
            TableBook bookId = tableOrder.getBookId();
            if (bookId != null) {
                bookId = em.getReference(bookId.getClass(), bookId.getBId());
                tableOrder.setBookId(bookId);
            }
            em.persist(tableOrder);
            if (customerId != null) {
                customerId.getTableOrderList().add(tableOrder);
                customerId = em.merge(customerId);
            }
            if (bookId != null) {
                bookId.getTableOrderList().add(tableOrder);
                bookId = em.merge(bookId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TableOrder tableOrder) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableOrder persistentTableOrder = em.find(TableOrder.class, tableOrder.getOId());
            TableCustomer customerIdOld = persistentTableOrder.getCustomerId();
            TableCustomer customerIdNew = tableOrder.getCustomerId();
            TableBook bookIdOld = persistentTableOrder.getBookId();
            TableBook bookIdNew = tableOrder.getBookId();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCId());
                tableOrder.setCustomerId(customerIdNew);
            }
            if (bookIdNew != null) {
                bookIdNew = em.getReference(bookIdNew.getClass(), bookIdNew.getBId());
                tableOrder.setBookId(bookIdNew);
            }
            tableOrder = em.merge(tableOrder);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getTableOrderList().remove(tableOrder);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getTableOrderList().add(tableOrder);
                customerIdNew = em.merge(customerIdNew);
            }
            if (bookIdOld != null && !bookIdOld.equals(bookIdNew)) {
                bookIdOld.getTableOrderList().remove(tableOrder);
                bookIdOld = em.merge(bookIdOld);
            }
            if (bookIdNew != null && !bookIdNew.equals(bookIdOld)) {
                bookIdNew.getTableOrderList().add(tableOrder);
                bookIdNew = em.merge(bookIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tableOrder.getOId();
                if (findTableOrder(id) == null) {
                    throw new NonexistentEntityException("The tableOrder with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableOrder tableOrder;
            try {
                tableOrder = em.getReference(TableOrder.class, id);
                tableOrder.getOId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tableOrder with id " + id + " no longer exists.", enfe);
            }
            TableCustomer customerId = tableOrder.getCustomerId();
            if (customerId != null) {
                customerId.getTableOrderList().remove(tableOrder);
                customerId = em.merge(customerId);
            }
            TableBook bookId = tableOrder.getBookId();
            if (bookId != null) {
                bookId.getTableOrderList().remove(tableOrder);
                bookId = em.merge(bookId);
            }
            em.remove(tableOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TableOrder> findTableOrderEntities() {
        return findTableOrderEntities(true, -1, -1);
    }

    public List<TableOrder> findTableOrderEntities(int maxResults, int firstResult) {
        return findTableOrderEntities(false, maxResults, firstResult);
    }

    private List<TableOrder> findTableOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TableOrder.class));
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

    public TableOrder findTableOrder(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TableOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TableOrder> rt = cq.from(TableOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
