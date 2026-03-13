import java.util.ArrayList;
import java.util.Scanner;

//class untuk menyimpan data mata kuliah
class MataKuliah {
	
	String namaMK;
	int sks;
	String nilai;
	
	MataKuliah(String namaMK, int sks, String nilai){
		this.namaMK = namaMK;
		this.sks = sks;
		this.nilai = nilai.toUpperCase();
	}
	
	//mengubah nilai huruf menjadi bobot 
	double bobotNilai(){
		if(nilai.equals("A")) return 4.0;
		else if(nilai.equals("B")) return 3.0;
		else if(nilai.equals("C")) return 2.0;
		else if(nilai.equals("D")) return 1.0;
		else return 0.0;
	}
	
	//menghitung nilau mutu (bobot × sks)
	double nilaiMutu(){
		return bobotNilai() * sks;
	}
}

// class mahasiswa
class Mahasiswa{
	
	ArrayList<MataKuliah> daftarMK = new ArrayList<>();
	
	// menambahkan mata kuliah
	void tambahMK(MataKuliah mk){
		daftarMK.add(mk);
	}
	
	// menghitung IPS
	double hitungIPS(){
		double totalMutu = 0;
		int totalSKS = 0;
		
		for (MataKuliah mk : daftarMK){
			totalMutu += mk.nilaiMutu();
			totalSKS += mk.sks;
		}
		
		if(totalSKS == 0){
			return 0;
		}
		
		return totalMutu / totalSKS;
	}
}

//program utama
public class ProgramIPS {
	public static void main(String[] args)
{
		Scanner input = new Scanner(System.in);
		Mahasiswa mhs = new Mahasiswa();
		
		System.out.print("Berapa mata kuliah yang diambil? ");
		int jumlah = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<jumlah; i++){
			System.out.print("\nData mata kuliah ke- " + (i+1));
			
			
			System.out.println("\nNama mata kuliah :");
			
			
			String nama = input.nextLine();
			System.out.print("Jumlah SKS : ");
			int sks = input.nextInt();
			input.nextLine();
			
			System.out.print("Nilai huruf : ");
			String nilai = input.nextLine();
			
			MataKuliah mk = new MataKuliah(nama, sks, nilai);
			mhs.tambahMK(mk);
		}
		
		double ips = mhs.hitungIPS();
		System.out.println("\nIPS semester anda = " + String.format("%.2f", ips));
	}	
}