package ru.zubkoff.socialnetwork.commons;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericRepositoryTest {

  GenericRepository<Object, Object> repository;

  @BeforeEach
  void init() {
    repository = new GenericRepository<>(){}; 
  }

  @Test
  void givenPersistedObject_whenGetPersistedObject_thenReturnPersistedObject() {
    Object id1 = new Object();
    Object entity1 = new Object();
    Object id2 = new Object();
    Object entity2 = new Object();
    repository.persist(id1, entity1);
    repository.persist(id2, entity2);

    var entity1FromRepository = repository.find(id1).get();
    var entity2FromRepository = repository.find(id2).get();
    
    assertEquals(entity1FromRepository, repository.find(id1).get());
    assertEquals(entity2FromRepository, repository.find(id2).get());
  }

  @Test
  void givenPersistedObject_whenRemovePersistedObject_thenDoesNotReturnPersistedObject() {
    Object id1 = new Object();
    Object entity1 = new Object();
    Object id2 = new Object();
    Object entity2 = new Object();
    repository.persist(id1, entity1);
    repository.persist(id2, entity2);

    repository.remove(id1);
    repository.remove(id2);
    
    assertTrue(repository.find(id1).isEmpty());
    assertTrue(repository.find(id2).isEmpty());
  }

  @Test
  void givenPersistedObjectAndObjectToMerge_whenMergePersistedObject_thenReturnMergedObject() {
    Object id1 = new Object();
    Object entity1 = new Object();
    Object entityToMerge = new Object();
    repository.persist(id1, entity1);

    repository.merge(id1, entityToMerge);
    var mergedEntityFromRepository = repository.find(id1).get();

    assertEquals(mergedEntityFromRepository, entityToMerge);
  }
  
}
