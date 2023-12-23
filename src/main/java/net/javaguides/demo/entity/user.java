package net.javaguides.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor

@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "users")

public class user
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String email;



    public String getFirstName()
    {
        return firstname ;
    }

    public String  getLastName()
    {
        return lastname;
    }
    public String getEmail()
    {
        return  email;
    }
    public void setFirstName(String firstname)
    {
        this.firstname=firstname;
    }

    public void setLastName(String lastname)
    {
        this.lastname=lastname;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

}
