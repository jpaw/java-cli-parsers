import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.Parameter;
import com.martiansoftware.jsap.SimpleJSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;

public class CliTest {

	public static void main(String[] args) throws JSAPException {
		
	    SimpleJSAP commandLineOptions = new SimpleJSAP("CliTest", "Does just a command line parsing demo", new Parameter[] {
	    		new FlaggedOption("count", JSAP.INTEGER_PARSER, "1", JSAP.REQUIRED, 'n', JSAP.NO_LONGFLAG, "specifies the number of iterations"),
	    		new Switch("verbose", 'v', "verbose")
	    });
        JSAPResult cmd = commandLineOptions.parse(args);
        if (commandLineOptions.messagePrinted())
            System.exit(1);
        
        System.out.println("Parameters parsed: verbose=" + cmd.getBoolean("verbose") + ", count=" + cmd.getInt("count"));
	}
}
