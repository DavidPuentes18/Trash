package models;

public class User{

	private String name;
	private String password;
	private CategoryUser categoryUser;
	private Song [] playList;
	private int plays;
	public static final int MAX_SONGS_PLAYLIST = 10;

	public User(String name, String password, CategoryUser categoryUser){
		playList = new Song[MAX_SONGS_PLAYLIST];
		this.name = name;
		this.password = password;
		this.categoryUser = categoryUser;
	}

	public String getName(){
		return name;
	}

	public String getPassword(){
		return password;
	}
	public CategoryUser getCategoryUser(){
		return categoryUser;
	}

	public Song addSongPlayList(Song song){
		for (int i = 0; i < playList.length; i++) {
			if (playList[i] == null) {
				playList[i] = new Song(song.getName(), song.getPerformer(), song.getCategoryEvent(), song.getCategoryEmotion());
				return playList[i];
			}
		}
		return null;
	}

	public boolean getPlayListComprobation(){
		if (playList[0] == null) {
			return false;
		}
		return true;
	}

	public void getPlayList(){
		plays++;
		for (Song song: playList) {
			if (song != null) {
				System.out.println(song);
			}else{
				System.out.println("---");
			}
		}
	}

	public int getPlays(){
		return plays;
	}

	@Override
	public String toString(){
		return "[" + name + "/Category: " + categoryUser + "]";
	}
}