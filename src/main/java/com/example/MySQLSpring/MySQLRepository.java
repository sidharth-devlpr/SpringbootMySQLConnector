package com.example.MySQLSpring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MySQLRepository extends JpaRepository<Person,Integer> {
}
