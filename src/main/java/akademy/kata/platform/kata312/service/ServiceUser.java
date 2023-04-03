package akademy.kata.platform.kata312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import akademy.kata.platform.kata312.model.User;
import akademy.kata.platform.kata312.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

public class ServiceUser implements akademy.kata.platform.kata312.service.Service {
    private final UserRepository userRepository;

    @Autowired
    public ServiceUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override

    public User findOne(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
