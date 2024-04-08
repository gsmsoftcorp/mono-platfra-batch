package com.gsm.platfra.api.data.platfraboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TPlatfraBoardRepository extends JpaRepository<TPlatfraBoard, Long> {
  Optional<TPlatfraBoard> findByPlatfraBoardSeq(Long platfraBoardId);
}
