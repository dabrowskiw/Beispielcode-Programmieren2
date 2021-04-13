package org.htw.prog2.beispiele.cli;

import org.apache.commons.cli.*;

public class PrintNames {
    public static CommandLine parseOptions(String[] args) {
        Options options = new Options();
        // Variante 1: Optionen direkt über addOption hinzufügen
        options.addOption("l", "Print linewise"); // Nur Kurzform, keine Argumente
        options.addOption("c", "count", true, "Number of combinations"); // Kurz- und Langform, nimmt ein Argument
        // Variante 2: Option erstellen, konfigurieren, hinzufügen
        Option opt = new Option("F", "List of first names");
        opt.setArgs(Option.UNLIMITED_VALUES);
        opt.setLongOpt("firstnames");
        opt.setRequired(true);
        options.addOption(opt);
        // Variante 3: Option über builder erstellen, und konfigurieren, direkt hinzufügen
        options.addOption(Option.builder("L").
                hasArg(true).
                numberOfArgs(Option.UNLIMITED_VALUES).
                longOpt("lastnames").
                required(true).
                desc("List of last names").build());
        CommandLineParser parser = new DefaultParser();
        CommandLine cli;
        try {
            cli = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("HIVDiagnostics", options);
            return null;
        }
        return cli;
    }

    public static void main(String[] args) {
        CommandLine cli = parseOptions(args);
        int numCombinations = 10;
        int printedCombinations = 0;
        if(cli.hasOption('c')) {
            numCombinations = Integer.parseInt(cli.getOptionValue('c'));
        }
        System.out.println("Possible name combinations (up to " + numCombinations + "):");
        for(String firstname : cli.getOptionValues("firstnames")) {
            for(String lastname : cli.getOptionValues("lastnames")) {
                if(cli.hasOption('l')) {
                    System.out.println("  * " + firstname + " " + lastname);
                }
                else {
                    System.out.println(firstname + " " + lastname + ", ");
                }
                printedCombinations++;
                if(printedCombinations >= numCombinations) {
                    break;
                }
            }
            if(printedCombinations >= numCombinations) {
                break;
            }
        }
    }
}
