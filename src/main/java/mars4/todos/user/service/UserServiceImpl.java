package mars4.todos.user.service;

import lombok.RequiredArgsConstructor;
import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.user.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserJpaRepository userJpaRepository;

    @Override
    public RequestResponseDto<?> save(RequestResponseDto dto) {
        return null;
    }

    @Override
    public RequestResponseDto<?> login(RequestResponseDto dto) {
        return null;
    }
}
