package com.telbook.demo.dao;

import com.telbook.demo.entity.person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<person,Long> {
    List<person> findByName(String name);
    List<person> findByTel(String tel);
}
