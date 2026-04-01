package by.tms.ecommerceprojectc38onl.service;

import by.tms.ecommerceprojectc38onl.dao.UserDAO;
import by.tms.ecommerceprojectc38onl.dto.UserCreateDTO;
import by.tms.ecommerceprojectc38onl.dto.UserLoginDTO;
import by.tms.ecommerceprojectc38onl.dto.UserResponseDTO;
import by.tms.ecommerceprojectc38onl.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(UserCreateDTO userCreateDTO) {
        if(userDAO.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            throw new RuntimeException("User with same email already exists!");
        }

        if(userDAO.findByPhone(userCreateDTO.getPhone()).isPresent()) {
            throw new RuntimeException("User with same phone number already exists!");
        }

        if (!userCreateDTO.getPassword().equals(userCreateDTO.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match!");
        }

        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setEmail(userCreateDTO.getEmail());
        user.setPassword(userCreateDTO.getPassword());
        user.setPhone(userCreateDTO.getPhone());
        user.setSeller(false);

        userDAO.save(user);
    }

    public UserResponseDTO login(UserLoginDTO dto) {
        User user = userDAO.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Wrong email or password"));

        if(!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Wrong email or password");
        }

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.isSeller()
        );
    }

}