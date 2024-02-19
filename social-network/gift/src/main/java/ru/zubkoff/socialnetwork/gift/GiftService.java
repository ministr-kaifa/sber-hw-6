package ru.zubkoff.socialnetwork.gift;

import ru.zubkoff.socialnetwork.user.User;

public interface GiftService {

  Gift saveGift(Gift gift);

  GiftGiving giveGift(User from, User to, Gift gift);

  GiftGiving findGiftGivingById(Long id);

  Gift findGiftById(Long id);
  
}
