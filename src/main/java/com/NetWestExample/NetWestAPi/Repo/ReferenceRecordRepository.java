package com.NetWestExample.NetWestAPi.Repo;

import com.NetWestExample.NetWestAPi.Entity.ReferenceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRecordRepository extends JpaRepository<ReferenceRecord,Long> {
}
