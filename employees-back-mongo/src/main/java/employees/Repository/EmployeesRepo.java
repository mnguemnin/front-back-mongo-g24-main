package employees.Repository;

import employees.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeesRepo extends MongoRepository<Employee, String>
{

}
