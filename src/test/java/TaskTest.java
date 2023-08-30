import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    protected int id;

    @Test
    public void testSimpleTaskIfMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskIfNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertEquals(expected, actual);
    }

    String[] subtask = {"Молоко", "Яйца", "Хлеб"};

    @Test
    public void testEpicIfMatches() {
        Epic epic = new Epic(55, subtask);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicIfNotMatches() {
        Epic epic = new Epic(55, subtask);

        boolean expected = false;
        boolean actual = epic.matches("Колбаса");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingIfMatches() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложени");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingIfMatches2() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingIfNotMatches() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("Во вторник после обеда");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingIfNotMatches2() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("во вт после 14:00");

        Assertions.assertEquals(expected, actual);
    }

}
