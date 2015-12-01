package IF;

import java.util.Scanner;


public class Main {
	public static void main(String [] args)
	{
		int n;
		
		System.out.println("1. 상품목록");
		System.out.println("2. 물품등록");
		System.out.println("3. 로그아웃");
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("입력 : ");
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
				System.out.println("로그아웃!");
				System.exit(0);
			}
			else
			{
				System.err.println("1 ~ 3 사이의 번호를 입력하세요.");
			}
		}
	}
	
	public static void RGoods()
	{
			String name;
			int price;
			System.out.println("<< 물품 등록 >>");
			Scanner input = new Scanner(System.in);
			System.out.print("물품 이름 : ");
			name = input.next();
			System.out.print("희망 마일리지 : ");
			price = input.nextInt();
			
			System.out.println("신청이 완료 되었습니다.");
			main(null);
	}
	public static void GList()
	{
			int n;
			
			System.out.println("<< 상품 목록 >>");
			System.out.println("마일리지 : ");
			Scanner input = new Scanner(System.in);
			System.out.println("--------- 상품 목록 ---------");
			System.out.print("구매 번호 입력 (0 입력시 메인메뉴로) : ");
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

		System.out.printf("%d번째 물품 이름 : \n", n);
		System.out.println("마일리지 : ");
			
		Scanner input = new Scanner(System.in);
		System.out.println("\n구매 (Y/N) : ");
		c=input.next();
		while(true)
		{
			if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
			{
				System.out.printf("%d번째 물품을 구매하셨습니다.\n", n);
				GList();
			}
			else if(c.compareTo("N") == 0|| c.compareTo("n") == 0)
			{	
				System.out.println("상품 목록으로 이동합니다.");
				GList();
			}
			else
				System.out.println("다시 입력하시오.");
		}
		
	}

}


