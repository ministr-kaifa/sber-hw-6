package ru.zubkoff.socialnetwork.gift;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.zubkoff.socialnetwork.picture.Picture;
import ru.zubkoff.socialnetwork.picture.PictureService;
import ru.zubkoff.socialnetwork.user.User;

@ExtendWith(MockitoExtension.class)
class GiftServiceTest {

  @Mock
  GiftService service;

  @Test
  void givenPersistedGift_whenFindPersistedGift_thenReturnPersistedGift() throws URISyntaxException {
    long giftId = 1;
    PictureService pictureService = mock(PictureService.class);
    given(pictureService.uploadPicture(anyString())).willReturn(new Picture(new URI("https://so.me/url")));
    Gift gift = new Gift(giftId, pictureService.uploadPicture("picturedata"));
    when(service.findGiftById(giftId)).thenReturn(gift);

    var giftFromService = service.findGiftById(giftId);
    
    assertEquals(gift, giftFromService);
  }

  @Test
  void givenPersistedGiftGiving_whenGetPersistedGiftGiving_thenReturnPersistedGiftGiving() throws URISyntaxException {
    PictureService pictureService = mock(PictureService.class);
    given(pictureService.uploadPicture(anyString())).willReturn(new Picture(new URI("https://so.me/url")));
    Gift gift = new Gift(1, pictureService.uploadPicture("picturedata"));
    when(service.giveGift(any(User.class), any(User.class), any(Gift.class))).thenAnswer(invocation -> {
      User from = invocation.getArgument(0);
      User to = invocation.getArgument(1);
      Gift giftToGive = invocation.getArgument(2);
      return new GiftGiving(1, from, to, giftToGive, Instant.now());
    });
    var from = new User(1, "880005553535", "h7dkjc8e7", List.of(), List.of(), "Иванов Иван Иванович");
    var to = new User(2, "880005553535", "h7dkjc8e7", List.of(), List.of(), "Иванов Иван Иванович");

    var giftGiving = service.giveGift(from, to, gift);

    assertEquals(giftGiving.getSender(), from);
    assertEquals(giftGiving.getRecipient(), to);
    assertEquals(giftGiving.getGift(), gift);
  }

}
