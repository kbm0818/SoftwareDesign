package IF;

import java.util.Scanner;


public class Main {
	public static void main(String [] args)
	{
		int n;
		
		System.out.println("1. ��ǰ���");
		System.out.println("2. ��ǰ���");
		System.out.println("3. �α׾ƿ�");
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("�Է� : ");
			n = input.nextInt();
			if(n == 1)
			{
				GList();
			}
			else if(n == 2)
			{
				RGoods();
			}
			else if(n == 3)
			{
				System.out.println("�α׾ƿ�!");
				break;
			}
			else
			{
				System.err.println("1 ~ 3 ������ ��ȣ�� �Է��ϼ���.");
			}
		}
	}
	
	public static void RGoods()
	{
			String name;
			int price;
			System.out.println("<< ��ǰ ��� >>");
			Scanner input = new Scanner(System.in);
			System.out.print("��ǰ �̸� : ");
			name = input.next();
			System.out.print("��� ���ϸ��� : ");
			price = input.nextInt();
			
			System.out.println("��û�� �Ϸ� �Ǿ����ϴ�.");
			main(null);
	}
	public static void GList()
	{
			int n;
			
			System.out.println("<< ��ǰ ��� >>");
			System.out.println("���ϸ��� : ");
			Scanner input = new Scanner(System.in);
			System.out.println("--------- ��ǰ ��� ---------");
			System.out.print("���� ��ȣ �Է� (0 �Է½� ���θ޴���) : ");
			n = input.nextInt();
			if(n==0)
			{
				main(null);
			}
			else
			{
				Goods(n);
			}
	}
	public static void Goods(int n)
	{
		
		String c;

		System.out.printf("%d��° ��ǰ �̸� : \n", n);
		System.out.println("���ϸ��� : ");
			
		Scanner input = new Scanner(System.in);
		System.out.println("\n���� (Y/N) : ");
		c=input.next();
		while(true)
		{
			if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
			{
				System.out.printf("%d��° ��ǰ�� �����ϼ̽��ϴ�.\n", n);
				GList();
			}
			else if(c.compareTo("N") == 0|| c.compareTo("n") == 0)
			{	
				System.out.println("��ǰ ������� �̵��մϴ�.");
				GList();
			}
			else
				System.out.println("�ٽ� �Է��Ͻÿ�.");
		}
		
	}

}


