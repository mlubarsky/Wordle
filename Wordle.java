import java.util.Scanner;
import java.util.Random;
import java.lang.StringBuilder;

public class Wordle {
	static String wordList[] = {
	"Abuse","Adult","Agent","Anger","Apple","Award","Basis","Beach","Birth","Block","Blood","Board","Brain","Bread","Break","Brown","Buyer",
	"Cause","Chain","Chair","Chest","Chief","Child","Claim","Class","Clock","Coach","Coast","Court","Cover","Cream","Crime","Cross","Cling",
	"Crowd","Crown","Cycle","Dance","Death","Depth","Doubt","Draft","Drama","Dream","Dress","Drink","Drive","Earth","Enemy","Entry","Error",
	"Event","Faith","Fault","Field","Fight","Final","Floor","Focus","Force","Frame","Front","Fruit","Glass","Grant","Grass","Green","Group",
	"Guide","Heart","Horse","Hotel","House","Image","Index","Input","Issue","Japan","Jones","Judge","Knife","Layer","Level","Light","Limit",
	"Lunch","Major","March","Match","Metal","Model","Money","Month","Motor","Mouth","Music","Night","Noise","North","Novel","Nurse","Offer",
	"Order","Other","Owner","Panel","Paper","Party","Peace","Phase","Phone","Piece","Pilot","Pitch","Place","Plane","Plant","Plate","Point",
	"Pound","Power","Press","Price","Pride","Prize","Proof","Queen","Radio","Range","Ratio","Reply","Right","River","Round","Route","Rugby",
	"Scale","Scene","Scope","Score","Sense","Shape","Share","Sheep","Sheet","Shift","Shirt","Shock","Sight","Simon","Skill","Sleep","Smile",
	"Smith","Smoke","Sound","South","Space","Speed","Spite","Sport","Squad","Staff","Stage","Start","State","Steam","Steel","Stock","Stone",
	"Store","Study","Stuff","Style","Sugar","Table","Taste","Theme","Thing","Title","Total","Touch","Tower","Track","Trade","Train","Trend",
	"Trial","Trust","Truth","Uncle","Union","Unity","Value","Video","Visit","Voice","Waste","Watch","Water","While","White","Whole","Woman",
	"World","Youth","Admit","Adopt","Agree","Allow","Alter","Apply","Argue","Arise","Avoid","Begin","Blame","Break","Bring","Build","Burst",
	"Carry","Catch","Cause","Check","Claim","Clean","Clear","Climb","Close","Count","Cover","Cross","Dance","Doubt","Drink","Drive","Enjoy",
	"Enter","Exist","Fight","Focus","Force","Guess","Imply","Issue","Judge","Laugh","Learn","Leave","Limit","Marry","Match","Occur","Offer",
	"Order","Phone","Place","Point","Press","Prove","Raise","Reach","Refer","Relax","Serve","Shall","Share","Shift","Shoot","Sleep","Solve",
	"Sound","Speak","Spend","Split","Stand","Start","State","Stick","Study","Teach","Thank","Think","Throw","Touch","Train","Treat","Trust",
	"Visit","Voice","Waste","Watch","Worry","Would","Write","Above","Acute","Alive","Alone","Angry","Aware","Awful","Basic","Black","Blind",
	"Brave","Brief","Broad","Brown","Cheap","Chief","Civil","Clean","Clear","Close","Crazy","Daily","Dirty","Early","Empty","Equal","Exact",
	"Extra","Faint","False","Fifth","Final","First","Fresh","Front","Funny","Giant","Grand","Great","Green","Gross","Happy","Harsh","Heavy",
	"Human","Ideal","Inner","Joint","Large","Legal","Level","Light","Local","Loose","Lucky","Magic","Major","Minor","Moral","Nasty","Naval",
	"Other","Outer","Plain","Prime","Prior","Proud","Quick","Quiet","Rapid","Ready","Right","Roman","Rough","Round","Royal","Rural","Sharp",
	"Sheer","Short","Silly","Sixth","Small","Smart","Solid","Sorry","Spare","Steep","Still","Super","Sweet","Thick","Third","Tight","Total",
	"Tough","Upper","Upset","Urban","Usual","Vague","Valid","Vital","White","Whole","Wrong","Young",
	};
  
	/*
	* @param args input arguments
	*/ 
	public static boolean checker(StringBuilder currentResult, String secret) {
		secret = secret.toUpperCase();

		for (int x = 0; x < currentResult.length(); x++) {
			  if (currentResult.charAt(x) != secret.charAt(x)) {
				  return false;
			  }
		  }
		  return true;
 	}

  	public static void main(String[] args) {

     	System.out.println("Welcome to...");
     	System.out.println();
     	System.out.println(" __      __                .___.__          ");
	System.out.println("/  \\    /  \\___________  __| _/|  |   ____  ");
	System.out.println("\\   \\/\\/   /  _ \\_  __ \\/ __ | |  | _/ __ \\ ");
	System.out.println(" \\        (  <_> )  | \\/ /_/ | |  |_\\  ___/ ");
	System.out.println("  \\__/\\  / \\____/|__|  \\____ | |____/\\___ \\");
	System.out.println("       \\/                   \\/           \\/ ");
	System.out.println();
	 
	Scanner scnr = new Scanner(System.in);
	Random rand = new Random();
     	String wordFromList = wordList[rand.nextInt(404)];  // picks random word from array as word to be guessed
     	String secret = wordFromList.toLowerCase();
     	StringBuilder guessResult = new StringBuilder("-----");
     	StringBuilder secretResult = new StringBuilder(secret);
     	//System.out.println("ssssh! For debugging purposes ... the secret word selected is: " + secretResult + "\n");
	String guess = "";
	int triesLeft = 6;
	int attemptCnt = 1;
	 
		while (triesLeft != 0) {
			System.out.println("Enter your word guess: ");
			guess = scnr.nextLine();
			guessResult = new StringBuilder("-----");
			secretResult = new StringBuilder(secret);
			if (guess.length() != 5) {
				while (guess.length() != 5) {
					System.out.println("Error. This word is not 5 letters.");
					System.out.println("Enter your word guess: ");
					guess = scnr.nextLine();
					guessResult = new StringBuilder("-----");
					secretResult = new StringBuilder(secret);
				}
			} 
			for (int i = 0; i < guess.length(); i++) {
				if ((int)guess.charAt(i) < 97 || (int)guess.charAt(i) > 122) {
					while ((int)guess.charAt(i) < 97 || (int)guess.charAt(i) > 122) {
						System.out.println("Error. This not a valid word");
						System.out.println("Enter your word guess: ");
						guess = scnr.nextLine();
						guessResult = new StringBuilder("-----");
						secretResult = new StringBuilder(secret);
					}
				}
			}
			if (guess.length() == 5) {
				for (int s = 0; s < secret.length(); s++) {
					for (int g = 0; g < guess.length(); g++) {
						if (guess.charAt(g) == secretResult.charAt(s) && g == s) {
							guessResult.setCharAt(g, (char)(((int)(guess.charAt(s)) - 32)));
							secretResult.setCharAt(g, '$');
						}	
					}
				}
				for (int s = 0; s < secret.length(); s++) {
					for (int g = 0; g < guess.length(); g++) {
						if (guess.charAt(g) == secretResult.charAt(s) && secretResult.charAt(g) != '$') {
							guessResult.setCharAt(g, guess.charAt(g));
							secretResult.setCharAt(s, '*');
						}
					}
				}
			} if (checker(guessResult, secret)) {
				if (attemptCnt == 1) {
					System.out.println(guessResult);
					System.out.println("Congrats! You solved the problem in " + attemptCnt + " try! ");
					break;
				} else {
					System.out.println(guessResult);
					System.out.println("Congrats! You solved the problem in " + attemptCnt + " tries! ");
					break;
				}
			}
			System.out.println(guessResult);
			triesLeft = triesLeft - 1;
			attemptCnt = attemptCnt + 1;
			System.out.println(triesLeft + " attempts left.");
		}
		if (!checker(guessResult, secret)) {
			System.out.println("You ran out of tries. The secret word was \"" + secret + "\".");
		}
	}		
}
