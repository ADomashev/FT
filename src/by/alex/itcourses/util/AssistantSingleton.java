package by.alex.itcourses.util;

public enum AssistantSingleton {
	ASSISTANT;
	
	private Assistant assistant;
	
	public Assistant getInstance() {
		if(assistant==null) {
		assistant = new Assistant();}
		return assistant;
	}
}
