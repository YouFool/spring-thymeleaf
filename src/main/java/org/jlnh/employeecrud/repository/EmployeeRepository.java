package org.jlnh.employeecrud.repository;

import java.util.List;

import org.jlnh.employeecrud.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	public List<EmployeeEntity> findAllByOrderByLastNameAsc();
	
}
