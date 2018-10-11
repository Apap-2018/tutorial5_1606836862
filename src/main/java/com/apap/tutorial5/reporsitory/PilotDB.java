package com.apap.tutorial5.reporsitory;

import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.PilotModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PilotDB extends JpaRepository<PilotModel, Long> {
	PilotModel findByLicenseNumber(String licenseNumber);
}