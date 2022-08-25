# springBoot_collageDepartment_database


API's 

*Employee 
model---->
int empId;
String empName;
String empCity;
Date empBirthdate;
API's ---->
1)save employee = http://localhost:8080//employee/save
2)update employee = http://localhost:8080//employee/update
3)get employee by id = http://localhost:8080//employee/getById/{empId}
4)delete employee = http://localhost:8080//employee/delete/{empId}
5)get all employees = http://localhost:8080//employee/getAll
6)get employee by department id = http://localhost:8080//employee/getByDepartment/{deptId}
7)sort employees by name = http://localhost:8080//employee/SortByName
8)sort employees by city = http://localhost:8080//employee/SortByCity
9)sort employees by birth date = http://localhost:8080//employee/SortByBirthday

*Professor 
model---->
int profId;
String profName;
String subject;
API's ---->
1)save professor= http://localhost:8080//professor/save
2)update professor= http://localhost:8080//professor/update
3)get professorby id = http://localhost:8080//professor/getById/{profId}
4)delete professor= http://localhost:8080//professor/delete/{profId}
5)get all professor= http://localhost:8080//professor/getAll
6)get professor by department id = http://localhost:8080//professor/getByDepartment/{deptId}

Department
model---->
int deptId;
String deptName; 
API's---->
1)save department = http://localhost:8080//department/save
2)update department = http://localhost:8080//department/update
3)get department by id = http://localhost:8080//department/getById/{deptId}
4)delete department = http://localhost:8080//department/delete/{deptId}
5)get all department = http://localhost:8080//department/getAll
