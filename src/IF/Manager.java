package IF;

import java.util.Scanner;

public class Manager {
	public static void main()
	{
		int n;
		
		System.out.println("1. 고객관리");
		System.out.println("2. 물품 등록 신청확인");
		System.out.println("3. 재고확인");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("입력 : ");
		n = input.nextInt();
		
		while(true)
		{
			System.out.print("입력 : ");
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
				System.err.println("1 ~ 3 사이의 번호를 입력하세요.");
			}
		}
	}
	public static void ARGoods() 
	{
		
		int n;
		System.out.println("<<물품 등록 신청 목록 >>");	
		Scanner input = new Scanner(System.in);
		System.out.println("--------- 물품 등록 신청 목록 ---------");
		System.out.print("번호 입력 (0 입력시 메인메뉴로) : ");
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
		System.out.printf("%d번째 물품 이름 : \n", n);

		Scanner input = new Scanner(System.in);
		System.out.println("\n구매 (Y/N) : ");
		c=input.next();
		while(true)
		{
			if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
			{
				System.out.print("책정 마일리지 : ");
				price = input.nextInt();
				System.out.printf("%d번째 물품을 %d 마일리지에 구매하셨습니다.\n", n, price);
				ARGoods();
			}
			else if(c.compareTo("N") == 0|| c.compareTo("n") == 0)
			{	
				System.out.printf("%d번째 물품을 구매를 거절합니다.\n", n);
				System.out.println("판매 신청 목록으로 이동합니다.");
				ARGoods();
			}
			else
				System.out.println("다시 입력하시오.");
		}
	}
	public static void Stock()
	{
	
		int n;
		String c;
			
		System.out.println("<< 재고 관리 >>");
			
		System.out.println("--------- 상품 목록 ---------");
		
		Scanner input = new Scanner(System.in);
			
		while(true)
		{
			System.out.print("삭제할 번호 : (0 입력시 메인메뉴로)");
			n = input.nextInt(); 
			if(n==0)
			{
				main();
			}
			else
			{
				System.out.printf("%d번째 물품이 삭제되었습니다.\n", n);
				System.out.println("더 삭제할 물품이 있습니까? (Y/N) : ");
				c=input.next();
				while(true)
				{
					if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
					{
						break;
					}
					else if(c.compareTo("N") == 0 || c.compareTo("n") == 0)
					{	
						System.out.println("메뉴로 이동합니다.");
						main();
					}
					else
						System.out.println("다시 입력하시오.");
				}
				
			}
		}
	}
	public static void MClient()
	{
		String c;
		
		System.out.println("<< 고객 관리 >>");
		
		System.out.println("이름      마일리지     ");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("뒤로가기 (Y) : ");
		c=input.next();
		while(true)
		{
			if(c.compareTo("Y") == 0 || c.compareTo("y") == 0)
			{
				main();
			}
			else
				System.out.println("다시 입력하시오.");
		}
	}
}
