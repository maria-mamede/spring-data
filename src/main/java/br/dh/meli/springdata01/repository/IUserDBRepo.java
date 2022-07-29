package br.dh.meli.springdata01.repository;

import br.dh.meli.springdata01.model.UserBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDBRepo extends JpaRepository<UserBD, Long> {

}
