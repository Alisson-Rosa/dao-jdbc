package app;

import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Crud crud = new Crud();

        crud.menuCrud(sellerDao);

    }
}
