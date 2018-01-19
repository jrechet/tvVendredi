
package tpConnexion;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.persistence.*;

@ManagedBean
@RequestScoped
//@Entity
//@Table
public class User {

//
    private Long id;

  //  @Column
    private String mail;

  //  @Column
    private String password;

    public User() {
    }

    public String getmail() {
        return mail;
    }

    public void setEmail(String name) {
        this.mail = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String surname) {
        this.password = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
