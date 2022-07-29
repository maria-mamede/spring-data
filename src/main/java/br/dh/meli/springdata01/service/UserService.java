package br.dh.meli.springdata01.service;

import br.dh.meli.springdata01.model.UserBD;
import br.dh.meli.springdata01.repository.IUserDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDBRepo userRepo;

    @Override
    public Optional<UserBD> getUserById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public UserBD insertUser(UserBD newUser) {
        if(newUser.getId() > 0) return null;

        return userRepo.save(newUser);
    }

    @Override
    public UserBD updateUser(UserBD user) {
        return null;
    }

    @Override
    public UserBD updatePartial(long id, Map<String, String> changes) {
        return null;
    }

    @Override
    public void deleteUser(long id) {
        if(userRepo.findById(id).isPresent()){
            userRepo.deleteById(id);
        }

        //TODO lancar excecao

    }

    @Override
    public List<UserBD> listAll() {
        return userRepo.findAll();
    }

    @Override
    public UserBD findByEmail(String email) {
        return null;
    }
}
