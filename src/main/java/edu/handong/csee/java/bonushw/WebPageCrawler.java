package edu.handong.csee.java.bonushw;

public class WebPageCrawler {

	public static void main(String[] args) throws Exception {
		CLIOption cliOption = new CLIOption();
		cliOption.run(args);
		
		URLReader urlReader = new URLReader(cliOption.inputURL);
		urlReader.read();
		
		FileWriter fileWriter = new FileWriter(cliOption.outputPath, urlReader.allLines);
		fileWriter.write();
	}

}
