package ru.zubkoff.socialnetwork.user;

import java.util.List;

public class User {
  private long id;
  private String phoneNumber;
  private String passwordHash;
  private List<User> subscribers;
  private List<User> subscribedTo;
  private String name;
  
  public User(long id, String phoneNumber, String passwordHash, List<User> subscribers, List<User> subscribedTo,
      String name) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.passwordHash = passwordHash;
    this.subscribers = subscribers;
    this.subscribedTo = subscribedTo;
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getPhoneNumber() {
    return phoneNumber;
  }
  
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public String getPasswordHash() {
    return passwordHash;
  }
  
  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }
  
  public List<User> getSubscribers() {
    return subscribers;
  }
  
  public void setSubscribers(List<User> subscribers) {
    this.subscribers = subscribers;
  }
  
  public List<User> getSubscribedTo() {
    return subscribedTo;
  }
  
  public void setSubscribedTo(List<User> subscribedTo) {
    this.subscribedTo = subscribedTo;
  }
}
