package edu.miu.assignment6.service.imp;

import edu.miu.assignment6.entity.User;
import edu.miu.assignment6.entity.dto.UserDto;
import edu.miu.assignment6.repo.UserRepo;
import edu.miu.assignment6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(e-> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        var user = userRepo.findById(id).orElse(null);
        return user == null ? null :  modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteById(long id) {
       userRepo.deleteById(id);
    }

    @Override
    public void save(UserDto p) {
        userRepo.save(modelMapper.map(p, User.class));
    }

    @Override
    public void update(long userId, UserDto u) {
        u.setId(userId);
        userRepo.save(modelMapper.map(u, User.class));
    }

    @Override
    public List<UserDto> findUsersWithMoreThanOnePost(int n) {
        return userRepo.findUsersWithMoreThanOnePost(n).stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersWithPostTitle(String title) {
        return userRepo.findUsersWithPostTitle(title).stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersByNumberOfPostsAndTitle(Integer numberOfPosts, String postTitle) {
        if(postTitle != null && numberOfPosts != null)
            return userRepo.findUsersByNumberOfPostsAndTitle(numberOfPosts, postTitle).stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
        else if (postTitle != null)
            return findUsersWithPostTitle(postTitle);
        else
            return findUsersWithMoreThanOnePost(numberOfPosts);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
