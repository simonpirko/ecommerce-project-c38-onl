package by.tms.ecommerceprojectc38onl.dao;

import by.tms.ecommerceprojectc38onl.dto.ProductDTO;
import by.tms.ecommerceprojectc38onl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {
    @Autowired
    private DataSource dataSource;

    public Optional<Product> findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Product product = this.setProduct(resultSet);
                return Optional.of(product);
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = this.setProduct(resultSet);

                products.add(product);
            }

            return products;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Product> save(ProductDTO productDTO, Long userId) {
        String sql = "INSERT INTO products (seller_id, category_id, name, description, price, quantity) VALUES(?,?,?,?,?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productDTO.getCategoryId());
            preparedStatement.setString(3, productDTO.getName());
            preparedStatement.setString(4, productDTO.getDescription());
            preparedStatement.setBigDecimal(5, productDTO.getPrice());
            preparedStatement.setInt(5, productDTO.getQuantity());


            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    return Optional.of(this.setProduct(resultSet));
                } else {
                    throw new SQLException("Insert failed: no id returned");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Product> updateById(Long id, ProductDTO productDTO) {
        String sql = "INSERT INTO products (seller_id, category_id, name, description, price, quantity) VALUES(?,?,?,?,?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productDTO.getCategoryId());
            preparedStatement.setString(3, productDTO.getName());
            preparedStatement.setString(4, productDTO.getDescription());
            preparedStatement.setBigDecimal(5, productDTO.getPrice());
            preparedStatement.setInt(5, productDTO.getQuantity());


            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    return Optional.of(this.setProduct(resultSet));
                } else {
                    throw new SQLException("Insert failed: no id returned");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Product setProduct(ResultSet data) throws SQLException {
        Product product = new Product();

        product.setId(data.getLong("id"));
        product.setName(data.getString("name"));
        product.setDescription(data.getString("description"));
        product.setPrice(data.getBigDecimal("price"));
        product.setQuantity(data.getInt("quantity"));

//        TODO: засетать seller cateogy
        return product;
    }

}
