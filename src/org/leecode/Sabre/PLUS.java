package org.leecode.Sabre;

public class PLUS {
	synchronized int method1() {
	     method2();
	     return 1;
	}

	synchronized int method2() {
		return 1;
	}
	
	void sum(){
		int j = 0; 
		for(int i = 0; i < 100; i++){
			j = j++;
		}
		System.out.println(j);
		String a = "123456789";
		String b = a.valueOf(2);
	}
	
	public static enum Selection{
		/*X(true),
		Y(false),
		Z(true);*/
		
		Selection(){
			
		};
		
		private boolean correct;
		
		public void setCorrect(boolean correct){
			this.correct = correct;
		}
	}
}
