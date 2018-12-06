package com.renu.pf_r_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.pf_r_api.models.AdminFile;

public interface AdminFileRepository extends JpaRepository<AdminFile, Long>,JpaSpecificationExecutor<AdminFileRepository> {

}
