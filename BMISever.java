package BMI.hue61133694;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BMI_Server {
	
	public static void main(String[] args) {
		try {
			// Mở cổng và bắt đầu nghe
			ServerSocket socketServer = new ServerSocket(8989);
			System.out.println("I'm listening on 8989 port....");
			// Luôn luôn lắng nghe
			while (true)
			{	//Khí có 1 yêu cầu tới, thì Accept
				// mở một Socket để làm việc với client đó
				Socket socketClient = socketServer.accept();  //
				System.out.print("Client:"+socketClient.getInetAddress().getHostAddress().toString());
				//Lấy về luồng xuất, nhập
				OutputStream osToClient = socketClient.getOutputStream();
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				BufferedWriter buffWrite  = new BufferedWriter(write2Client);
				   
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffRead = new BufferedReader(inReader);
				//========= GIAO TIẾP THEO giao thức thiết kế=============    
				 
				//-----------------------
				String chuoiHello_Gui="Hello";
				buffWrite.write(chuoiHello_Gui+ "\n");
				buffWrite.flush();
				
				//- Nhận xin chào, và hỏi tên-------------------------
			    String chuoiXinchao_Nhan = buffRead.readLine();
			    String chuoiHoiTen="Bạn tên gì? \n";
			    buffWrite.write(chuoiHoiTen+ "\n");
			    buffWrite.flush();
				//-- Nhận trả lời tên, và hỏi chiều cao	
			    String chuoiTen_Nhan = buffRead.readLine();
			    String chuoiHoiChieuCao="Bạn cao bao nhieu cm? \n";
			    buffWrite.write(chuoiHoiChieuCao+ "\n");
			    buffWrite.flush();	
				//-- Nhận trả lời chiều cao, và hỏi cân nặng
			    String chuoiChieuCao = buffRead.readLine();
			    String chuoiHoiCanNang="Bạn nặng bao nhieu kg? \n";
			    buffWrite.write(chuoiHoiCanNang+ "\n");
			    buffWrite.flush();
			    // === nhận về cân nặng, gủi tôi đang tính
			    String chuoiCanNang = buffRead.readLine();
			    String chuoiNoiToiDangTinh ="Tôi đang tính toán ...";
			    buffWrite.write(chuoiNoiToiDangTinh+ "\n");
			    buffWrite.flush();
			    
			    // doi string sang double
			    String s= chuoiCanNang ;
		        double i = Double.parseDouble(s);
		        String s1= chuoiChieuCao ;
		        double i1 = Double.parseDouble(s1);
			    // Tính toán BMI ở đây
			    Double chiSoBMI = chuoiCanNang / (chuoiChieuCao * chuoiChieuCao);
				System.out.println("Chỉ số BMI = " + chiSoBMI);
			     // các lệnh ở đây
				if (chiSoBMI < 18) {
					String chuoiKQ_Gui = "Bạn là người gầy!";
				} else if (chiSoBMI <= 24.9) {
					String chuoiKQ_Gui = "Bạn là người bình thường";
				} else if (chiSoBMI <= 29.9) {
					String chuoiKQ_Gui = "Bạn bị béo phì độ I";
				} else if (chiSoBMI <= 34.9) {
					String chuoiKQ_Gui = "Bạn bị béo phì độ II";
				} else {
					String chuoiKQ_Gui = "Bạn bị béo phì độ III";
				}
			   
			    String chuoiKQ_Gui;
				buffWrite.write(chuoiKQ_Gui + "\n");
			    buffWrite.flush();			    
				
			    //socketClient.close();
			}
			//socketServer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}