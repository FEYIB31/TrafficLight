import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

public class TrafficLightTest extends StageTest {
  @DynamicTest
  CheckResult test() {
    TestedProgram pr = new TestedProgram();
    String output = pr.start().toLowerCase();

    String[] lines = output.split("[\r\n]+");

    if (lines.length != 6) {
      return CheckResult.wrong("There should be exactly 6 lines in the output, as in example, but there were " + lines.length + " instead");
    }

    if (!lines[0].contains("welcome") || (!lines[0].contains("traffic management system"))) {
      return CheckResult.wrong("The first line of output should contain a greeting, as in example");
    }
    if (!lines[1].contains("menu")) {
      return CheckResult.wrong("The second line of output should tell the user, what is the list below for, " +
              "containing \"Menu\" substring");
    }

    String[] starts = new String[]{"1", "2", "3", "0"};
    String[] contain = new String[]{"Add", "Delete", "System", "Quit"};
    for (int i = 0; i < starts.length; i++) {
      if (!lines[2 + i].startsWith(starts[i]) || !lines[2 + i].contains(contain[i].toLowerCase())) {
        return CheckResult.wrong(String.format("The %d line of menu list should start with \"%s\" as an option from list and " +
                "contain \"%s\" substring as in example", i+1, starts[i], contain[i]));
      }
    }

    return CheckResult.correct();
  }
}