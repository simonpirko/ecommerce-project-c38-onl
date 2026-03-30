package by.tms.ecommerceprojectc38onl.service;

import by.tms.ecommerceprojectc38onl.dao.SellerInfoDAO;
import org.springframework.stereotype.Component;

@Component
public class SellerInfoService {
    private final SellerInfoDAO sellerInfoDAO;

    public SellerInfoService(SellerInfoDAO sellerInfoDAO) {
        this.sellerInfoDAO = sellerInfoDAO;
    }
}
