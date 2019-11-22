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
import edu.kist_bit.bookstore.entity.TableOrder;
import java.util.ArrayList;
import java.util.List;
import edu.kist_bit.bookstore.entity.TableCart;
import edu.kist_bit.bookstore.entity.TableCustomer;
import edu.kist_bit.bookstore.services.exceptions.IllegalOrphanException;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author hams
 */
public class TableCustomerJpaController implements Serializable {


    

    public TableCustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TableCustomer tableCustomer) {
        if (tableCustomer.getTableOrderList() == null) {
            tableCustomer.setTableOrderList(new ArrayList<TableOrder>());
        }
        if (tableCustomer.getTableCartList() == null) {
            tableCustomer.setTableCartList(new ArrayList<TableCart>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TableOrder> attachedTableOrderList = new ArrayList<TableOrder>();
            for (TableOrder tableOrderListTableOrderToAttach : tableCustomer.getTableOrderList()) {
                tableOrderListTableOrderToAttach = em.getReference(tableOrderListTableOrderToAttach.getClass(), tableOrderListTableOrderToAttach.getOId());
                attachedTableOrderList.add(tableOrderListTableOrderToAttach);
            }
            tableCustomer.setTableOrderList(attachedTableOrderList);
            List<TableCart> attachedTableCartList = new ArrayList<TableCart>();
            for (TableCart tableCartListTableCartToAttach : tableCustomer.getTableCartList()) {
                tableCartListTableCartToAttach = em.getReference(tableCartListTableCartToAttach.getClass(), tableCartListTableCartToAttach.getCaId());
                attachedTableCartList.add(tableCartListTableCartToAttach);
            }
            tableCustomer.setTableCartList(attachedTableCartList);
            em.persist(tableCustomer);
            for (TableOrder tableOrderListTableOrder : tableCustomer.getTableOrderList()) {
                TableCustomer oldCustomerIdOfTableOrderListTableOrder = tableOrderListTableOrder.getCustomerId();
                tableOrderListTableOrder.setCustomerId(tableCustomer);
                tableOrderListTableOrder = em.merge(tableOrderListTableOrder);
                if (oldCustomerIdOfTableOrderListTableOrder != null) {
                    oldCustomerIdOfTableOrderListTableOrder.getTableOrderList().remove(tableOrderListTableOrder);
                    oldCustomerIdOfTableOrderListTableOrder = em.merge(oldCustomerIdOfTableOrderListTableOrder);
                }
            }
            for (TableCart tableCartListTableCart : tableCustomer.getTableCartList()) {
                TableCustomer oldCustomerIdOfTableCartListTableCart = tableCartListTableCart.getCustomerId();
                tableCartListTableCart.setCustomerId(tableCustomer);
                tableCartListTableCart = em.merge(tableCartListTableCart);
                if (oldCustomerIdOfTableCartListTableCart != null) {
                    oldCustomerIdOfTableCartListTableCart.getTableCartList().remove(tableCartListTableCart);
                    oldCustomerIdOfTableCartListTableCart = em.merge(oldCustomerIdOfTableCartListTableCart);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TableCustomer tableCustomer) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TableCustomer persistentTableCustomer = em.find(TableCustomer.class, tableCustomer.getCId());
            List<TableOrder> tableOrderListOld = persistentTableCustomer.getTableOrderList();
            List<TableOrder> tableOrderListNew = tableCustomer.getTableOrderList();
            List<TableCart> tableCartListOld = persistentTableCustomer.getTableCartList();
            List<TableCart> tableCartListNew = tableCustomer.getTableCartList();
            List<String> illegalOrphanMessages = null;
            for (TableOrder tableOrderListOldTableOrder : tableOrderListOld) {
                if (!tableOrderListNew.contains(tableOrderListOldTableOrder)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TableOrder " + tableOrderListOldTableOrder + " since its customerId field is not nullable.");
                }
            }
            for (TableCart tableCartListOldTableCart : tableCartListOld) {
                if (!tableCartListNew.contains(tableCartListOldTableCart)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TableCart " + tableCartListOldTableCart + " since its customerId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TableOrder> attachedTableOrderListNew = new ArrayList<TableOrder>();
            for (TableOrder tableOrderListNewTableOrderToAttach : tableOrderListNew) {
                tableOrderListNewTableOrderToAttach = em.getReference(tableOrderListNewTableOrderToAttach.getClass(), tableOrderListNewTableOrderToAttach.getOId());
                attachedTableOrderListNew.add(tableOrderListNewTableOrderToAttach);
            }
            tableOrderListNew = attachedTableOrderListNew;
            tableCustomer.setTableOrderList(tableOrderListNew);
            List<TableCart> attachedTableCartListNew = new ArrayList<TableCart>();
            for (TableCart tableCartListNewTableCartToAttach : tableCartListNew) {
                tableCartListNewTableCartToAttach = em.getReference(tableCartListNewTableCartToAttach.getClass(), tableCartListNewTableCartToAttach.getCaId());
                attachedTableCartListNew.add(tableCartListNewTableCartToAttach);
            }
            tableCartListNew = attachedTableCartListNew;
            tableCustomer.setTableCartList(tableCartListNew);
            tableCustomer = em.merge(tableCustomer);
            for (TableOrder tableOrderListNewTableOrder : tableOrderListNew) {
                if (!tableOrderListOld.contains(tableOrderListNewTableOrder)) {
                    TableCustomer oldCustomerIdOfTableOrderListNewTableOrder = tableOrderListNewTableOrder.getCustomerId();
                    tableOrderListNewTableOrder.setCustomerId(tableCustomer);
                    tableOrderListNewTableOrder = em.merge(tableOrderListNewTableOrder);
                    if (oldCustomerIdOfTableOrderListNewTableOrder != null && !oldCustomerIdOfTableOrderListNewTableOrder.equals(tableCustomer)) {
                        oldCustomerIdOfTableOrderListNewTableOrder.getTableOrderList().remove(tableOrderListNewTableOrder);
                        oldCustomerIdOfTableOrderListNewTableOrder = em.merge(oldCustomerIdOfTableOrderListNewTableOrder);
                    }
                }
            }
            for (TableCart tableCartListNewTableCart : tableCartListNew) {
                if (!tableCartListOld.contains(tableCartListNewTableCart)) {
                    TableCustomer oldCustomerIdOfTableCartListNewTableCart = tableCartListNewTableCart.getCustomerId();
                    tableCartListNewTableCart.setCustomerId(tableCustomer);
                    tableCartListNewTableCart = em.merge(tableCartListNewTableCart);
                    if (oldCustomerIdOfTableCartListNewTableCart != null && !oldCustomerIdOfTableCartListNewTableCart.equals(tableCustomer)) {
                        oldCustomerIdOfTableCartListNewTableCart.getTableCartList().remove(tableCartListNewTableCart);
                        oldCustomerIdOfTableCartListNewTableCart = em.merge(oldCustomerIdOfTableCartListNewTableCart);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tableCustomer.getCId();
                if (findTableCustomer(id) == null) {
                    throw new NonexistentEntityException("The tableCustomer with id " + id + " no longer exists.");
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
            TableCustomer tableCustomer;
            try {
                tableCustomer = em.getReference(TableCustomer.class, id);
                tableCustomer.getCId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tableCustomer with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TableOrder> tableOrderListOrphanCheck = tableCustomer.getTableOrderList();
            for (TableOrder tableOrderListOrphanCheckTableOrder : tableOrderListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TableCustomer (" + tableCustomer + ") cannot be destroyed since the TableOrder " + tableOrderListOrphanCheckTableOrder + " in its tableOrderList field has a non-nullable customerId field.");
            }
            List<TableCart> tableCartListOrphanCheck = tableCustomer.getTableCartList();
            for (TableCart tableCartListOrphanCheckTableCart : tableCartListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TableCustomer (" + tableCustomer + ") cannot be destroyed since the TableCart " + tableCartListOrphanCheckTableCart + " in its tableCartList field has a non-nullable customerId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tableCustomer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TableCustomer> findTableCustomerEntities() {
        return findTableCustomerEntities(true, -1, -1);
    }

    public List<TableCustomer> findTableCustomerEntities(int maxResults, int firstResult) {
        return findTableCustomerEntities(false, maxResults, firstResult);
    }

    private List<TableCustomer> findTableCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TableCustomer.class));
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

    public TableCustomer findTableCustomer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TableCustomer.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TableCustomer> rt = cq.from(TableCustomer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public TableCustomer checkLogin(String email) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        TableCustomer results = null;
        try{
            results = (TableCustomer) em.createNamedQuery("TableCustomer.findByCEmail").setParameter("email", email).getSingleResult();
        }catch(NullPointerException | NoResultException e){
            throw new NonexistentEntityException("the users with username"+email+"no longer eixst");
        }
             
        return results;
        
    }
   
    
}
