package models;

public class Song{
	
	private String name;
	private String performer;
	private CategoryEvent categoryEvent;
	private CategoryEmotion categoryEmotion;
	private int plays;

	public Song(String name, String performer, CategoryEvent categoryEvent, CategoryEmotion categoryEmotion){
		this.name = name;
		this.performer = performer;
		this.categoryEvent = categoryEvent;
		this.categoryEmotion = categoryEmotion;
		plays = 0;
	}

	public String getName(){
		return name;
	}	

	public String getPerformer(){
		return performer;
	}

	public CategoryEvent getCategoryEvent(){
		return categoryEvent;
	}	

	public CategoryEmotion getCategoryEmotion(){
		return categoryEmotion;
	}

	public int incrasePlays(){
		plays++;
		return plays;
	}

	public int getPlays(){
		return plays;
	}

	@Override
	public String toString(){
		return "[" + name + " - " + performer + " #Event: " + categoryEvent + " #Emotion: " + categoryEmotion + "]";
	}
}