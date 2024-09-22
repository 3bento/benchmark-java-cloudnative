//DEPS commons-io:commons-io:2.12.0

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BenchmarkJmeterRun {
    public static void main(String[] args) {
        try {
            // Log the current working directory
            String currentDir = System.getProperty("user.dir");
            System.out.println("Current working directory: " + currentDir);

            // Set the current date and time for file naming
            String date_time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            // Set paths for JMeter using JMETER_HOME
            String jmeterHome = System.getenv("JMETER_HOME");
            String jmeterPath = jmeterHome + "\\bin\\jmeter.bat"; // Pointing to jmeter.bat
            String testPlan = "benchmark/jmeter/jmeter_benchmark_jakartaee10rest.jmx";
            String resultDir = "benchmark/jmeter/result";
            String resultFile = resultDir + "\\" + date_time + "_result.jtl"; // Updated for Windows path
            String reportDir = resultDir + "\\report\\" + date_time + "_report_web"; // Updated for Windows path

            // Check if JMETER_PATH exists
            if (!Files.exists(Paths.get(jmeterPath))) {
                System.err.println("Error: JMeter not found at " + jmeterPath);
                System.exit(1);
            }

            // Check if the test plan exists
            if (!Files.exists(Paths.get(testPlan))) {
                System.err.println("Error: Test plan not found at " + testPlan);
                System.exit(1);
            }

            // Create directories if they do not exist
            createDirectory(resultDir);
            createDirectory(reportDir);

            // Run JMeter in non-GUI mode
            ProcessBuilder processBuilder = new ProcessBuilder(
                    jmeterPath, "-n", "-t", testPlan, "-l", resultFile, "-e", "-o", reportDir);
            Process process = processBuilder.inheritIO().start();
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Error: JMeter execution failed.");
                System.exit(1);
            }

            System.out.println("Test completed successfully.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void createDirectory(String dir) {
        File directory = new File(dir);
        if (!directory.exists()) {
            try {
                FileUtils.forceMkdir(directory);
            } catch (IOException e) {
                System.err.println("Error: Failed to create directory " + dir);
                System.exit(1);
            }
        }
    }
}
