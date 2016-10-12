package bounswegroup3.model;

public class Menu {
	private Long id;
	private Long userId;
	private String name;
	
	public Menu(){
		
	}
	
	public Menu(Long id, Long userId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}