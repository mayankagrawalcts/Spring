package com.example.springjpahello.controller;

import com.example.springjpahello.entity.User;
import com.example.springjpahello.exception.ResourceNotFound;
import com.example.springjpahello.repo.UserRepository;
import com.example.springjpahello.utils.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    @Autowired
    private MessageSource messageSource;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/requestParam")
    public ResponseEntity<?> requestParam(@RequestParam MultiValueMap<String,String> map){
        System.out.println(map.get("demo"));
        System.out.println(map.getFirst("firstKey"));
        System.out.println(map.getOrDefault("demoArr", Arrays.asList(new String[]{"demo"})));
        return ResponseEntity.noContent().build();
    }

    // @Autowired
    //private PostRepository postRepository;

    @GetMapping(value = "", headers = "test=test1")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}",produces = "application/xml", params = {"id","lastname","firstname","emailAddress","age"})
    //public EntityModel<User> retrieveUser(@PathVariable int id) {
    public ResponseEntity<?> retrieveUser(@PathVariable Long id, @RequestBody User  userBody) {
       // System.out.println("request param userDetails"+userDetails);
        System.out.println("userBody: "+userBody);

        Optional<User> user = userRepository.findById(id);
        Handler.optionalExceptionHandler(user,"user entity not foound for id: "+id);

        //user.orElseThrow(() ->new ResourceNotFound("user entity not foound for id: "+id));
       /* if (!user.isPresent())
            throw new UserNotFoundException("id-" + id);
*/
        return ResponseEntity.ok(user.get());

        // "all-users", SERVER_PATH + "/users"
        // retrieveAllUsers
       // EntityModel<User> resource = EntityModel.of(user.get());//new EntityModel<User>(user.get());

        //WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        //resource.add(linkTo.withRel("all-users"));

        // HATEOAS

        //return resource;
    }

    @GetMapping("/retrieveByObject")
    public ResponseEntity<?> retrieveByObject(@Valid User  userBody) {
        System.out.println("retrieveByObject userBody: "+userBody);
        return ResponseEntity.ok(userBody);
    }

    @GetMapping("/retrieveIntenationalization/{id}")
    public ResponseEntity<?> retrieveIntenationalization(@PathVariable Long id) {

String message=messageSource.getMessage("good.morning.message", null,
        LocaleContextHolder.getLocale());
        System.out.println(id+""+message);
return new ResponseEntity<>(message, HttpStatus.OK);
    }
        @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    //
    // input - details of user
    // output - CREATED & Return the created URI

    // HATEOAS

    @PostMapping(value = {"/","/saveData"},consumes = "application/xml")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

      //  URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
        //        .toUri();

        //return ResponseEntity.created(location).build();
return ResponseEntity.ok(savedUser);
    }

    /*
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {

        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        User user = userOptional.get();

        post.setUser(user);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
     */

}
