package pe.edu.pucp.msuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pe.edu.pucp.msuser.daos.UserDao;
import pe.edu.pucp.msuser.entity.Credential;
import pe.edu.pucp.msuser.entity.User;
import pe.edu.pucp.msuser.repository.CredentialRepository;
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

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listAllUsers() {
        return new ResponseEntity(userRepository.findAllUserSummary(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity showUserDetail(@PathVariable("userId") Integer userId) {
        return null;
        // return new ResponseEntity(userRepository.findUserDetailById(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@Valid @RequestBody UserDao user) {
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
    public Map<String, String> editUser() {
        return null;
    }

    @DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId) {

        Map<String, String> response = new HashMap<>();
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isPresent()){
            userRepository.deleteById(userId);

            response.put("status", HttpStatus.OK.getReasonPhrase());
            response.put("message", "User saved successfully.");
            return new ResponseEntity(response, HttpStatus.OK);
        }else{
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

}
