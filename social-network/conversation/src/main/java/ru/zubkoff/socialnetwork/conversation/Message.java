package ru.zubkoff.socialnetwork.conversation;

import java.time.Instant;

import ru.zubkoff.socialnetwork.user.User;

public class Message {
  private long id;
  private Instant createdAt;
  private User sender;
  private String content;
  
  public Message(long id, Instant createdAt, User sender, String content) {
    this.id = id;
    this.createdAt = createdAt;
    this.sender = sender;
    this.content = content;
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
  
  public User getSender() {
    return sender;
  }
  
  public void setSender(User sender) {
    this.sender = sender;
  }
  
  public String getContent() {
    return content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
}
