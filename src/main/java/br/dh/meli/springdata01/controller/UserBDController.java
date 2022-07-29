package br.dh.meli.springdata01.controller;

import br.dh.meli.springdata01.model.UserBD;
import br.dh.meli.springdata01.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserBDController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserBD> buscaPorId(@PathVariable long id){
        Optional<UserBD> userFound = userService.getUserById(id);

        return userFound.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserBD> buscaPorEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserBD> insertNewUser (@RequestBody UserBD user){
        //TODO 1
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.insertUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        Optional<UserBD> userFound = userService.getUserById(id);

        if(userFound.isPresent()){
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserBD>> exibirTodos(){
        return ResponseEntity.ok(userService.listAll());
    }



}
