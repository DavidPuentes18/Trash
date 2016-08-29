package models;

import java.util.Scanner;

public class MusicPlayer{

	private Scanner scanner;
	private Scanner scannerr;
	private Song [] songList;
	private User [] userList;
	private User [] adminList;
	private User userNow;
	private boolean menuIndicatorStart;
	private boolean menuIndicatorAdmin;
	private boolean menuIndicatorUser;
	private boolean menuIndicatorEditSong;
	private boolean menuIndicatorSearchSong;
	public static final int ERROR = -1;
	public static final int MAX_SONGS = 20;
	public static final int MAX_SONGS_SEARCH = 20;
	public static final int MAX_USERS = 5;
	public static final int MAX_ADMIN = 1;
	public static final String YES_OPTION = "Y";

	public MusicPlayer(){
		userNow = null;
		menuIndicatorStart = true;
		menuIndicatorAdmin = true;
		menuIndicatorUser = true;
		menuIndicatorEditSong = true;
		menuIndicatorSearchSong = true;
		scanner = new Scanner(System.in);
		scannerr = new Scanner(System.in);
		userList = new User[MAX_USERS];
		adminList = new User[MAX_ADMIN];
		songList = new Song[MAX_SONGS];
		userList[0] = new User("Admin", "Admin123", (CategoryUser.ADMIN));
		userList[1] = new User("Prueba", "Prueba123", (CategoryUser.NORMAL));
		songList[0] = new Song("Que Lloro", "Sin Bandera", (CategoryEvent.DRINKING), (CategoryEmotion.SAD));		
		songList[1] = new Song("Te Vi Venir", "Sin Bandera", (CategoryEvent.DRINKING), (CategoryEmotion.SAD));		
		songList[2] = new Song("I'll Be Wating", "Lenny Kravitz", (CategoryEvent.WORK), (CategoryEmotion.SAD));		
		songList[3] = new Song("American Woman", "Lenny Kravitz", (CategoryEvent.WORK), (CategoryEmotion.SAD));		
		songList[4] = new Song("The Pretender", "Foo Figthers", (CategoryEvent.WORK), (CategoryEmotion.HAPPY));		
		songList[5] = new Song("Learn To Fly", "Foo Figthers", (CategoryEvent.WORK), (CategoryEmotion.HAPPY));		
		songList[6] = new Song("La Leyenda Del Hada Y El Mago", "Rata Blanca", (CategoryEvent.RELAX), (CategoryEmotion.HAPPY));		
		songList[7] = new Song("Chico Callejero", "Rata Blanca", (CategoryEvent.RELAX), (CategoryEmotion.HAPPY));		
		songList[8] = new Song("BYOB", "System Of A Down", (CategoryEvent.GYM), (CategoryEmotion.EXCITED));		
		songList[9] = new Song("Spiders", "System Of A Down", (CategoryEvent.GYM), (CategoryEmotion.EXCITED));		
		songList[10] = new Song("Hello", "OMFG", (CategoryEvent.SLEEP), (CategoryEmotion.EXCITED));		
		songList[11] = new Song("Bangarang", "Skrillex", (CategoryEvent.SLEEP), (CategoryEmotion.EXCITED));		
		songList[12] = new Song("Maldita Traicion", "ALZATE", (CategoryEvent.DRINKING), (CategoryEmotion.ANGRY));		
		songList[13] = new Song("Ni Que Estuvieras Tan Buena", "ALZATE", (CategoryEvent.DRINKING), (CategoryEmotion.ANGRY));		
		songList[14] = new Song("Wake Up", "Suicide Silence", (CategoryEvent.GYM), (CategoryEmotion.ANGRY));		
		songList[15] = new Song("Sweet Blasfemy", "Suicide Silence", (CategoryEvent.GYM), (CategoryEmotion.ANGRY));		
		songList[16] = new Song("Caracol", "Perota Chingo", (CategoryEvent.RELAX), (CategoryEmotion.INSPIRED));		
		songList[17] = new Song("Tia Lula", "Perota Chingo", (CategoryEvent.RELAX), (CategoryEmotion.INSPIRED));		
		songList[18] = new Song("In The Hall Of Mountain", "Kevin McLend", (CategoryEvent.SLEEP), (CategoryEmotion.INSPIRED));		
		songList[19] = new Song("Spring", "Vivaldi", (CategoryEvent.SLEEP), (CategoryEmotion.INSPIRED));		
	}
//Menu de Inicio
	public void startMenu(){
		while (menuIndicatorStart) {
			System.out.println("");
			System.out.println(" M U S I C  P L A Y E R  2 . 0");
			System.out.println("Choose what do you do");
			System.out.println("");
			System.out.println(" [1] Register user\n [2] Login User\n [3] Exit");
			int userInput = scanner.nextInt();
			switch (userInput) {
				case 1:
					registerUser();
					break;
				case 2:
					loginUser();
					break;
				case 3:
					System.out.println("");
					System.out.println("--- B Y E ---");
					menuIndicatorStart = false;
					return;
				default:
					System.out.println("Enter the election again");
			}
		}
	}
//Menu modo administrador
	public void menuAdmin(){
		while (menuIndicatorAdmin) {
			System.out.println("");
			System.out.println("--------Admin Version--------");
			System.out.println(" M U S I C  P L A Y E R  2 . 0");
			System.out.println("Choose what do you do");
			System.out.println("");
			System.out.println(" [1] Delete User\n [2] Add Song\n [3] Delete Song\n [4] Edit Song\n [5] Print User List\n [6] Print Songs List\n [7] Song most play\n [8] Sing Out\n [9] Exit");
			int userInput = scanner.nextInt();
			switch (userInput) {
				case 1:
					deleteUser();
					break;
				case 2:
					addSong();
					break;
				case 3:
					deleteSong();
					break;
				case 4:
					menuEditSong();
					break;
				case 5:
					printUsers();
					break;
				case 6:
					printSongs();
					break;
				case 7:
					System.out.println(getMostPlay());
					break;
				case 8:
					return;
				case 9:
					System.out.println("");
					System.out.println("--- B Y E ---");
					menuIndicatorAdmin = false;
					menuIndicatorStart = false;
					return;
				default:
					System.out.println("Enter the election again");
			}
		}
	}
//Menu modo usuario normal
	public void menuUser(){
		while (menuIndicatorUser) {
			System.out.println("");
			System.out.println(" M U S I C  P L A Y E R  2 . 0");
			System.out.println("Choose what do you do");
			System.out.println("");
			System.out.println(" [1] Search Song\n [2] Play Song\n [3] Create a PlayList\n [4] Play a PlayList\n [5] Sing Out\n [6] Exit");
			int userInput = scanner.nextInt();
			switch (userInput) {
				case 1:
					searchSongMenu();
					break;
				case 2:
					playSong();
					break;
				case 3:
					createPlayList();
					break;
				case 4:
					playList();
					break;
				case 5:
					return;
				case 6:
					System.out.println("");
					System.out.println("--- B Y E ---");
					menuIndicatorUser = false;
					menuIndicatorStart = false;
					return;
				default:
					System.out.println("Enter the election again");
			}
		}
	}
//Menu buscar cancion
	public Song searchSongMenu(){
		while (menuIndicatorSearchSong) {
			System.out.println("");
			System.out.println("Choose how do you want search the song");
			System.out.println("");
			System.out.println(" [1] Name\n [2] Performer\n [3] Category Event\n [4] Category Emotion\n [5] Back");
			int userInput = scanner.nextInt();
			switch (userInput) {
				case 1:
					return searchSongWithName();
				case 2:
					return searchSongWithPerformer();
				case 3:
					return searchSongWithCategoryEvent();
				case 4:
					return searchSongWithCategoryEmotion();
				case 5:
					return null;
				default:
					System.out.println("Enter the election again");
			}
		}
		return null;
	}
//Registrar Usuario
	public void registerUser(){
		scanner = new Scanner(System.in);
		System.out.println("ENTER YOUR NEW NICK");
		String userNameInput = scanner.nextLine();
		System.out.println("ENTER YOUR NEW PASSWORD");
		String userPassInput = scanner.nextLine();
		for (int i = 0; i < userList.length; i++) {
			if (userList[i] == null) {
				userList[i] = new User(userNameInput, userPassInput, (CategoryUser.NORMAL));
				return;
			}
		}
		System.out.println("No more Users");
	}
//Logear Usuario
	public User loginUser(){
		scanner = new Scanner(System.in);
		System.out.println("ENTER YOUR NICK");
		String userNameInput = scanner.nextLine();
		for (User user: userList) {
			if (user != null) {
				if(userNameInput.equals(user.getName())){
					System.out.println("ENTER YOUR PASSWORD");
					String userPassInput = scanner.nextLine();
					if (userPassInput.equals(user.getPassword())) {
						if (user.getCategoryUser() == (CategoryUser.ADMIN)) {
							System.out.println("");
							System.out.println("---Loged Admin---");
							menuAdmin();
							return user;
						}else if (user.getCategoryUser() == (CategoryUser.NORMAL)){
							System.out.println("");
							System.out.println("---Loged---");
							userNow = user;
							menuUser();
							return userNow; 
						}					
					}else{
						System.out.println("");
						System.out.println("Password Invalid");
						return null;
					}
				}
			}
		}
		System.out.println("");
		System.out.println("User invalid");
		return null;
	}
//Borrar Usuario
	public void deleteUser(){
		scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("ENTER THE POSITION OF USER TO DELETE");
		printUsers();
		int deleteUser = scanner.nextInt();
		if (deleteUser == 0) {
			deleteUser();
		}else{
			for (int i = 0; i < userList.length; i++) {
				if (userList[deleteUser] != null) {
					System.out.println("The User " + userList[deleteUser].getName() + " has been delete");
					userList[deleteUser] = null;
				}
			}
		}		
	}
//Escuchar una cancion (aumenta contador plays)	
	public void playSong(){
		Song song = searchSongMenu();
		if (song != null) {
			song.incrasePlays();
		}
	}
//Crear Play List
	public void createPlayList(){
		boolean indicator = true;
		while(indicator){
			Song song = null;
			System.out.println("Add a new song to your playlist? (Y/N)");
			String electionUser = scanner.next();
			if (electionUser.contains(YES_OPTION)) {
				song = searchSongMenu();
				userNow.addSongPlayList(song);
			} else{
				indicator = false;
				return;
			}		
		}	
	}
//Play list(aumenta contador plays en la lista)
	public void playList(){
		if (userNow.getPlayListComprobation() == true) {
			userNow.getPlayList();
			System.out.println("Number or plays of this playlist: " + userNow.getPlays());
		} else{
			System.out.println("You dont have play list");
		}		
	}
//Buscar cancion con el nombre
	public Song searchSongWithName(){
		int position = 0;
		Song [] songListName = new Song[MAX_SONGS_SEARCH];
		scanner = new Scanner(System.in);
		System.out.println("Enter the name of the Song");
		String nameInputUser = scanner.nextLine();
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				if (songList[i].getName().contains(nameInputUser)) {
					songListName[position] = songList[i];
					position++;
				}
			}
		}	
		return chooseSongName(songListName);
	}
//Escoger cancion name
	public Song chooseSongName(Song [] songListName){
		Song songName = null;
		System.out.println("Enter the position of song");
		for (int i = 0; i < songListName.length; i++){ 
			if (songListName[i] != null) {
				System.out.println("[" + i + "] " + songListName[i]);
			}
		}
		int position = scanner.nextInt();
		return songName = songListName[position];
	}
//Buscar cancion con el performer
	public Song searchSongWithPerformer(){
		int position = 0;
		Song [] songListPerformer = new Song[MAX_SONGS_SEARCH];
		scanner = new Scanner(System.in);
		System.out.println("Enter the name of the Performer");
		String performerInputUser = scanner.nextLine();
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				if (songList[i].getPerformer().contains(performerInputUser)) {
					songListPerformer[position] = songList[i];
					position++;
				}
			}
		}
		return chooseSongPerformer(songListPerformer);
	}
//Escoger cancion name
	public Song chooseSongPerformer(Song [] songListPerformer){
		Song songPerformer = null;
		System.out.println("Enter the position of song");
		for (int i = 0; i < songListPerformer.length; i++){ 
			if (songListPerformer[i] != null) {
				System.out.println("[" + i + "] " + songListPerformer[i]);
			}
		}
		int position = scanner.nextInt();
		return songPerformer = songListPerformer[position];
	}
//Buscar cancion con la emotion category 
	public Song searchSongWithCategoryEvent(){
		int position = 0;
		Song [] songListEvent = new Song[MAX_SONGS_SEARCH];
		CategoryEvent eventUserInput = selectEventCategory();
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				if (songList[i].getCategoryEvent() == eventUserInput) {
					songListEvent[position] = songList[i];
					position++;
				}
			}
		}
		return chooseSongEvent(songListEvent);
	}
//Escoger cancion category event
	public Song chooseSongEvent(Song [] songListEvent){
		Song songCategoryEvent = null;
		System.out.println("Enter the position of song");
		for (int i = 0; i < songListEvent.length; i++){ 
			if (songListEvent[i] != null) {
				System.out.println("[" + i + "] " + songListEvent[i]);
			}
		}
		int position = scanner.nextInt();
		return songCategoryEvent = songListEvent[position];
	} 
//Buscar cancion con la emotion category
	public Song searchSongWithCategoryEmotion(){
		int position = 0;
		Song [] songListEmotion = new Song[MAX_SONGS_SEARCH];
		CategoryEmotion emotionUserInput = selectEmotionCategory();
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				if (songList[i].getCategoryEmotion() == emotionUserInput) {
					songListEmotion[position] = songList[i];
					position++;
				}
			}
		}
		return chooseSongEmotion(songListEmotion);
	}
//Escoger cancion category emotion
	public Song chooseSongEmotion(Song [] songListEmotion){
		Song songCategoryEmotion = null;
		System.out.println("Enter the position of song");
		for (int i = 0; i < songListEmotion.length; i++){ 
			if (songListEmotion[i] != null) {
				System.out.println("[" + i + "] " + songListEmotion[i]);
			}
		}
		int position = scanner.nextInt();
		return songCategoryEmotion = songListEmotion[position];
	}
//Agregar Cancion
	public void addSong(){
		scanner = new Scanner(System.in);
		CategoryEmotion categoryEmotion = null;
		CategoryEvent categoryEvent = null;
		System.out.println("Enter the name");
		String nameSong = scanner.nextLine();
		System.out.println("Enter the performer");
		String performerSong = scanner.nextLine();
		categoryEmotion = selectEmotionCategory();
		categoryEvent = selectEventCategory();
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] == null) {
				songList[i] = new Song(nameSong, performerSong, categoryEvent, categoryEmotion);
				return;
			}
		}
		System.out.println("Collection is full");
	}
//Selectionar categoria emotion (metodo usado en addSong(), editSong())
	public CategoryEmotion selectEmotionCategory(){
		CategoryEmotion categoryEmotion = null;
		System.out.println("Enter the category of emotion");
		System.out.println(" [1] SAD\n [2] HAPPY\n [3] EXCITED\n [4] ANGRY\n [5] INSPIRED");
		int categoryEmotionElection = scanner.nextInt();
		switch (categoryEmotionElection){
			case 1:
				categoryEmotion = (CategoryEmotion.SAD);
				break;
			case 2:
				categoryEmotion = (CategoryEmotion.HAPPY);
				break;
			case 3:
				categoryEmotion = (CategoryEmotion.EXCITED);
				break;
			case 4:
				categoryEmotion = (CategoryEmotion.ANGRY);
				break;
			case 5:
				categoryEmotion = (CategoryEmotion.INSPIRED);
				break;
			default:
				System.out.println("Enter the election again");
		}
		return categoryEmotion;
	}
//Selectionar categoria event (metodo usado en addSong(), editSong())
	public CategoryEvent selectEventCategory(){
		CategoryEvent categoryEvent = null;
		System.out.println("Enter the category of event");
		System.out.println(" [1] DRINKING\n [2] RELAX\n [3] GYM\n [4] SLEEP\n [5] WORK");
		int categoryEventElection = scanner.nextInt();
		switch (categoryEventElection){
			case 1:
				categoryEvent = (CategoryEvent.DRINKING);
				break;
			case 2:
				categoryEvent = (CategoryEvent.RELAX);
				break;
			case 3:
				categoryEvent = (CategoryEvent.GYM);
				break;
			case 4:
				categoryEvent = (CategoryEvent.SLEEP);
				break;
			case 5:
				categoryEvent = (CategoryEvent.WORK);
				break;
			default:
				System.out.println("Enter the election again");
		}
		return categoryEvent;
	}
//Borrar cancion
	public void deleteSong(){
		System.out.println("Enter the position of song to delelete");
		printSongs();
		int deleteSong = scanner.nextInt();
		if (songList[deleteSong] != null) {
			System.out.println("The Song " + songList[deleteSong].getName() + " has been delete");
			songList[deleteSong] = null;
		}else{
			System.out.println("This position is empty.");
		}	
	}
//Menu editar cancion
	public void menuEditSong(){
		while (menuIndicatorEditSong) {
			System.out.println("");
			System.out.println("Choose do you want to edit");
			System.out.println(" [1] Edit name\n [2] Edit performer\n [3] Edit Category Emotion\n [4] Edit Category Event\n [5] Back");
			int userInput = scanner.nextInt();
			switch (userInput) {
				case 1:
					editNameSong();
					break;
				case 2:
					editPerformerSong();
					break;
				case 3:
					editEventSong();
					break;
				case 4:
					editEmotionSong();
					break;
				case 5:
					menuIndicatorEditSong = false;
					return;
				default:
					System.out.println("Enter the election again :V");
			}
		}
	}
//Obtener la posicion de la cancion a editar
	public int getPositionToEdit(){
		System.out.println("Enter the position of song to edit");
		printSongs();
		int editSong = ERROR;
		editSong = scanner.nextInt();
		if (songList[editSong] != null) {
			System.out.println(songList[editSong]);
			return editSong;
		}else{
			System.out.println("This position is empty.");
			editSong = ERROR;
		}
		return editSong;
	}
//Editar nombre cancion
	public void editNameSong(){
		scannerr = new Scanner(System.in);
		int position = getPositionToEdit();
		System.out.println("");
		System.out.println("Enter the new name");
		String newNameSong = scannerr.nextLine();
		songList[position] = new Song(newNameSong, songList[position].getPerformer(), songList[position].getCategoryEvent(), songList[position].getCategoryEmotion()); 
		System.out.println(songList[position]);
	}
//Editar performer cancion
	public void editPerformerSong(){
		scannerr = new Scanner(System.in);
		int position = getPositionToEdit();
		System.out.println("");
		System.out.println("Enter the new performer");
		String newPerformerSong = scannerr.nextLine();
		songList[position] = new Song(songList[position].getName(), newPerformerSong, songList[position].getCategoryEvent(), songList[position].getCategoryEmotion()); 
		System.out.println(songList[position]);
	}
//Editar event cancion
	public void editEventSong(){
		int position = getPositionToEdit();
		System.out.println("");
		System.out.println("Enter the new event");
		songList[position] = new Song(songList[position].getName(), songList[position].getPerformer(), selectEventCategory(), songList[position].getCategoryEmotion()); 
		System.out.println(songList[position]);
	}
//Editar emotion cancion
	public void editEmotionSong(){
		int position = getPositionToEdit();
		System.out.println("");
		System.out.println("Enter the new emotion");
		songList[position] = new Song(songList[position].getName(), songList[position].getPerformer(), songList[position].getCategoryEvent(), selectEmotionCategory()); 
		System.out.println(songList[position]);
	}
//Imprimir lista de canciones
	public void printSongs(){
		for (int i = 0; i < songList.length; i++){ 
			if (songList[i] != null) {
				System.out.println("[" + i + "] " + songList[i] + " Plays: " + songList[i].getPlays());
			}else{
				System.out.println("---");
			}
		}
	}
//Imprimir lista de usuarios
	public void printUsers(){
		for (int i = 1; i < userList.length; i++) {
			if (userList[i] != null) {
				System.out.println("[" + i + "]" + userList[i]);
			}else{
				System.out.println("---");
			}
		}
	}
//Analizar cual es la cancion mas escuchada
	public Song getMostPlay(){
		int pos = getFirstSong();
		Song song = null;
		if (pos != ERROR) {
			song = songList[pos];
			for (int i = pos + 1; i < songList.length; i++) {
				if (songList[i] != null) {
					if (song.getPlays() < songList[i].getPlays()) {
						song = songList[i];
					}
				}
			}
		}
		return song;
	}
//Obtener objeto desde donde analizar
	public int getFirstSong(){
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				return i;
			}
		}
		return ERROR;
	}
//Main
	public static void main(String[] args) {
		MusicPlayer play = new MusicPlayer();
		play.startMenu();
	}
}