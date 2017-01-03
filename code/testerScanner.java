import java.util.Scanner;

public class testerScanner
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String line=in.nextLine();
		LinkedList<Integer> list=new LinkedList();
		while(true)
		{
			if(line.equals("+"))
			{
				System.out.println("add value");
				list.add(in.nextInt());
				System.out.println(list);
			}
			else if(line.equals("-"))
			{
				System.out.println("removed value");
				list.remove();
				System.out.println(list);
			}
			else if(line.equals(">"))
			{
				System.out.println(list.next());
				System.out.println(list);
			}
			else if(line.equals("<"))
			{
				System.out.println(list.previous());
				System.out.println(list);
			}
			line=in.nextLine();
		}
	}
}
