package com.NetWestExample.NetWestAPi.Repo;

import com.NetWestExample.NetWestAPi.Entity.OutputRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputRecordRepository extends JpaRepository<OutputRecord,Long> {
}
