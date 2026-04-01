package employees.controllers;


import employees.Repository.EmployeesRepo;
import employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
public class TestController {
@Autowired
private EmployeesRepo employeesRepo;
	//private List<Employee> employees = createList();

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return employeesRepo.findAll();
	}


	@PutMapping("/update")
	public List<Employee> updateemployer( @RequestBody Employee employee)
	{
		employeesRepo.save(employee);
		return  employeesRepo.findAll();

	}
	@PostMapping("/add")
	public List<Employee> addemployer( @RequestBody Employee employee)
	{
		employeesRepo.save(employee);
		return  employeesRepo.findAll();
	}
	@DeleteMapping("/delete/{empid}")
	public  void deleteemployer(@PathVariable("empid") final String empid)
	{
		employeesRepo.deleteById(empid);
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> version() {
		String version = System.getenv("BUILD_VERSION");
		Map<String, Object> v = new HashMap<>();
		v.put("version", version != null? version: "unknown");
		return v;

	}
	
	/*private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("Devops Junior");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("Devops Senior");
		emp2.setEmpId("2");
		emp2.setSalary(4500);
		
		Employee emp3 = new Employee();
		emp3.setName("emp3");
		emp3.setDesignation("devops architect");
		emp3.setEmpId("3");
		emp3.setSalary(6000);
		
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		tempEmployees.add(emp3);
		return tempEmployees;
		
	}

	 */

}
