package lk.ijse.aad.greenshadow.repository;

import lk.ijse.aad.greenshadow.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, String> {
}
