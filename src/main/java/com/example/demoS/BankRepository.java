package com.example.demoS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

}

