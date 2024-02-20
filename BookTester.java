import java.util.*;

public class BookTester {
    public static void main(String[] args) {

        // Create a HashMap for each genre with the author's name as the key and the simplified summary as the value
        HashMap<String, String> horrorAuthors = new HashMap<>();
        horrorAuthors.put("Stephen King", "THE SHINING:Jack Torrance becomes winter caretaker at the isolated Overlook Hotel in Colorado, hoping to cure his writer's block. He settles in along with his wife, Wendy, and his son, Danny , who is plagued by psychic premonitions. As Jack's writing goes nowhere and Danny's visions become more disturbing, Jack discovers the hotel's dark secrets and begins to unravel into a homicidal maniac hell-bent on terrorizing his family.");
        horrorAuthors.put("Edgar Allan Poe", "'The Black Cat' is the story of an alcoholic who is driven by his addiction. He tortures and kills his cat, Pluto. Then, a stray cat that looks almost exactly like the cat he murdered except for a gallows mark on its chest follows him home and drives him to become even more irrationally violent.");

        // thank you StacK ^-^ overflow - source: https://stackoverflow.com/questions/16819368/hashmap-in-java

        HashMap<String, String> mysteryAuthors = new HashMap<>();
        mysteryAuthors.put("Steven Berry", "THE TEMPLAR LEGACY:Cotton Malone, one-time top operative for the U.S. Justice Department, is enjoying his quiet new life as an antiquarian book dealer in Copenhagen when an unexpected call to action reawakens his hair-trigger instincts—and plunges him back into the cloak-and-dagger world he thought he'd left behind.");
        mysteryAuthors.put("Dale Brown", "DAY OF THE CHEETAH:Patrick McLanahan takes on his most perilous assignment since The Flight of the Old Dog. The odds are against him. His aircraft, the Cheetah, hasn't the speed, the power, or the technology of the DreamStar—his skills behind the stick are the only advantage he's got.");

        HashMap<String, String> adventureAuthors = new HashMap<>();
        adventureAuthors.put("Ernest Hemingway", "or Whom the Bell Tolls (1940) is a novel by the Modernist American author Ernest Hemingway. The novel tells the story of Robert Jordan, an American volunteer working as a demolition specialist for the Republican army during the Spanish Civil War. Robert, sent to blow up a bridge to aid a Republican offensive, enlists the aid of a band of guerrilla fighters in the mountains. Robert falls in love with a woman in their care, Maria, and experiences the difficulties of wartime relationships as love and war grow alongside each other.");
        adventureAuthors.put("Robert Louis Stevenson", "TREASURE ISLAND:Is the story of a twelve-year-old boy, Jim Hawkins, who finds a treasure map that belonged to a pirate, Captain Flint. Jim and his friends travel to a faraway island and meet ex-crew members of Captain Flint, who were also looking for the treasure and take Jim as a hostage.");

        // thank you stack overflow - source: https://stackoverflow.com/questions/16819368/hashmap-in-java

        // List of available genres
        String[] genres = new String[] {"Horror", "Mystery", "Adventure"};

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);
        String chosenGenre;
        HashMap<String, String> chosenAuthors = null;
        int attempts = 0;

        // Loop until a valid genre is chosen or the maximum number of attempts is reached
        while (attempts < 3) {
            System.out.println("Choose a genre:");

            // Print the available genres
            for (String genre : genres) {
                System.out.println(genre);
            }

            System.out.println(" ");

            // Get the user's chosen genre
            chosenGenre = scan.nextLine();

            System.out.println(" ");

            System.out.println("You've just chosen " + chosenGenre + "" + " as your genre.");

            System.out.println(" ");

            // Check the chosen genre and assign the corresponding authors to the chosenAuthors HashMap
            if (chosenGenre.equalsIgnoreCase("mystery")) {
                System.out.println("Authors in mystery genre:");
                chosenAuthors = mysteryAuthors;
                break;
            } else if (chosenGenre.equalsIgnoreCase("horror")) {
                System.out.println("Authors in horror genre:");
                chosenAuthors = horrorAuthors;
                break;
            } else if (chosenGenre.equalsIgnoreCase("adventure")) {
                System.out.println("Authors in adventure genre:");
                chosenAuthors = adventureAuthors;
                break;
            } else {
                System.out.println("I couldn't find the genre. Please try again.");
                attempts++;
            }
        }

        // If the maximum number of attempts is reached, ask the user if they want to end the program
        if (attempts == 3) {
            System.out.println("I still can't verify that as a genre. Do you want to end the program? (yes/no)");
            String endProgram = scan.nextLine();
            if (endProgram.equalsIgnoreCase("yes")) {
                return;
            } else {
                attempts = 0;
            }
        }

        // If a valid genre was chosen, print the authors of that genre
        if (chosenAuthors != null) {
            for (String author : chosenAuthors.keySet()) {
                System.out.println(author);
            }
        }

        System.out.println(" ");
        System.out.println("Please insert desired author name:");

        String chosenAuthor;
        attempts = 0;

        // Loop until a valid author is chosen or the maximum number of attempts is reached
        while (attempts < 3) {
            chosenAuthor = scan.nextLine();
            System.out.println(" ");

            // Check if the chosen author is in the chosenAuthors HashMap
            if (chosenAuthors.containsKey(chosenAuthor)) {
                System.out.println("I found your author! Here is a simplified summary of their most popular book: " + chosenAuthors.get(chosenAuthor));
                break;
            } else {
                System.out.println("I couldn't find that. Please try again.");
                attempts++;
            }

            // If the maximum number of attempts is reached, ask the user if they want to end the program
            if (attempts == 3) {
                System.out.println("I still can't verify that as an author. Do you want to end the program? (yes/no)");
                String endProgram = scan.nextLine();
                if (endProgram.equalsIgnoreCase("yes")) {
                    return;
                } else {
                    attempts = 0;
                }
            }
        }
    }
}
