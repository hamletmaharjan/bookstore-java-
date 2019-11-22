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
import edu.kist_bit.bookstore.entity.TableCart;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author hams
 */
public class TableCartJpaController implements Serializable {

    public TableCartJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TableCart tableCart) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableCustomer customerId = tableCart.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCId());
                tableCart.setCustomerId(customerId);
            }
            TableBook bookId = tableCart.getBookId();
            if (bookId != null) {
                bookId = em.getReference(bookId.getClass(), bookId.getBId());
                tableCart.setBookId(bookId);
            }
            em.persist(tableCart);
            if (customerId != null) {
                customerId.getTableCartList().add(tableCart);
                customerId = em.merge(customerId);
            }
            if (bookId != null) {
                bookId.getTableCartList().add(tableCart);
                bookId = em.merge(bookId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TableCart tableCart) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableCart persistentTableCart = em.find(TableCart.class, tableCart.getCaId());
            TableCustomer customerIdOld = persistentTableCart.getCustomerId();
            TableCustomer customerIdNew = tableCart.getCustomerId();
            TableBook bookIdOld = persistentTableCart.getBookId();
            TableBook bookIdNew = tableCart.getBookId();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCId());
                tableCart.setCustomerId(customerIdNew);
            }
            if (bookIdNew != null) {
                bookIdNew = em.getReference(bookIdNew.getClass(), bookIdNew.getBId());
                tableCart.setBookId(bookIdNew);
            }
            tableCart = em.merge(tableCart);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getTableCartList().remove(tableCart);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getTableCartList().add(tableCart);
                customerIdNew = em.merge(customerIdNew);
            }
            if (bookIdOld != null && !bookIdOld.equals(bookIdNew)) {
                bookIdOld.getTableCartList().remove(tableCart);
                bookIdOld = em.merge(bookIdOld);
            }
            if (bookIdNew != null && !bookIdNew.equals(bookIdOld)) {
                bookIdNew.getTableCartList().add(tableCart);
                bookIdNew = em.merge(bookIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tableCart.getCaId();
                if (findTableCart(id) == null) {
                    throw new NonexistentEntityException("The tableCart with id " + id + " no longer exists.");
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
            TableCart tableCart;
            try {
                tableCart = em.getReference(TableCart.class, id);
                tableCart.getCaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tableCart with id " + id + " no longer exists.", enfe);
            }
            TableCustomer customerId = tableCart.getCustomerId();
            if (customerId != null) {
                customerId.getTableCartList().remove(tableCart);
                customerId = em.merge(customerId);
            }
            TableBook bookId = tableCart.getBookId();
            if (bookId != null) {
                bookId.getTableCartList().remove(tableCart);
                bookId = em.merge(bookId);
            }
            em.remove(tableCart);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TableCart> findTableCartEntities() {
        return findTableCartEntities(true, -1, -1);
    }

    public List<TableCart> findTableCartEntities(int maxResults, int firstResult) {
        return findTableCartEntities(false, maxResults, firstResult);
    }

    private List<TableCart> findTableCartEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TableCart.class));
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

    public TableCart findTableCart(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TableCart.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableCartCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TableCart> rt = cq.from(TableCart.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
