package com.test.designPettern.singelton;


public class ProductDao {

     public static ProductDao productDao = null;


    private ProductDao() {}

    public static ProductDao getInstance(){
        if (productDao == null) {
            synchronized (ProductDao.class) {
                if (productDao == null) {
                    return productDao = new ProductDao();
                }
            }
        }
        return productDao;
    }

}
