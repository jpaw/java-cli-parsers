import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class CliTest {
    private static final Options commandLineOptions = new Options();
    static {
        commandLineOptions.addOption("b", "boolopt", false, "Boolean option");
        commandLineOptions.addOption("p", "paramopt", true, "parameterized option");
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean hasBool = false;
		String hasParam = "(not set)";
		
        try {
            CommandLineParser parser = new PosixParser();
            CommandLine cmd = parser.parse(commandLineOptions, args);
            if (cmd.hasOption('b')) {
            	hasBool = true;
            }
            if (cmd.hasOption('p')) {
            	hasParam = cmd.getOptionValue('p');
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.err.println("Command line parsing problem. Usage is as follows:");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(CliTest.class.getName(), commandLineOptions);
            System.exit(1);
        }
        System.out.println("Parameters parsed: boolopt=" + hasBool + ", paramopt=" + hasParam);
	}
}
