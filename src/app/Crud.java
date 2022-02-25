package app;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Crud {

    public void menuCrud(SellerDao sellerDao) {
        Scanner sc = new Scanner(System.in);
        int resp;

        do {
            System.out.println("\nMENU DE OPÇÕES:");
            System.out.print("1 - findById\n" +
                    "2 - findByDepartment\n" +
                    "3 - findAll\n" +
                    "4 - insert\n" +
                    "5 - update\n" +
                    "6 - delete\n" +
                    "9 - close\n\n" +
                    "enter option: "
            );
            resp = sc.nextInt();
            Opcoes(resp, sellerDao);
        } while (resp != 9);
        sc.close();
    }

    public void Opcoes (int resp, SellerDao sellerDao){
        Scanner sc = new Scanner(System.in);

        switch (resp) {

            case 1:
                System.out.println("\n=== TEST 1: seller findById ===\n");
                System.out.print("Enter seller id: ");
                int sellerId = sc.nextInt();
                Seller seller = sellerDao.findById(sellerId);
                System.out.println("\n" + seller);
                return;

            case 2:
                System.out.println("\n=== TEST 2: seller findByDepartment ===\n");
                System.out.print("Enter department id: ");
                int departmentId = sc.nextInt();
                Department dp = new Department(departmentId, null);
                List<Seller> list = sellerDao.findByDepartment(dp);
                System.out.println();
                for (Seller obj : list) {
                    System.out.println(obj);
                }
                return;

            case 3:
                System.out.println("\n=== TEST 3: seller findAll ===\n");
                list = sellerDao.findAll();
                for (Seller obj : list) {
                    System.out.println(obj);
                }
                return;

            case 4:
                System.out.println("\n=== TEST 4: seller insert ===\n");
                System.out.println("Enter the data ");
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("E-mail:  ");
                String email = sc.nextLine();
                System.out.print("Base salary:  ");
                Double baseSalary = sc.nextDouble();
                System.out.print("Enter department id ");
                departmentId = sc.nextInt();
                dp = new Department(departmentId, null);
                Seller newSeller = new Seller(null, name, email, new Date(), baseSalary, dp);
                sellerDao.insert(newSeller);
                System.out.println("Inserted! New id = " + newSeller.getId());
                sc.next();
                return;

            case 5:
                System.out.println("\n=== TEST 5: seller update ===\n");
                System.out.println("Enter the seller id ");
                seller = sellerDao.findById(sc.nextInt());
                System.out.println("Enter the data ");
                System.out.print("Name: ");
                sc.nextLine();
                name = sc.nextLine();
                System.out.print("E-mail:  ");
                email = sc.nextLine();
                System.out.print("Base salary:  ");
                baseSalary = sc.nextDouble();

                seller.setName(name);
                seller.setEmail(email);
                seller.setBaseSalary(baseSalary);
                sellerDao.update(seller);
                System.out.println("Update completed");
                sc.next();
                return;

            case 6:
                System.out.println("\n=== TEST 6: seller delete ===\n");
                System.out.println("Enter id for delete");
                sellerDao.deleteById(sc.nextInt());
                System.out.println("Delete completed");
                break;

            case 9:
                System.out.println("Bye :)\n");
                return;
        }

        sc.close();
    }
}