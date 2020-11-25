package com.example.springjpahello.controller;

import com.example.springjpahello.entity.User;
import com.example.springjpahello.repo.UserRepository;
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

    @GetMapping(value = "/{id}",produces = "application/xml", params = "id")
    //public EntityModel<User> retrieveUser(@PathVariable int id) {
    public ResponseEntity<?> retrieveUser(@PathVariable Long id) {

        Optional<User> user = userRepository.findById(id);
        Object o=user.isPresent()? user.get(): "resource not found";
       /* if (!user.isPresent())
            throw new UserNotFoundException("id-" + id);
*/
        // "all-users", SERVER_PATH + "/users"
        // retrieveAllUsers
       // EntityModel<User> resource = EntityModel.of(user.get());//new EntityModel<User>(user.get());

        //WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        //resource.add(linkTo.withRel("all-users"));

        // HATEOAS

        //return resource;
        return ResponseEntity.ok(o);
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
