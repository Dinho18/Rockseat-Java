package Dinho18.com.github.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IuserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel UserModel){
       var user = this.userRepository.findByUsername(UserModel.getUsername());

       if(user != null){
            // Mensagem de erro
            // Status Code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usúario já existe");

       } 
        var userCreated = this.userRepository.save(UserModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
    
}
