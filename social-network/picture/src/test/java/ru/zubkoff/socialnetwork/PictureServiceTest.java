package ru.zubkoff.socialnetwork;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.zubkoff.socialnetwork.picture.Picture;
import ru.zubkoff.socialnetwork.picture.PictureService;

@ExtendWith(MockitoExtension.class)
class PictureServiceTest {

  @Mock
  PictureService service;

  
  @Test
  void givenPersistedPicture_whenFindPersistedPicture_thenReturnPersistedPicture() throws URISyntaxException {
    when(service.uploadPicture(anyString())).thenReturn(new Picture(new URI("https://so.me/url")));
    when(service.getPicture("https://so.me/url")).thenReturn(new Picture(new URI("https://so.me/url")));

    var fromUploadPicture = service.uploadPicture("picture data");
    var fromGetPicture = service.getPicture(fromUploadPicture.getUrl().toString());

    assertEquals(fromUploadPicture, fromGetPicture);
  }
  
}
