package ru.zubkoff.socialnetwork.commons;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Абстрактный класс GenericRepository предоставляет базовые операции для управления сущностями в репозитории.
 *
 * @param <Id>     Тип идентификатора сущности.
 * @param <Entity> Тип сущности, хранящейся в репозитории.
 */
public abstract class GenericRepository<Id, Entity> {

  private final Map<Id, Entity> database = new HashMap<>();

  /**
   * Метод для сохранения новой сущности в репозитории.
   *
   * @param id     Уникальный идентификатор сущности.
   * @param entity Сущность для сохранения.
   * @throws IllegalStateException если сущность с таким идентификатором уже существует в репозитории.
   */
  public void persist(Id id, Entity entity) {
      if (database.containsKey(id)) {
          throw new IllegalStateException("id duplicate");
      }
      database.put(id, entity);
  }

  /**
   * Метод для удаления сущности из репозитория по её идентификатору.
   *
   * @param id Уникальный идентификатор сущности для удаления.
   * @throws NoSuchElementException если сущность с указанным идентификатором не найдена в репозитории.
   */
  public void remove(Id id) {
      if (!database.containsKey(id)) {
          throw new NoSuchElementException("found no entity with given id");
      }
      database.remove(id);
  }

  /**
   * Метод для обновления (слияния) существующей сущности в репозитории.
   *
   * @param id     Уникальный идентификатор сущности.
   * @param entity Обновленная версия сущности.
   * @throws NoSuchElementException если сущность с указанным идентификатором не найдена в репозитории.
   */
  public void merge(Id id, Entity entity) {
      if (!database.containsKey(id)) {
          throw new NoSuchElementException("found no entity with given id");
      }
      database.put(id, entity);
  }

  /**
   * Метод для поиска сущности в репозитории по её идентификатору.
   *
   * @param id Уникальный идентификатор сущности.
   * @return Optional, содержащий сущность, если она найдена, или пустой Optional, если сущность не найдена.
   */
  public Optional<Entity> find(Id id) {
      return Optional.ofNullable(database.get(id));
  }
}

