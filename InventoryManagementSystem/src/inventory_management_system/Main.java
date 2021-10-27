package inventory_management_system;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner sc = new Scanner(System.in);
	Vector<Inventory> totalBarang = new Vector<Inventory>();

	int Menu, price, stock, totalRevenue;
	String name, iD;
	Inventory Barang = new Inventory(name, iD, price, stock);

	public Main() {
		do {
			System.out.println("Inventory Management System");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("1. View Item in Inventory");
			System.out.println("2. Add New Item to Inventory");
			System.out.println("3. Check Out Item from Inventory");
			System.out.println("4. Exit");
			System.out.print(" >> ");
			Menu = sc.nextInt();
			sc.nextLine();

			if (Menu == 1) {
				if(totalBarang.size() == 0) {
					System.out.println("No items in inventory");
					System.out.println("Press enter to continue . . . ");
					sc.nextLine();
				}else {
					printTable();
				}
			} else if (Menu == 2) {
				do {
					System.out.print("Your Item ID[XXXXX]: ");
					iD = sc.nextLine();
				}while(iD.length() != 5);
				
				//udah coba pakai foreach atau equal atau contains tetap tidak bisa >_<
				//Mau cek apa inputan ID ada yang sama dalam simpanan
				for (Inventory Barang : totalBarang) {
					if(Barang.getiD().equals(iD)) {
						System.out.println("Your Item is already exist");
						System.out.println("--------------------------");
						sc.nextLine();
						System.out.printf("Item ID: %s\n", Barang.getiD());
						
					}else {
						do {
							System.out.print("Input Item ID[XXXXX]: ");
							iD = sc.nextLine();
						}while(iD.length() != 5);
						
						do {
							System.out.print("Input Item Name[5-28]: ");
							name = sc.nextLine();
						}while(name.length() < 5 || name.length() > 28);
						
						do {
							System.out.print("Input Item Price[Min 10000]: ");
							price = sc.nextInt();
							sc.nextLine();
						}while(price < 10000);
						
						do {
							System.out.print("Input Item Stock[Min 10]: ");
							stock = sc.nextInt();
							sc.nextLine();
						}while(stock < 10);
						
						totalBarang.add(Barang);
						System.out.printf("\n\n");
						System.out.println("Success adding item to inventory");
						System.out.println("");
						System.out.println("Press Enter to Continue . . .");
					}
				}
				
			} else if (Menu == 3) {
				if(totalBarang.size() == 0) {
					System.out.println("No items in inventory");
					System.out.println("Press Enter to Continue . . .");
				}else {
					printTable();
					System.out.println("");
					
					//masalah yang sama dengan yang atas
					//mau check apa ada ID yang sama 
					do {
						System.out.print("Input Item ID to be Checked Out: ");
						iD = sc.nextLine();
					}while(!Barang.getiD().equals(iD));
					
					//gak tahu cara panggil variable stock id yang sama
					//gak tahu harus pakai for each atau ngak
					if(Barang.getStock() > 0) {
						do {
							System.out.printf("Input Item Stock to be Checked Out[1-%d]: ", Barang.getStock());
							stock = sc.nextInt();
							sc.nextLine();
						}while(stock < 1 || stock > Barang.getStock());	
						System.out.printf("\n\n");
						totalRevenue = stock*Barang.getPrice();
						System.out.printf("You have sold %d of %s with revenue Rp.%d\n", stock, Barang.getName(), totalRevenue);
						System.out.println("Please Enter to Continue . . .");
						sc.nextLine();
					}else {					
						System.out.println("Cannot checkout, item is out of stock!!");
						System.out.println("Please Enter to Continue . . .");
						sc.nextLine();
					}
				}
			}
		} while (Menu != 4);
	}

	private void printTable() {
		System.out.println("=============================================");
		System.out.println("| List of items in Inventory                |");
		System.out.println("=============================================");
		for (Inventory Barang : totalBarang) {
			System.out.printf("|%3s|%s|%d|%d|", Barang.getiD(), Barang.getName(), Barang.getPrice(), Barang.getStock());
		}
		System.out.println("=============================================");
	}

	public static void main(String[] args) {
		new Main();
	}
}