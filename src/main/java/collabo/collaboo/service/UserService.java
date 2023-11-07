package collabo.collaboo.service;


import collabo.collaboo.domain.User;
import collabo.collaboo.dto.user.AddUserRequest;
import collabo.collaboo.dto.user.UpdateUserRequest;
import collabo.collaboo.exception.user.UserNotFoundException;
import collabo.collaboo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    // create
    public User save(AddUserRequest request){
        return userRepository.save(request.toEntity());
    }

    // read
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // update
    public User update(Long id, UpdateUserRequest request){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException();

        user.get().update(
                request.getUserName(),
                request.getUserId(),
                request.getUserPw()
        );

        return user.get();
    }
}