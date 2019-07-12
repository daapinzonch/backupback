package com.redcampo.app.Repository;

import com.redcampo.app.Entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepo extends JpaRepository<Deal, Long> {
}
