package hieukientung.booktour.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_account", schema = "book_tour")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 50)
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Size(max = 100)
    @NotNull
    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Size(max = 100)
    @NotNull
    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @Size(max = 10)
    @Column(name = "phone", length = 10)
    private String phone;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "birthday")
    private Instant birthday;

    @Size(max = 150)
    @Column(name = "address", length = 150)
    private String address;

    @Size(max = 5)
    @Column(name = "sex", length = 5)
    private String sex;

    @Lob
    @Column(name = "image")
    private String image;

}