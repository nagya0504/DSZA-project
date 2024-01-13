/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Modell;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nagya
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByFamilyName", query = "SELECT u FROM User u WHERE u.familyName = :familyName"),
    @NamedQuery(name = "User.findByGivenName", query = "SELECT u FROM User u WHERE u.givenName = :givenName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPwd", query = "SELECT u FROM User u WHERE u.pwd = :pwd"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByTown", query = "SELECT u FROM User u WHERE u.town = :town"),
    @NamedQuery(name = "User.findByRoleId", query = "SELECT u FROM User u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "User.findByCreatedAt", query = "SELECT u FROM User u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "User.findByLastLogin", query = "SELECT u FROM User u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "User.findByDeletedAt", query = "SELECT u FROM User u WHERE u.deletedAt = :deletedAt")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "family_name")
    private String familyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "given_name")
    private String givenName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "pwd")
    private String pwd;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "town")
    private String town;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private int roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
    
    public User(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(Integer id, String username, String familyName, String givenName, String email, String phone, String town, int roleId) {
        this.id = id;
        this.username = username;
        this.familyName = familyName;
        this.givenName = givenName;
        this.email = email;
        this.phone = phone;
        this.town = town;
        this.roleId = roleId;
    }
    
    

    public User(Integer id, String username, String familyName, String givenName, String email, String pwd, String phone, String town, int roleId, Date createdAt, Date lastLogin) {
        this.id = id;
        this.username = username;
        this.familyName = familyName;
        this.givenName = givenName;
        this.email = email;
        this.pwd = pwd;
        this.phone = phone;
        this.town = town;
        this.roleId = roleId;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bookmark.bookmark.Modell.User[ id=" + id + " ]";
    }
    
    public static boolean login(String email, String pwd) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("login");
            spq.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN);
            
            spq.setParameter("email", email);
            spq.setParameter("pwd", pwd);
            
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
    
    public static boolean addUser(String username, String familyName, String givenName, String email, String pwd, String phone, String town) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addUser");
            spq.registerStoredProcedureParameter("username", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("familyName", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("givenName", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phone", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("town", String.class, ParameterMode.IN);
            
            spq.setParameter("username", username);
            spq.setParameter("familyName", familyName);
            spq.setParameter("givenName", givenName);
            spq.setParameter("email", email);
            spq.setParameter("pwd", pwd);
            spq.setParameter("phone", phone);
            spq.setParameter("town", town);
            
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
    
    public static boolean addAdmin(String username, String familyName, String givenName, String email, String pwd, String phone, String town) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addAdmin");
            spq.registerStoredProcedureParameter("username", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("familyName", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("givenName", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phone", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("town", String.class, ParameterMode.IN);
            
            spq.setParameter("username", username);
            spq.setParameter("familyName", familyName);
            spq.setParameter("givenName", givenName);
            spq.setParameter("email", email);
            spq.setParameter("pwd", pwd);
            spq.setParameter("phone", phone);
            spq.setParameter("town", town);
            
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
    
    public static boolean deleteUser(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteUser");
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
    
    public static boolean selectAllUser() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("selectAllUser");
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
    
    public static boolean selectAllAdmin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("selectAllAdmin");
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
    
    public static boolean updateUserPassword(Integer id, String pwd) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUserPassword");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("pwd", pwd);
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
    
    public static boolean updateUserPhone(Integer id, String phone) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUserPhone");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phone", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("phone", phone);
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
    
    public static boolean updateUserTown(Integer id, String town) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUserTown");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("town", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("town", town);
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
    
    public static boolean updateUserUsername(Integer id, String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUserUsername");
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("username", String.class, ParameterMode.IN);
            spq.setParameter("id", id);
            spq.setParameter("username", username);
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
    
    public static boolean logDeleteUser(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("logDeleteUser");
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
    
    public static User selectUserByEmail(String email, String pwd) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bookmark_bookmark_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("selectUserByEmail");
            spq.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("username", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("familyName", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("givenName", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("emailOUT", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("phone", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("town", String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter("role", Integer.class, ParameterMode.OUT);
            spq.setParameter("email", email);
            spq.setParameter("pwd", pwd);
            spq.execute();
            Integer id = (Integer) spq.getOutputParameterValue("id");
            String username = (String) spq.getOutputParameterValue("username");
            String familyName = (String) spq.getOutputParameterValue("familyName");
            String givenName = (String) spq.getOutputParameterValue("givenName");
            String emailOUT = (String) spq.getOutputParameterValue("emailOUT");
            String phone = (String) spq.getOutputParameterValue("phone");
            String town = (String) spq.getOutputParameterValue("town");
            Integer role = (Integer) spq.getOutputParameterValue("role");
            User u = new User(id, username, familyName, givenName, emailOUT, phone, town, role);
            return u;
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
