package com.NetWestExample.NetWestAPi.Repo;

import com.NetWestExample.NetWestAPi.Entity.InputRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRecordRepository extends JpaRepository<InputRecord,Long> {
}
