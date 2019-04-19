package lab1;
import java.util.Scanner;
public class QueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("choose---input 0 to exit");
		System.out.println("1.add\t2.offer\t3.remove\n4.poll\t5.peek\t6.element");
		Scanner input=new Scanner(System.in);
		Queue<String> q=new Queue<String>();
		int op=1;
		String temp;
		while(op!=0){
			op=input.nextInt();
			//System.out.print("\n");
			switch(op){
				case 0:System.out.println("Exit");
					break;
				case 1:temp=input.next();
					q.add(temp);
					break;
				case 2:temp=input.next();
					if(q.offer(temp)==false)
						System.out.println("Offer Error");
					break;
				case 3:q.remove();
					break;
				case 4:
					if(q.poll()==null)
						System.out.println("Poll Error");
					break;
				case 5:System.out.println(q.peek());
					break;
				case 6:System.out.println(q.element());
					break;
				default:System.out.println("Input Error");
					break;
			}
		}
	}

}
