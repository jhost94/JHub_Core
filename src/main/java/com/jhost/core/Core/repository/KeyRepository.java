package com.jhost.core.Core.repository;

import com.jhost.core.Core.entity.Key;
import org.springframework.data.repository.CrudRepository;

public interface KeyRepository extends CrudRepository<Key, String> {

    Key findByKeyStrAndUserId(String key, Long userid);

}
