package lk.ijse.aad.greenshadow.repository;

import lk.ijse.aad.greenshadow.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, String> {
}
