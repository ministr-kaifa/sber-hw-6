import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import ru.zubkoff.ArrayIterator;

class ArrayIteratorTest {

  @Test
  void givenEmptyArrayIterator_whenNextIsCalled_thenThrowsNoSuchElementException() {
    // given
    ArrayIterator emptyArrayIterator = new ArrayIterator(new Object[0]);

    // when & then
    assertThrows(NoSuchElementException.class, emptyArrayIterator::next);
  }

  @Test
  void givenEmptyArrayIterator_whenHasNextIsCalled_thenReturnFalse() {
    // given
    ArrayIterator emptyArrayIterator = new ArrayIterator(new Object[0]);

    // when
    boolean hasNext = emptyArrayIterator.hasNext();

    //then
    assertFalse(hasNext);
  }

  @Test
  void givenArrayIterator_whenHasNextIsCalledOnLastElement_thenReturnFalse() {
    // given
    ArrayIterator arrayIterator = new ArrayIterator(new Object[2]);

    // when
    arrayIterator.next();
    arrayIterator.next();
    boolean hasNext = arrayIterator.hasNext();

    //then
    assertFalse(hasNext);
  }

  @Test
  void givenArrayIterator_whenRecreatingArrayFromIterator_thenArraysAreEquals() {
    // given
    Integer[] array = {4,3,2,1};
    ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array);

    // when
    ArrayList<Integer> arrayCopy = new ArrayList<>();
    while (arrayIterator.hasNext()) {
      arrayCopy.add(arrayIterator.next());
    }

    //then
    assertArrayEquals(array, arrayCopy.toArray());
  }

}
