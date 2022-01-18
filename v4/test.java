public class test{
	public static void main(String[] args){
		//Protagonist pat = new Character();
		//doesn't


		//Character pat = new Protagonist();
		//works

		Object a = new Monk();
		System.out.println(((Monk)a).about());
	}

}
