package com.example.springjpahello.constants;

public interface Constants {
    String userManagerQuery="SELECT u,manager FROM  User manager, User u where u.manager.id= manager.id";
    String userSelectNative="SELECT * FROM user_table WHERE lastname=?1";
}
