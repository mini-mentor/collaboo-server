package collabo.collaboo.service;


import collabo.collaboo.domain.User;
import collabo.collaboo.dto.user.AddUserRequest;
import collabo.collaboo.dto.user.UpdateUserRequest;
import collabo.collaboo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // create
    public User save(AddUserRequest request){
        return userRepository.save(request.toEntity());
    }

    // read
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // update

    @Transactional
    public User update(Long id, UpdateUserRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        user.update(
                request.getUserName(),
                request.getUserId(),
                request.getUserPw()
        );

        return user;
    }
}