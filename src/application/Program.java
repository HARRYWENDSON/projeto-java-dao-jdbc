package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("====== Test 1: Id do vendedor =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n====== Test 2: Departamento do vendedor =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n====== Test 3: Vendedor findAll =====");
		list = sellerDao.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n====== Test 4: inserindo Vendedor insert =====");
		Seller newSeller = new Seller(null, "Nivia", "nivia@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! novo id = " + newSeller.getId());
		
		System.out.println("\n====== Test 5: Atualizando Vendedor update =====");
		seller = sellerDao.findById(1);
		seller.setName("Keyse N");
		sellerDao.update(seller);
		System.out.println("Update! Alualizando o nome do funcionario!");
		
		System.out.println("\n====== Test 6: Deletando Vendedor delete =====");
		System.out.print("informe o Id que sera Deletado: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Vendedor deletado com sucesso!");
		
		sc.close();
	}

}
