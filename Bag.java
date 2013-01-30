import java.util.Random;
/*
 * This class is used to create a Bag object with a specific name and size.
 * The name and size are specified by the user.
 * 
 * The bag only has the capability of holding integer values. The default values for
 * all integers upon creation of the bag is zero. Zeros are empty values in the bag.
 * 
 * The user is given the ability to modify their bag via adding or removing integers 
 * in the bag with in a number of different ways.
 * 
 * Calin Gribble - 1/26/2013
 */

public class Bag{
  private String name;
	private int max;
	private int[] bagArray;
	private Random rand = new Random();
	
	/*
	 * Creates a custom bag by specifying the name and size of the Bag.
	 */
	public Bag(String name, int max){
		this.name = name;
		this.max  = max;
		this.bagArray = new int[this.max];
	}
	
	/*
	 * Creates a custom bag by joining two already existing bags.
	 */
	public Bag(String name, Bag aBag, Bag bBag){
		this.name = name;
		this.max  = aBag.size()+bBag.size();
		this.bagArray = new int[this.max];
		for (int i = 0; i < max; i++){
			if(i < aBag.size()){
				this.array()[i] = aBag.array()[i];
			}else{
				this.array()[i] = bBag.array()[i - aBag.size()];
			}
		}
	}
	
	/*
	 * Creates a default bag with the name 'defaultBag' and a size of 10.
	 */
	public Bag(){
		this.name = "defaultBag";
		this.max = 10; 
		this.bagArray = new int[max];
	}
	
	/*
	 * Returns the bag name.
	 */
	public String name(){
		return this.name;
	}
	
	/*
	 * Returns the size of the bag.
	 */
	public int size(){
		return this.max;
	}
	
	/*
	 * Returns the array containing the integers inside of the bag.
	 */
	public int[] array(){
		return this.bagArray;
	}
	
	/*
	 * Returns number of integers the bag currently contains.
	 */
	public int count(){
		int count = 0;
		for(int i = 0; i < this.size(); i++){
			if(this.array()[i] != 0){
				count++;
			}
		}
		return count;
	}
	
	/*
	 * Adds integer 'x' to the bag, 'y' amount of times.
	 */
	public void add(int x, int y){
		int temp = 0;
		for(int i = 0; i < this.size(); i++){
		 	if(this.count() >= this.size() || temp == y){
				break;
			}else if(this.array()[i] == 0){
			    this.array()[i] = x;
				temp++;
			}
			
		}
	}
	
	
	/*
	 * Removes integer 'x' from the bag, 'y' amount of times.
	 */
	public int remove(int x, int y){
		int temp = 0;
		for(int i = 0; i < this.size(); i++){
			if(this.array()[i] == x){
				this.array()[i] = 0;
				temp++;
				if(temp == y){
					break;
				}	
			}
		}
		if(temp == 0){
			return 0;
		}else{
			return 1;
		}
	}
	
	/*
	 * Adds random integer between '1 - x', 'y' amount of times.
	 */
	public void addRandom(int x, int y){
		int temp = 0;
		for(int i = 0; i < this.size(); i++){
			if(this.array()[i] == 0){
				this.array()[i] = rand.nextInt(x) + 1;
				temp++;
				if(this.count() >= this.size() || temp == y){
					break;
				}
			}else{
				break;
			}
		}
	}
	
	/*
	 * Removes random integer 'y' amount of times.
	 */
	public void removeRandom(int y){
		int x = 0;
		int i = 0;
		while(i < y){
			x = rand.nextInt(this.size());
			if(this.array()[x] != 0){
				this.array()[x] = 0;
				i++;
			}else if( this.count() == 0){
				break;
			}
		}	
	}
	
	/*
	 * Returns the sum of all integers in bag.
	 */
	public int sum(){
		int total = 0;
		for(int i = 0; i < this.size(); i++){
			total += this.array()[i];
		}
		return total;
	}
	
	
	/*
	 * Returns whether or not the bag is empty. This is never called in the GUI.
	 */
	public boolean isEmpty(){
		if(this.count() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * Returns how many of 'x' the bag contains.
	 */
	public int contains(int x){
		int amount = 0;
		for(int i = 0; i < this.size(); i++){
			if(this.array()[i] == x){
				amount++;
			}
		}				
		return amount;
	}
	
	/*
	 * Sets all values in the bag to 0.
	 */
	public void clear(){
		for(int i = 0; i < this.size(); i++){
			this.array()[i] = 0;
		}
	}

}
