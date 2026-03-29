package by.tms.ecommerceprojectc38onl.dao;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SellerInfoDAO {
    private final DataSource dataSource;

    public SellerInfoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
