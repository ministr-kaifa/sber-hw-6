package ru.zubkoff.socialnetwork.conversation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.zubkoff.socialnetwork.user.User;

@ExtendWith(MockitoExtension.class)
class ConversationServiceTest {

  @Mock
  ConversationService service;

  @Test
  void givenPersistedConversation_whenFindPersistedConversation_thenReturnPersistedConversation() {
    long conversationId = 1;
    var conversation = new Conversation(conversationId, Instant.now(), List.of(), List.of());
    service.saveConversation(conversation);
    when(service.findConversationById(conversationId)).thenReturn(conversation);

    var conversationFromService = service.findConversationById(conversationId);

    assertEquals(conversation, conversationFromService);
  }

  @Test
  void givenPersistedMessage_whenFindPersistedMessage_thenReturnPersistedMessage() {
    long messageId = 1;
    var message = new Message(1, Instant.now(), new User(1, "880005553535", "h7dkjc8e7", List.of(), List.of(), "Иванов Иван Иванович"), "content");
    when(service.findMessageById(messageId)).thenReturn(message);

    var messageFromService = service.findMessageById(messageId);

    assertEquals(message, messageFromService);
  }

}
