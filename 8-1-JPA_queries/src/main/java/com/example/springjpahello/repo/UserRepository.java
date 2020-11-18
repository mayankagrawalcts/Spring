package com.example.springjpahello.repo;

import com.example.springjpahello.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String emailAddress);

    User findByEmailAddressAndLastname(String emailAddress, String lastname);

    List<User> findByLastnameOrFirstname(String lastname, String username);

    List<User> findByLastnameNot(String lastname);

    List<User> findByLastnameContainingIgnoreCase(String lastname);
    List<User> findByLastnameContaining(String lastname);

    List<User> findByLastnameNotNull();

    List<User> findByLastnameNotLike(String lastname);

    List<User> findByAgeGreaterThanEqual(int age);

    List<User> findByLastnameLikeOrderByFirstnameDesc(String lastname);

    @Query("select u from User u where u.emailAddress = ?1")
    @Transactional(readOnly = true)
    User findByAnnotatedQuery(String emailAddress);

    @Query("select u from User u where u.firstname like ?1%")
    List<User> findByFirstnameLike(String firstname);

    @Query("select u from User u where u.firstname like ?1% and u.firstname like ?2%")
    List<User> findByFirstnameContainingAndLastnameLike(String firstname,String lastname);

    @Query("select u from User u where u.firstname like :name%")
    List<User> findByFirstnameLikeNamed(@Param("name") String firstname);

    @Query("select s from User s where lower(s.firstname) like lower(concat('%', :firstname,'%'))")
    public List<User> findByNameLikeUsingNamedParameter(@Param("firstname") String firstname);

    //@Query(value = "{'firstname': {$regex : ?0, $options: 'i'}}")
    //List<User> findByFirstnameRegex(String regexString);

//    @Query(value = "{'firstname': {$regex : ?0, $options: 'i'},'lastname':{$regex : ?1, $options: 'i'}}")
  //  List<User> findByFirstnameRegexOrLastnameRegex(String regexString,String lastnameRegexString);

    @Query("select count(u) from User u where u.firstname=?1")
    Long countWithFirstname(String firstname);

    List<User> findByLastnameStartingWith(String lastname, Pageable pageable);

    List<User> findByFirstnameNotIn(Collection<String> firstnames);

    List<User> findByFirstnameNotIn(List<String> firstnames);

    @Query("select u.lastname from User u group by u.lastname")
    List<String> findByLastnameGrouped(Pageable pageable);

    @Query(value = "SELECT * FROM user_table WHERE lastname=?1", nativeQuery = true)
    List<User> findNativeByLastname(String lastname);


    @Query(value = "SELECT * FROM user_table WHERE lastname=?1", nativeQuery = true)
    List<User> findLastname(String lastname);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "alter table user_table add column deleted_flag int(1) not null default 0", nativeQuery = true)
    void addColumn();

List<User> findByFirstNameAndLastName(String firstname,String lastname);

    List<User> findByFirstName(String firstname);

    @Query("SELECT u,manager FROM  User manager, User u where u.manager.id= manager.id")
           public List<Object[]> getMultipleEntities();

}
