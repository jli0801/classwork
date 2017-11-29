package pokemon;

import java.util.logging.Level;

public class Pokemon {

	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	public Pokemon(String name, int level) {
	this.name = name;
	this.level = level;
	hp = 100;
	poisoned  = false;
	}

	public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 
		 squirtle.attack(bulbasaur, new Attack() {
			 public void attack(Pokemon target)
			 {
			 int hp = target.getHp();
			 target.setHp(hp/2);
			 }
		 });
		 
		 System.out.println("Bulbasaur is preparing to attack!");
		 bulbasaur.attack(squirtle, new Attack() {
			 public void attack(Pokemon target)
			 {
			target.setPoisoned(true);
			 }
		 });
		 
		 squirtle.lapse();
		 bulbasaur.lapse();
		 squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHp();
				 target.setHp(hp-100);
				
			}
		});
		 
		squirtle.levelUp(new Effect() {
			
			public void happen() {
				squirtle.setHp(100);
				//final if you want to modify a reference outside of body
			}
			
		});
		//ctrl space 
		 

	}
	
	public void levelUp(Effect e)
	{
		level++;
		e.happen();
	}
	
	private void iChooseYou()
	{
		System.out.println(name + ", " + name + "!");
	}
	

	public String getName() {
		return name;
	}

	public void setHp(int newHP) {
		this.hp = newHP;
	}

	public void setPoisoned(boolean b) {
		this.poisoned = poisoned;
	}
	public void lapse()
	{
		if(poisoned)
		{
			setHp(hp -15);
		}
	}

	public int getHp() {
		return hp;
	}

	public boolean isPoisoned() {
		return poisoned;
	}
	 public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
		 }
}
