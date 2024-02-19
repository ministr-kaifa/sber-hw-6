package ru.zubkoff.socialnetwork.conversation;

public interface ConversationService {

  /**
   * Добавлят сообщение в conversation
   */
  Message sendMessage(Conversation conversation, Message message);

  Conversation saveConversation(Conversation conversation);

  Conversation findConversationById(Long id);
  
  Message findMessageById(Long id);

}
