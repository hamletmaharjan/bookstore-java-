/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.services;

import edu.kist_bit.bookstore.entity.TableAuthor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.services.exceptions.IllegalOrphanException;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author hams
 */
public class TableAuthorJpaController implements Serializable {

    public TableAuthorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TableAuthor tableAuthor) {
        if (tableAuthor.getTableBookList() == null) {
            tableAuthor.setTableBookList(new ArrayList<TableBook>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TableBook> attachedTableBookList = new ArrayList<TableBook>();
            for (TableBook tableBookListTableBookToAttach : tableAuthor.getTableBookList()) {
                tableBookListTableBookToAttach = em.getReference(tableBookListTableBookToAttach.getClass(), tableBookListTableBookToAttach.getBId());
                attachedTableBookList.add(tableBookListTableBookToAttach);
            }
            tableAuthor.setTableBookList(attachedTableBookList);
            em.persist(tableAuthor);
            for (TableBook tableBookListTableBook : tableAuthor.getTableBookList()) {
                TableAuthor oldAuthorIdOfTableBookListTableBook = tableBookListTableBook.getAuthorId();
                tableBookListTableBook.setAuthorId(tableAuthor);
                tableBookListTableBook = em.merge(tableBookListTableBook);
                if (oldAuthorIdOfTableBookListTableBook != null) {
                    oldAuthorIdOfTableBookListTableBook.getTableBookList().remove(tableBookListTableBook);
                    oldAuthorIdOfTableBookListTableBook = em.merge(oldAuthorIdOfTableBookListTableBook);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TableAuthor tableAuthor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableAuthor persistentTableAuthor = em.find(TableAuthor.class, tableAuthor.getAId());
            List<TableBook> tableBookListOld = persistentTableAuthor.getTableBookList();
            List<TableBook> tableBookListNew = tableAuthor.getTableBookList();
            List<String> illegalOrphanMessages = null;
            for (TableBook tableBookListOldTableBook : tableBookListOld) {
                if (!tableBookListNew.contains(tableBookListOldTableBook)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TableBook " + tableBookListOldTableBook + " since its authorId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TableBook> attachedTableBookListNew = new ArrayList<TableBook>();
            for (TableBook tableBookListNewTableBookToAttach : tableBookListNew) {
                tableBookListNewTableBookToAttach = em.getReference(tableBookListNewTableBookToAttach.getClass(), tableBookListNewTableBookToAttach.getBId());
                attachedTableBookListNew.add(tableBookListNewTableBookToAttach);
            }
            tableBookListNew = attachedTableBookListNew;
            tableAuthor.setTableBookList(tableBookListNew);
            tableAuthor = em.merge(tableAuthor);
            for (TableBook tableBookListNewTableBook : tableBookListNew) {
                if (!tableBookListOld.contains(tableBookListNewTableBook)) {
                    TableAuthor oldAuthorIdOfTableBookListNewTableBook = tableBookListNewTableBook.getAuthorId();
                    tableBookListNewTableBook.setAuthorId(tableAuthor);
                    tableBookListNewTableBook = em.merge(tableBookListNewTableBook);
                    if (oldAuthorIdOfTableBookListNewTableBook != null && !oldAuthorIdOfTableBookListNewTableBook.equals(tableAuthor)) {
                        oldAuthorIdOfTableBookListNewTableBook.getTableBookList().remove(tableBookListNewTableBook);
                        oldAuthorIdOfTableBookListNewTableBook = em.merge(oldAuthorIdOfTableBookListNewTableBook);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tableAuthor.getAId();
                if (findTableAuthor(id) == null) {
                    throw new NonexistentEntityException("The tableAuthor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableAuthor tableAuthor;
            try {
                tableAuthor = em.getReference(TableAuthor.class, id);
                tableAuthor.getAId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tableAuthor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TableBook> tableBookListOrphanCheck = tableAuthor.getTableBookList();
            for (TableBook tableBookListOrphanCheckTableBook : tableBookListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TableAuthor (" + tableAuthor + ") cannot be destroyed since the TableBook " + tableBookListOrphanCheckTableBook + " in its tableBookList field has a non-nullable authorId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tableAuthor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TableAuthor> findTableAuthorEntities() {
        return findTableAuthorEntities(true, -1, -1);
    }

    public List<TableAuthor> findTableAuthorEntities(int maxResults, int firstResult) {
        return findTableAuthorEntities(false, maxResults, firstResult);
    }

    private List<TableAuthor> findTableAuthorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TableAuthor.class));
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

    public TableAuthor findTableAuthor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TableAuthor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableAuthorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TableAuthor> rt = cq.from(TableAuthor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public TableAuthor findBooksById(Long id) throws NonexistentEntityException{
        EntityManager em = getEntityManager();
        TableAuthor results = null;
        try{
            results = (TableAuthor) em.createNamedQuery("TableAuthor.findByAId").setParameter("id", id).getSingleResult();
        }catch(NullPointerException | NoResultException e){
            throw new NonexistentEntityException("error");
        }
             
        return results;
        
    }
    
}
