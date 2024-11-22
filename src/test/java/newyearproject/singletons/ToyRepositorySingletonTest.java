package newyearproject.singletons;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import newyearproject.repository.ToyRepository;

public class ToyRepositorySingletonTest {
    @Test
    void testGetInstance() {
ToyRepository repo1 = ToyRepositorySingleton.getInstance();
        ToyRepository repo2 = ToyRepositorySingleton.getInstance();

        assertSame(repo1, repo2, "ToyRepositorySingleton should return the same instance");

    }
}
