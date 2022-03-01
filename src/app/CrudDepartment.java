package app;

import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CrudDepartment {

    public void menuCrudDepartment(DepartmentDao departmentDao) {
        Scanner sc = new Scanner(System.in);
        int resp;

        do {
            System.out.println("\nMENU DE OPÇÕES:");
            System.out.print("1 - findById\n" +
                    "2 - findAll\n" +
                    "3 - insert\n" +
                    "4 - update\n" +
                    "5 - delete\n" +
                    "9 - close\n\n" +
                    "enter option: "
            );
            resp = sc.nextInt();
            OpcoesDepartment(resp, departmentDao);
        } while (resp != 9);
        sc.close();
    }

    private void OpcoesDepartment (int resp, DepartmentDao departmentDao){
        Scanner sc = new Scanner(System.in);

        switch (resp) {

            case 1:
                System.out.println("\n=== TEST 1: department findById ===\n");
                System.out.print("Enter department id: ");
                Department department = departmentDao.findById(sc.nextInt());
                System.out.println("\n" + department);
                return;

            case 2:
                System.out.println("\n=== TEST 2: department findAll ===\n");
                List<Department> list = departmentDao.findAll();
                for (Department obj : list) {
                    System.out.println(obj);
                }
                return;

            case 3:
                System.out.println("\n=== TEST 3: department insert ===\n");
                System.out.println("Enter the data ");
                System.out.print("Name: ");
                Department newDepartment = new Department(null, sc.nextLine());
                departmentDao.insert(newDepartment);
                System.out.println("Inserted! New id = " + newDepartment.getId());
                return;

            case 4:
                System.out.println("\n=== TEST 4: department update ===\n");
                System.out.println("Enter the department id ");
                department = departmentDao.findById(sc.nextInt());
                System.out.println("Enter the data ");
                System.out.print("Name: ");
                sc.nextLine();
                department.setName(sc.nextLine());
                departmentDao.update(department);
                System.out.println("Update completed");
                sc.next();
                return;

            case 5:
                System.out.println("\n=== TEST 5: department delete ===\n");
                System.out.println("Enter id for delete");
                departmentDao.deleteById(sc.nextInt());
                System.out.println("Delete completed");
                break;

            case 9:
                System.out.println("Bye :)\n");
                return;
        }

        sc.close();
    }
}
