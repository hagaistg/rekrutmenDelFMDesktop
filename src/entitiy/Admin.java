package entitiy;
// Generated May 16, 2019 8:48:15 AM by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin  implements java.io.Serializable {


     private int id;
     private String username;
     private String password;

    public Admin() {
    }

	
    public Admin(int id) {
        this.id = id;
    }
    public Admin(int id, String username, String password) {
       this.id = id;
       this.username = username;
       this.password = password;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}

