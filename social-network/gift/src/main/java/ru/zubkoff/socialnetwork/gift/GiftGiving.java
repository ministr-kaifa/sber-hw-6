package ru.zubkoff.socialnetwork.gift;

import java.time.Instant;

import ru.zubkoff.socialnetwork.user.User;

/**
 * Класс описывающий подаренный подарок
 */
public class GiftGiving {
  private long id;
  private User sender;
  private User recipient;
  private Gift gift;
  private Instant createdAt;
  
  public GiftGiving(long id, User sender, User recipient, Gift gift, Instant timestamp) {
    this.id = id;
    this.sender = sender;
    this.recipient = recipient;
    this.gift = gift;
    this.createdAt = timestamp;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public User getSender() {
    return sender;
  }
  
  public void setSender(User sender) {
    this.sender = sender;
  }
  
  public User getRecipient() {
    return recipient;
  }
  
  public void setRecipient(User recipient) {
    this.recipient = recipient;
  }
  
  public Gift getGift() {
    return gift;
  }
  
  public void setGift(Gift gift) {
    this.gift = gift;
  }
  
  public Instant getCreatedAt() {
    return createdAt;
  }
  
  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
