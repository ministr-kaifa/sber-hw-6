package ru.zubkoff.socialnetwork.conversation;

import java.time.Instant;
import java.util.List;

import ru.zubkoff.socialnetwork.user.User;

public class Conversation {
  private long id;
  private Instant createdAt;
  private List<Message> messages;
  private List<User> participants;
  
  public Conversation(long id, Instant createdAt, List<Message> messages, List<User> participants) {
    this.id = id;
    this.createdAt = createdAt;
    this.messages = messages;
    this.participants = participants;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public Instant getCreatedAt() {
    return createdAt;
  }
  
  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
  
  public List<Message> getMessages() {
    return messages;
  }
  
  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
  
  public List<User> getParticipants() {
    return participants;
  }
  
  public void setParticipants(List<User> participants) {
    this.participants = participants;
  }
}
