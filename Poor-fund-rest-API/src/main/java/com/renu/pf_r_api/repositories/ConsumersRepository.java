package com.renu.pf_r_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.pf_r_api.models.Consumers;

public interface ConsumersRepository extends JpaRepository<Consumers, Long>,JpaSpecificationExecutor<Consumers> {
Consumers getById(Long id);
}
