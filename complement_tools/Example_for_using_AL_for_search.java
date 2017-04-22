import java.util.*;

class Untitled {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> test = new ArrayList<String>();
		test.add("TestA");
		test.add("TetB");
		test.add("Tes");
		ArrayList<String> test2 = new ArrayList<String>();
		test2.add("11123121212");
		test2.add("234234234wedrf234");
		test2.add("234234234234");
		System.out.printf("Name\tID\n");
		for(int i = 0 ; i< test.size(); i++)
			System.out.printf("%s\t%s\n",test.get(i),test2.get(i));
	
			
		System.out.printf("input:");
		String z = input.nextLine();
		int counter = -1;
//		String a = test.get(2);
//		System.out.print(a);
		for(String ax: test){
			counter +=1;
//			System.out.printf("%d\n",counter);
			System.out.printf("%s  %s \n",ax,z);
			
			if (ax.compareTo(z) == 0) {
				int k = test.indexOf(ax);
//				int a = test.indexOf(ax);
				System.out.print(k);
				break;
				
			}
//			System.out.printf("%d",counter);
		}
	}
}