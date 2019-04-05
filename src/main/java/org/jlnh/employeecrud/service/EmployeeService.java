package org.jlnh.employeecrud.service;

import java.util.List;
import java.util.Optional;

import org.jlnh.employeecrud.entity.EmployeeEntity;
import org.jlnh.employeecrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	public List<EmployeeEntity> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	public EmployeeEntity findById(int theId) {
		Optional<EmployeeEntity> result = employeeRepository.findById(theId);

		EmployeeEntity theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;
	}

	public void save(EmployeeEntity theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
