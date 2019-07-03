package myjava.homework.Q1.part1;

class Monsters {
	
	private String name;
	private int health;
	
	public Monsters ( int health, String name) 
	{
		
		this.health = health;
		this.name = name;
	}
	public int  getDamage()
	{
		return 0;
	}
	public String getName(){
		return name;
	}
	public int getHealth(){
		return health;
	}
	public String toString ()
	{
		return "";
	}
	
}
class Gnome extends Monsters{

	public Gnome(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int  getDamage()
	{
		return 4;
	}
	public String toString (){
		return "Name: " + getName() +", Type: Gnome"  +", Heath: " + getHealth();
	}
	
}
class Elf extends Monsters{

	public Elf(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int  getDamage()
	{
		return 3;
	}
	public String toString (){
		return "Name: " + getName() +", Type: Elf"  +", Heath: " + getHealth();
	}
}
class Salamander extends Monsters{

	public Salamander(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int  getDamage()
	{
		return 6;
	}
	public String toString (){
		return "Name: " + getName() +", Type: Salamander"  +", Heath: " + getHealth();
	}
}
class LittleWitch extends Monsters{

	public LittleWitch(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int  getDamage()
	{
		return 1;
	}
	public String toString (){
		return "Name: " + getName() +", Type: LittleWitch"  +", Heath: " + getHealth();
	}
}
class Slime extends Monsters{

	public Slime(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int  getDamage()
	{
		return 2;
	}
	public String toString (){
		return "Name: " + getName() +", Type: Slime"  +", Heath: " + getHealth();
	}
}
class Wolf extends Monsters{

	public Wolf(int health, String name) {
		super(health, name);
		// TODO Auto-generated constructor stub
	}
	public int  getDamage()
	{
		return 5;
	}
	public String toString (){
		return "Name: " + getName() +", Type: Wolf"  +", Heath: " + getHealth();
	}
}





class MonstersPack
{
	private Monsters[] monsters;
	
	public MonstersPack (int monsterNum)
	{
		monsters = new Monsters[monsterNum];
	}
	
	public void addMonster (Monsters newMonster, int index)
	{
		monsters[index] = newMonster;
	}
	
	public Monsters[] getMosters ()
	{
		return monsters;
	}
	
	public int countDamage ()
	{
		int damage = 0;
		for (int i = 0; i < monsters.length; ++i)
		{
			damage += monsters[i].getDamage();
			
		}
		
		return damage;
	}
}