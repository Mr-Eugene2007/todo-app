import org.example.TodoItem;
import org.example.TodoList;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add("  task1  ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst().getText());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add("   ");
        assertEquals(0, t.size());
    }

    @Test
    void markDoneTest() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        assertFalse(t.getAll().getFirst().isDone());
        assertTrue(t.markDone(0));
        assertTrue(t.getAll().getFirst().isDone());
        assertFalse(t.markDone(10));
    }

    @Test
    void clearTest() {
        TodoList t = new TodoList();
        t.add("Task 1");
        t.add("Task 2");
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void searchTest() {
        TodoList t = new TodoList();
        t.add("Learn Java");
        t.add("Configure CI/CD");
        t.add("Write Java tests");

        List<TodoItem> results = t.search("java");
        assertEquals(2, results.size());
        assertTrue(t.search("Python").isEmpty());
    }
}