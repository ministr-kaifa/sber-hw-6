package ru.zubkoff.socialnetwork.gift;

import ru.zubkoff.socialnetwork.picture.Picture;

/**
 * Класс описывающий подарок
 */
public class Gift {
  private long id;
  private Picture picture;
  
  public Gift(long id, Picture picture) {
    this.id = id;
    this.picture = picture;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public Picture getPicture() {
    return picture;
  }
  
  public void setPicture(Picture picture) {
    this.picture = picture;
  }
}
