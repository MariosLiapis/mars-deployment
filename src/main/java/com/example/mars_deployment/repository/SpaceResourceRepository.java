package com.example.mars_deployment.repository;

import com.example.mars_deployment.model.SpaceResources;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpaceResourceRepository extends JpaRepository<SpaceResources, Long> {

}
