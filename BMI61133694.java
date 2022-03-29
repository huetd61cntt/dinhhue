package BMI.hue61133694;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class BMI_Client {

	public static void main(String[] args) {
		Socket soc;
		try {
			soc = new Socket("localhost", 8989);
			System.out.print("Connected!\n");
			//Lấy luồng nhập
			InputStream in = soc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			
			OutputStream osToClient = soc.getOutputStream();
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(write2Client);
			
			//Lấy luồng nhập từ bàn phím
			Scanner banPhim= new Scanner(System.in);
			
			// Giao tiep theo giao thuc thiet ke ============
			String chuoiHello_Nhan = buffRead.readLine();
			// in ra de xem
			System.out.print("BMI server:" + chuoiHello_Nhan);
			//
			String chuoiXinChao_Gui = "Xin Chao";
			buffWrite.write(chuoiXinChao_Gui+"\n");
			buffWrite.flush();
			//----------------
			String chuoihoiTen_Nhan = buffRead.readLine();
			//in ra de xem
			System.out.print("BMI server:" + chuoihoiTen_Nhan);
			// Tra loi cho Server
			// Bao user dua ten tu ban phim
			System.out.print("BMI client: (Nhap ten ban): ");
			String chuoiTraloiTen_Gui= banPhim.nextLine();
			// Gui den server
			buffWrite.write(chuoiTraloiTen_Gui);
			buffWrite.flush();
			//-----------------
			
			//Nhan hoi chieu cao
			String chuoihoiChieuCao_Nhan = buffRead.readLine();
			//in ra de xem
			System.out.print("BMI server:"+ chuoihoiChieuCao_Nhan);
			// Tra loi cho Server
			// Bao user dua ten tu ban phim
			System.out.print("BMI client: (Nhap chieu cao (cm): ");
			String chuoiTraloiChieuCao_Gui = banPhim.nextLine();
			// Gui den Server
			buffWrite.write(chuoiTraloiChieuCao_Gui);
			buffWrite.flush();
			//----------------
			
			//Nhan hoi can nang
			String chuoihoiCanNang_Nhan = buffRead.readLine();
			//in ra de xem
			System.out.print("BMI server:"+ chuoihoiCanNang_Nhan);
			// Tra loi cho Server
			// Bao user dua ten tu ban phim
			System.out.print("BMI client: (Nhap can nang (kg): ");
			String chuoiTraloiCanNang_Gui = banPhim.nextLine();
			// Gui den Server
			buffWrite.write(chuoiTraloiCanNang_Gui);
			buffWrite.flush();
			//----------------
			//Nhan1: thong tin dang tinh
			String chuoiDangTinh_Nhan = buffRead.readLine();
			//in ra man hinh user xem
			System.out.print("BMI server: " + chuoiDangTinh_Nhan);
			
			//Nhan2: thong tin ket qua 
			String chuoiKQ_Nhan = buffRead.readLine();
			//in ra man hinh user xem
			System.out.print("BMI server: " + chuoiKQ_Nhan);
		
            // ========================================
			} catch( IOException e) {
				// 
					e.printStackTrace();
			}
		}
}

	
