package entitiy;
// Generated May 16, 2019 8:48:15 AM by Hibernate Tools 4.3.1



/**
 * Berita generated by hbm2java
 */
public class Berita  implements java.io.Serializable {


     private Integer id;
     private String judul;
     private String topik;
     private String tanggal;
     private String deskripsi;

    public Berita() {
    }

    public Berita(String judul, String topik, String tanggal, String deskripsi) {
       this.judul = judul;
       this.topik = topik;
       this.tanggal = tanggal;
       this.deskripsi = deskripsi;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getJudul() {
        return this.judul;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getTopik() {
        return this.topik;
    }
    
    public void setTopik(String topik) {
        this.topik = topik;
    }
    public String getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getDeskripsi() {
        return this.deskripsi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }




}

