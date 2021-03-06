// Install the Java helper library from twilio.com/docs/java/install
import java.util.Map;

import com.twilio.Twilio;
import com.twilio.rest.taskrouter.v1.workspace.workflow.WorkflowRealTimeStatistics;

public class Example {
  private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
  private static final String WORKSPACE_SID = "WSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  private static final String WORKFLOW_SID = "WWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    WorkflowRealTimeStatistics statistics = WorkflowRealTimeStatistics.fetcher(WORKSPACE_SID, WORKFLOW_SID).fetch();

    Map<String, Object> tasksByStatus = statistics.getTasksByStatus();
    System.out.println("Pending Tasks: " + tasksByStatus.get("pending"));
    System.out.println("Assigned Tasks: " + tasksByStatus.get("assigned"));
  }
}
