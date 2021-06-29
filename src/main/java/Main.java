import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

//d/dse/tickets/Astra/secure-connect-stocku.zip


public class Main {
  public static void main(String[] args) {
    try (CqlSession session = CqlSession.builder()
            // make sure you change the path to the secure connect bundle below
            //.withCloudSecureConnectBundle(Paths.get("d:\\dse\\tickets\\Astra\\secure-connect-stocku.zip"))
            .withCloudSecureConnectBundle(Paths.get("/root/java-driver-demo/secure-connect-eqh-poc.zip"))
            //.withAuthCredentials("ClientId","LongSecret")
            .withAuthCredentials("ClientId","LongSecret")
            .withKeyspace("system")
            .build()) {

                // For the sake of example, run a simple query and print the results
                ResultSet rs = session.execute("select release_version from system.local");
                Row row = rs.one();
                if (row != null) {
                    System.out.println(row.getString("release_version"));
                } else {
                    System.out.println("An error occurred.");
                }
           }
        }
    }
