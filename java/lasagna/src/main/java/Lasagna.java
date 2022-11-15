public class Lasagna {
  // TODO: define the 'expectedMinutesInOven()' method

  // TODO: define the 'remainingMinutesInOven()' method

  // TODO: define the 'preparationTimeInMinutes()' method

  // TODO: define the 'totalTimeInMinutes()' method

  sealed interface S permits A, B, C {};

  final class A implements S {
  };

  final class B implements S {};

  record C(int i) implements S {
  }; // Implicitly final

  static int testSealedExhaustive(S s) {
    return switch (s) {
      case A a -> 1;
      case B b -> 2;
      case C c -> 3;
    };
  }

}
