package IF;

import java.util.Scanner;

public class Manager {
	public static void main()
	{
		int n;
		
		System.out.println("1. ������");
		System.out.println("2. ��ǰ ��� ��ûȮ��");
		System.out.println("3. ���Ȯ��");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("�Է� : ");
		n = input.nextInt();
		
		while(true)
		{
			System.out.print("�Է� : ");
			n = input.nextInt();
			if(n == 1)
			{
				MClient();
			}
			else if(n == 2)
			{
				ARGoods();
			}
			else if(n == 3)
			{
				Stock();
			}
			else
			{
				System.err.println("1 ~ 3 ������ ��ȣ�� �Է��ϼ���.");
			}
		}
	}
	public static void ARGoods() 
	{
		
		int n;
		System.out.println("<<��ǰ ��� ��û ��� >>");	
		Scanner input = new Scanner(System.in);
		System.out.println("--------- ��ǰ ��� ��û ��� ---------");
		System.out.print("��ȣ �Է� (0 �Է½� ���θ޴���) : ");
		n = input.nextInt();
		if(n==0)
		{
			main();
		}
		else
		{
			Pricing(n);
		}
	}
	public static void Pricing(int n){
	
		String c;
		int price;
		System.out.printf("%d��° ��ǰ �̸� : \n", n);

		Scanner input = new Scanner(System.in);
		System.out.println("\n���� (Y/N) : ");
		c=input.next();
		while(true)
		{
			if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
			{
				System.out.print("å�� ���ϸ��� : ");
				price = input.nextInt();
				System.out.printf("%d��° ��ǰ�� %d ���ϸ����� �����ϼ̽��ϴ�.\n", n, price);
				ARGoods();
			}
			else if(c.compareTo("N") == 0|| c.compareTo("n") == 0)
			{	
				System.out.printf("%d��° ��ǰ�� ���Ÿ� �����մϴ�.\n", n);
				System.out.println("�Ǹ� ��û ������� �̵��մϴ�.");
				ARGoods();
			}
			else
				System.out.println("�ٽ� �Է��Ͻÿ�.");
		}
	}
	public static void Stock()
	{
	
		int n;
		String c;
			
		System.out.println("<< ��� ���� >>");
			
		System.out.println("--------- ��ǰ ��� ---------");
		
		Scanner input = new Scanner(System.in);
			
		while(true)
		{
			System.out.print("������ ��ȣ : (0 �Է½� ���θ޴���)");
			n = input.nextInt(); 
			if(n==0)
			{
				main();
			}
			else
			{
				System.out.printf("%d��° ��ǰ�� �����Ǿ����ϴ�.\n", n);
				System.out.println("�� ������ ��ǰ�� �ֽ��ϱ�? (Y/N) : ");
				c=input.next();
				while(true)
				{
					if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
					{
						break;
					}
					else if(c.compareTo("N") == 0 || c.compareTo("n") == 0)
					{	
						System.out.println("�޴��� �̵��մϴ�.");
						main();
					}
					else
						System.out.println("�ٽ� �Է��Ͻÿ�.");
				}
				
			}
		}
	}
	public static void MClient()
	{
		String c;
		
		System.out.println("<< �� ���� >>");
		
		System.out.println("�̸�      ���ϸ���     ");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("�ڷΰ��� (Y) : ");
		c=input.next();
		while(true)
		{
			if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
			{
				main();
			}
			else
				System.out.println("�ٽ� �Է��Ͻÿ�.");
		}
	}
}
