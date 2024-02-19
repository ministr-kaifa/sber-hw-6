package ru.zubkoff.socialnetwork.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.when;

import java.lang.reflect.Executable;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  UserService service;

  @Test
  void givenPersistedUser_whenFindPersistedUser_thenReturnPersistedUser() {
    long userId = 1;
    var user = new User(1, "880005553535", "h7dkjc8e7", List.of(), List.of(), "Иванов Иван Иванович");
    when(service.findUserById(userId)).thenReturn(user);
    
    var userFromService = service.findUserById(userId);

    assertEquals(user, userFromService);
  }
  
}
