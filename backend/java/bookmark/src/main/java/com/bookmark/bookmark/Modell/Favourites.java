/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Modell;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nagya
 */
@Entity
@Table(name = "favourites")
@NamedQueries({
    @NamedQuery(name = "Favourites.findAll", query = "SELECT f FROM Favourites f"),
    @NamedQuery(name = "Favourites.findById", query = "SELECT f FROM Favourites f WHERE f.id = :id"),
    @NamedQuery(name = "Favourites.findByUserId", query = "SELECT f FROM Favourites f WHERE f.userId = :userId"),
    @NamedQuery(name = "Favourites.findByProductId", query = "SELECT f FROM Favourites f WHERE f.productId = :productId")})
public class Favourites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;

    public Favourites() {
    }

    public Favourites(Integer id) {
        this.id = id;
    }

    public Favourites(Integer id, int userId, int productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        if (!(object instanceof Favourites)) {
            return false;
        }
        Favourites other = (Favourites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bookmark.bookmark.Modell.Favourites[ id=" + id + " ]";
    }
    
    public static boolean addFav(Integer userId, Integer productId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addFav");
            spq.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("productId", Integer.class, ParameterMode.IN);
            
            spq.setParameter("userId", userId);
            spq.setParameter("productId", productId);
            
            spq.execute();
            return true;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static boolean deleteFav(Integer userId, Integer bookId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteFav");
            spq.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("bookId", Integer.class, ParameterMode.IN);
            
            spq.setParameter("userId", userId);
            spq.setParameter("bookId", bookId);
            
            spq.execute();
            return true;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static List<Favourites> selectAllFav(Integer userId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("selectAllFav");
            spq.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN);
            
            spq.setParameter("userId", userId);
            
            spq.execute();
            
            List<Favourites> resultList = spq.getResultList();
            return resultList;
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
}
