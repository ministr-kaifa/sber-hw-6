package ru.zubkoff.socialnetwork.user;

public interface UserService {
  
  User saveUser(User user);

  User findUserById(Long id);
  /**
   * Метод для изменения состояния подписки пользователя на другого пользователя.
   *
   * @param subscriber   Пользователь, который осуществляет подписку.
   * @param user         Пользователь, на которого осуществляется подписка или отписка.
   * @param isSubscribed Флаг, указывающий на новое состояние подписки (true - подписаться, false - отписаться).
   */
  void changeSubscriptionState(User subscriber, User user, boolean isSubscribed);

}
