package com.neo.v1.repository;

import com.neo.v1.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends JpaRepository<Unit,Integer> {

}
