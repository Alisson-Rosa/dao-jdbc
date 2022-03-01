package app;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        CrudSeller crudSeller = new CrudSeller();
        CrudDepartment crudDepartment = new CrudDepartment();

        System.out.println("Opção 1 - Seller\n" +
                           "Opção 2 - Department");
        int resp = sc.nextInt();
        if (resp == 1 ) {
            crudSeller.menuCrudSeller(sellerDao);
        } else {
            crudDepartment.menuCrudDepartment(departmentDao);
        }

        sc.close();
    }
}
