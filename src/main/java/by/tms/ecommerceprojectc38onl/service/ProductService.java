package by.tms.ecommerceprojectc38onl.service;


import by.tms.ecommerceprojectc38onl.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private final ProductDAO productDAO;


}
