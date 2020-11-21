package com.example.datajpademo.repo;

import com.example.datajpademo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAddress(String emailAddress);
    List<User> findByAge(int age);
    User findByEmailAddressAndAge(String emailAddress,int age);
    List<User> findByEmailAddressOrAge(String emailAddress,int age);
    List<User> findByLastnameStartingWith(String lastname);
    List<User> findByLastnameLikeOrderByFirstnameDesc(String lastname);
   // List<User> findByLastnameContainingOrderByFirstnameDesc(String lastname);
    //List<User> findByLastnameOrderByFirstnameDescContaining(String lastname);
    List<User> findByLastnameContainingOrderByFirstnameDesc(String lastname, Pageable pageable);
    @Query(value = "select u from User u where u.firstname=?1",nativeQuery = false)
    List<User> findname(String firstname);

    @Query(value = "select * from user_table where firstname=?1",nativeQuery = true)
    List<User> findfirstnameNative(String firstname);

    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("select u, manager from User u, User manager where u.manager.id=manager.id")
    List<Object[]> getByManger();
}
