package chapter3;

public class Chapter3Run {
	public static void main(String[] args) {
		Chapter3Run c = new Chapter3Run();
		c.runnableTest();
	}
	
	public void runnableTest(){
		Runnable r1 = () -> System.out.println("Hello World 1");
		Runnable r2 = new Runnable(){
			@Override
			public void run() {
				System.out.println("Hello World 2");
			}
			
		};
		
		process(r1);
		process(r2);
		process(() -> System.out.println("Hello World 3"));
	}
	
	public void process(Runnable r){
		r.run();
	}
}
