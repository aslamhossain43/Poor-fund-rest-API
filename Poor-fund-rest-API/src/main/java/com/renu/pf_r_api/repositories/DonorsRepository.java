package com.renu.pf_r_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.pf_r_api.models.Donors;

public interface DonorsRepository extends JpaRepository<Donors,Long>,JpaSpecificationExecutor<Donors> {

}
