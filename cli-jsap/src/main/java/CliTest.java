import java.util.Iterator;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;

public class CliTest {

	public static void main(String[] args) throws JSAPException {
		
	    JSAP commandLineOptions = new JSAP();
	    
        commandLineOptions.registerParameter(new FlaggedOption("count").setStringParser(JSAP.INTEGER_PARSER)
        				  .setDefault("1").setRequired(true).setShortFlag('n').setLongFlag(JSAP.NO_LONGFLAG)
        				  .setHelp("specifies the number of iterations"));
        commandLineOptions.registerParameter(new Switch("verbose").setShortFlag('v').setLongFlag("verbose"));
        JSAPResult cmd = commandLineOptions.parse(args);
        if (!cmd.success()) {
        	for (Iterator errs = cmd.getErrorMessageIterator(); errs.hasNext(); )
        		System.err.println("Problem: " + errs.next());
            System.err.println("Command line parsing problem. Usage is as follows:" + commandLineOptions.getUsage());
            System.exit(1);
        }
        System.out.println("Parameters parsed: verbose=" + cmd.getBoolean("verbose") + ", count=" + cmd.getInt("count"));
	}
}
