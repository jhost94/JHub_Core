package com.jhost.core.Core.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "soc_key")
public class Key {

    @Id
    @Column(name = "key_str", nullable = false, length = 400)
    private String keyStr;

    private Long userId;

    private Date createdAt;

    private Date lastUsed;

}
