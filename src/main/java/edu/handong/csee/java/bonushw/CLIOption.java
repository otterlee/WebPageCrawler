package edu.handong.csee.java.bonushw;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CLIOption {

	String inputURL, outputPath;
	boolean verbose;
	boolean help;

	/**
	 * run is the main method in this class.
	 * use create Option to create my own options.
	 * and use parseOption method to parse option.
	 * 
	 */
	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}

		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine cmd = parser.parse(options, args);

			inputURL = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
		} catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}

	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("inputURL")
				.desc("Set a URL you want to save in html file")
				.hasArg()
				.argName("the input directory path")
				.required()
				.build());

		options.addOption(Option.builder("o").longOpt("outputPath")
				.desc("Set a file name with path to save html file")
				.hasArg()
				.argName("the output directory path")
				.required()
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "help _WebPageCrawler";
		String footer ="\nPlease report issues at https://github.com/otterlee/WebPageCrawler/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}

}
