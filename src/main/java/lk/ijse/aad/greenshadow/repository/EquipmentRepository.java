package lk.ijse.aad.greenshadow.repository;

import lk.ijse.aad.greenshadow.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, String> {
}
