package com.example.springjpahello.entity;

import com.example.springjpahello.customjson.CustomListSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@NamedQueries(value={
        @NamedQuery(name = "User.findAllOrderedDescending",
                query = "SELECT c FROM User c ORDER BY c.firstname DESC"),
        @NamedQuery(name = "User.findFistAndLast", query = "SELECT a FROM User a WHERE a.firstname = ?1 AND a.lastname = ?2")
})

@NamedNativeQuery(name = "User.findByFirstName", query = "SELECT * FROM user_table WHERE firstname = ?", resultClass = User.class)

        @Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({ "firstname", "id" })
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonRootName(value = "Userdemo",namespace = "Userdemos")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(name = "user_table")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @Size(min=2, max=30)
    @Column(name = "firstname")
    private String firstname;

    @NotBlank
    @JsonProperty("last_name")
    @Column(name = "lastname")
    private String lastname;

    @JsonIgnore
    @Min(value =18,  message = "Age should not be less than 18")
    private int age;
    //private boolean active;

    @Email(message = "provide valid email addess")
    @Column(name="email_address",nullable = false, unique = true)
    private String emailAddress;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> colleagues;

    @ManyToOne
    @JsonSerialize(using = CustomListSerializer.class)
    @JoinColumn(name = "manager_eid")
    private User manager;

    @Embedded
    private Address address;

    @Lob
    private byte[] binaryData;

    @ElementCollection
    private Set<String> attributes;

    @ElementCollection
    @CollectionTable(name = "map_attribute",joinColumns = @JoinColumn(name="test_id"))
    private Map<String,User> attributesMap=new HashMap<>();

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.DATE)
    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @JsonFormat(locale = "fr")
    @CreationTimestamp
    LocalDateTime creationTime;
    @UpdateTimestamp
    LocalDateTime updationTime;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}