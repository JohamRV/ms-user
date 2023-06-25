package pe.edu.pucp.msuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.pucp.msuser.daos.UserDao;
import pe.edu.pucp.msuser.entity.Credential;
import pe.edu.pucp.msuser.entity.User;
import pe.edu.pucp.msuser.repository.CredentialRepository;
import pe.edu.pucp.msuser.repository.RolRepository;
import pe.edu.pucp.msuser.repository.UserRepository;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ms-user")
@CrossOrigin
public class UserController {

    
    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    RolRepository rolRepository;

    @GetMapping("/list")
    public List<User> listAllUsers(){
        return null;
    }

    @GetMapping("/show/{userId}")
    public User showUserDetail(){
        return null;
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@Valid @RequestBody UserDao user){
        // TODO falta validar que el rolId exista, encriptar la contraseña y guardar el usuario en Openstack.
        Map<String, String> response = new HashMap<>();
        User newUser = user.getUser();

        Credential credential = credentialRepository.save(user.getCredential());

        newUser.setCredentialId(credential.getCredentialId());
        newUser.setRolId(user.getRol().getRolId());
        userRepository.save(user.getUser());

        response.put("status", HttpStatus.CREATED.getReasonPhrase());
        response.put("message", "User saved successfully.");

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public Map<String, String> editUser(){
        return null;
    }

    @DeleteMapping("/delete")
    public Map<String, String> deleteUser(){
        return null;
    }

}
