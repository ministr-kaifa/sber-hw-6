package ru.zubkoff.socialnetwork.picture;

public interface PictureService {
  
  Picture uploadPicture(String pictureData);

  Picture getPicture(String url);

}
