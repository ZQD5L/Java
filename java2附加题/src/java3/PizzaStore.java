package java3;

public class PizzaStore {
	public SimplePizzaFactory sim;
	public PizzaStore(){
		sim=new SimplePizzaFactory();
	}
	
	public Pizza orderPizza(String type){
		Pizza pizza=sim.createPizza(type);
		if(pizza!=null){
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		}
		return pizza;
		
	}

}
