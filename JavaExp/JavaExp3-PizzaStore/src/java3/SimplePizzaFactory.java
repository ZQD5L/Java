package java3;

public class SimplePizzaFactory {
	public Pizza createPizza(String type){
		if(type=="cheese"){
			Pizza a=new CheesePizza();
			return a;
		}else if(type=="pepperoni"){
			Pizza a=new PepperoniPizza();
			return a;
		}else if(type=="clam"){
			Pizza a=new ClamPizza();
			return a;
		}else{
			Pizza a=null;
			System.out.println(" ‰»Î¥ÌŒÛ");
			return a;
		}
	}

}
