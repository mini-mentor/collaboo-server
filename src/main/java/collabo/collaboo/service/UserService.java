package collabo.collaboo.service;

import collabo.collaboo.domain.User;
import collabo.collaboo.repository.UserRepository;
import collabo.repository.User.AddUserRequest;
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
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    // update
    @Transactional
    public User update(long id, UpdateUserRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        user.update(
                request.getUserName(),
                request.getUserId(),
                request.getUserPw(),
                request.getId()
        );

        return user;
    }
}
