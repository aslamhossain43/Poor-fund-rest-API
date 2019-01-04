package com.renu.pf_r_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renu.pf_r_api.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
// deleted by id
	Staff getById(Long id);
}
