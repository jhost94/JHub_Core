package com.jhost.core.Core.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Table(name = "soc_user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String email;

    private Date creationDate;

    private String password;

    private Boolean isActive;
}
