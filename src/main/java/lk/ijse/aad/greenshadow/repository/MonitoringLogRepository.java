package lk.ijse.aad.greenshadow.repository;

import lk.ijse.aad.greenshadow.entity.MonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringLogRepository extends JpaRepository<MonitoringLog, String> {
}
