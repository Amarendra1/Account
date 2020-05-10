package com.capg.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pecunia.entity.AccountBean;



public interface IAccountRepo extends JpaRepository< AccountBean, Long>{

}