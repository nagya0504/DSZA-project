/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Modell;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nagya
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByUserId", query = "SELECT p FROM Product p WHERE p.userId = :userId"),
    @NamedQuery(name = "Product.findByTitle", query = "SELECT p FROM Product p WHERE p.title = :title"),
    @NamedQuery(name = "Product.findByAuthor", query = "SELECT p FROM Product p WHERE p.author = :author"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByImage", query = "SELECT p FROM Product p WHERE p.image = :image"),
    @NamedQuery(name = "Product.findByStatusId", query = "SELECT p FROM Product p WHERE p.statusId = :statusId"),
    @NamedQuery(name = "Product.findByCreatedAt", query = "SELECT p FROM Product p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Product.findByDeletedAt", query = "SELECT p FROM Product p WHERE p.deletedAt = :deletedAt")})
public class Product implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, int userId, String title, String author, int price, String description, String image) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image = image;
    }
    
    

    public Product(Integer id, int userId, String title, String author, int price, String description, int statusId, Date createdAt, Date deletedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bookmark.bookmark.Modell.Product[ id=" + id + " ]";
    }
    
    public static boolean addBook(Integer user_id, String title, String author, Integer price, String description, String image) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addBook");
            spq.registerStoredProcedureParameter("user_id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("title", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("author", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("price", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("image", String.class, ParameterMode.IN);
            
            spq.setParameter("user_id", user_id);
            spq.setParameter("title", title);
            spq.setParameter("author", author);
            spq.setParameter("price", price);
            spq.setParameter("description", description);
            spq.setParameter("image", image);
            
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
    
    public static boolean deleteBook(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteBook");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.setParameter("id", id);
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
    
    public static List<Product> orderBooksAZ() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("orderBooksAZ", Product.class);
            spq.execute();

            List<Product> resultList = spq.getResultList();

            return resultList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null; 
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static boolean orderBooksZA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("orderBooksZA");
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
    
    public static List<Product> orderBooksAsc() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("orderBooksAsc", Product.class);
            spq.execute();

            List<Product> resultList = spq.getResultList();

            return resultList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null; 
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static List<Product> orderBooksDesc() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("orderBooksDesc", Product.class);
            spq.execute();

            List<Product> resultList = spq.getResultList();

            return resultList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null; 
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static List<Product> selectAllBooks() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("selectAllBooks", Product.class);
            spq.execute();

            List<Product> resultList = spq.getResultList();

            return resultList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null; 
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }

    
    public static Product selectProduct(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("selectProduct");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("idOUT", Integer.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("title", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("author", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("price", Integer.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("description", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("img", String.class, ParameterMode.OUT);
            spq.setParameter("id", id);
            spq.execute();
            Integer idOUT = (Integer) spq.getOutputParameterValue("idOUT");
            Integer userId = (Integer) spq.getOutputParameterValue("userId");
            String title = (String) spq.getOutputParameterValue("title");
            String author = (String) spq.getOutputParameterValue("author");
            Integer price = (Integer) spq.getOutputParameterValue("price");
            String description = (String) spq.getOutputParameterValue("description");
            String img = (String) spq.getOutputParameterValue("img");
            Product p = new Product(idOUT, userId, title, author, price, description, img);
            return p;
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
    
    public static boolean updateBookAuthor(Integer id, String author) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBookAuthor");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("author", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("author", author);
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
    
    public static boolean updateBookDesc(Integer id, String description) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBookDesc");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("description", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("description", description);
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
    
    public static boolean updateBookImg(Integer id, String newImg) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBookImg");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newImg", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("newImg", newImg);
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
    
    public static boolean updateBookPrice(Integer id, Integer price) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBookPrice");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("price", Integer.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("price", price);
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
    
    public static boolean updateBookStatus(Integer id, Integer newStatus) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBookStatus");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newStatus", Integer.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("newStatus", newStatus);
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
    
    public static boolean updateBookTitle(Integer id, String title) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBookTitle");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("title", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("title", title);
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
    
    public static boolean logDeleteBook(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("logDeleteBook");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.setParameter("id", id);
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
    
}
