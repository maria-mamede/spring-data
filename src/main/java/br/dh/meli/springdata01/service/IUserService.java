package br.dh.meli.springdata01.service;

import br.dh.meli.springdata01.model.UserBD;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserService {
    Optional<UserBD> getUserById(long id);
    UserBD insertUser(UserBD newUser);
    UserBD updateUser(UserBD user);
    UserBD updatePartial(long id, Map<String, String> changes);
    void deleteUser(long id);
    List<UserBD> listAll();
    UserBD findByEmail(String email);
}
