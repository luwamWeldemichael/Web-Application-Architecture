package edu.miu.assignment6.service;

import edu.miu.assignment6.entity.User;
import edu.miu.assignment6.entity.dto.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    void deleteById(long id);

    void save(UserDto p);

    void update(long userId, UserDto u);

    List<UserDto> findUsersWithMoreThanOnePost(int n);
    List<UserDto> findUsersWithPostTitle(String title);

    List<UserDto> findUsersByNumberOfPostsAndTitle(Integer numberOfPosts, String postTitle);

    User findByEmail(String email);
}
