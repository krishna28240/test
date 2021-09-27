Design changes done
1.In the project done modifications in the EmployeeRepository to extends from jpaRepository instead of crudRepository because
in future if want to provide the pagination support it is better it use it now.
2. in the controller class getMapping annotation should have short path and https methods should have
 specific path to perform business logic, it is recommended to have all the http method should have same path because we need to specify
 method type in RestController annotation class unlike controller annotation

# As per the instruction in the documents, have been added the below endpoints to fetch all employees, update an employee and find employee by firstName or lastName

Task 1: REST end point to list all the employees
Endpoint=http://localhost:8080/v/1.0/employees
Method=GET
Response :
[{"userId":"001000","firstName":"Krishna","lastName":"Chavan"},{"userId":"001001","firstName":"Audrey","lastName":"Hepburn"},{"userId":"001002","firstName":"Kim","lastName":"Kardashian"},{"userId":"001003","firstName":"Will","lastName":"Smith"},{"userId":"001004","firstName":"Franklin","lastName":"Roosevelt"},{"userId":"001005","firstName":"Harry","lastName":"Truman"},{"userId":"001006","firstName":"Dwight","lastName":"Eisenhower"},{"userId":"001007","firstName":"John","lastName":"Kennedy"},{"userId":"001008","firstName":"Tom","lastName":"Cruise"},{"userId":"001009","firstName":"Richard","lastName":"Nixon"},{"userId":"001010","firstName":"Gerald","lastName":"Ford"},{"userId":"001011","firstName":"Camille","lastName":"Saint-Saëns"},{"userId":"001013","firstName":"Brad","lastName":"Pitt"},{"userId":"001014","firstName":"Bill","lastName":"Clinton"},{"userId":"001015","firstName":"Sinéad","lastName":"O’Connor"},{"userId":"001016","firstName":"Céline","lastName":"Dion"},{"userId":"001017","firstName":"René","lastName":"Magritte"},{"userId":"001018","firstName":"Joe","lastName":"Biden"},{"userId":"002018","firstName":"Adam","lastName":"Driver"},{"userId":"005018","firstName":"Adam","lastName":"Sandler"},{"userId":"001062","firstName":"Adam","lastName":"West"},{"userId":"001218","firstName":"Adam","lastName":"Smith"}]

Task 2:REST endpoint to update an employee resource

EndPoint=http://localhost:8080/v/1.0/employee
Method=Put
Input Body=
{
    "firstName":"Advent",
    "lastName":"Chavan",
    "userId":"001000"
}

Response:
{
    "userId": "001000",
    "firstName": "Advent",
    "lastName": "Chavan"
}


Task 3:REST endpoint to allow a search based on: - firstname and/or lastname - with an optional option to vary the return order based on case

Endpoint=http://localhost:8080/v/1.0/employee/firstName/Adam/lastName/Chavan
Method=Get
Response:

[{"userId":"001000","firstName":"Advent","lastName":"Chavan"},{"userId":"002018","firstName":"Adam","lastName":"Driver"},{"userId":"005018","firstName":"Adam","lastName":"Sandler"},{"userId":"001062","firstName":"Adam","lastName":"West"},{"userId":"001218","firstName":"Adam","lastName":"Smith"}]

Task 4: to get the employee details by employee number

Call get employee endpoint to verify the firstName and lastName is updated for employee number=001000

EndPoint=http://localhost:8080/v/1.0/employee/001000
Method=Get
Response:
{"userId":"001000","firstName":"Advent","lastName":"Chavan"}
