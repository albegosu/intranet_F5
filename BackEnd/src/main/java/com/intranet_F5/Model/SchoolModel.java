package com.intranet_F5.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Entity
@Table(name = "School")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
public class SchoolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;

    @Column(name = "Name")
    private String schoolName;

    @Column(name = "Email")
    private String schoolEmail;

    @Column(name = "Phone")
    private String schoolPhone;

    @Column(name = "City")
    private String schoolCity;

    @OneToMany(mappedBy = "SchoolID",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("SchoolID")
    private List<UserModel> schoolsList;
}