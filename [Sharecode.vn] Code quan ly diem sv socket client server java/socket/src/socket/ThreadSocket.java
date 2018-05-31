package socket;

import java.net.Socket;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DoanNhatNam
 */
public class ThreadSocket extends Thread {

    Socket socket = null;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private String sql;

    public ThreadSocket(Socket socket) {

        System.out.println("Call to thread socket. ");
        System.out.println("Socket is connected: " + socket.isConnected());
        System.out.println("Socket address: " + socket.getInetAddress().getHostAddress());
        System.out.println("Socket port: " + socket.getPort());
        this.socket = socket;
    }

    public void run() {
        try {
            // tao luong gui du lieu toi client
            String[] arr = {null};
            String st = "";
            //tao luong nhan du lieu tu client
            //BufferedReader din= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataInputStream din = new DataInputStream(socket.getInputStream());
            // tao luong gui du lieu toi client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.println("Xu ly du lieu. ");

            while (din.available() != 0) {
                st = din.readUTF();
                System.out.println("Client gui:" + st);
                arr = st.split("#");
                if (null != arr && arr.length == 4) {

                    System.out.println("chuoi 1:" + arr[0]);
                    System.out.println("chuoi 2:" + arr[1]);
                    System.out.println("chuoi 3:" + arr[2]);
                    System.out.println("chuoi 4:" + arr[3]);
                } else {
                    System.out.println(arr != null ? arr.toString() : "Null");
                }

                if (null != arr && 4 == arr.length) {
                    if (arr[3].equalsIgnoreCase("add")) //goi ham chen csdl vao
                    {
                        insertData(arr[0], arr[1], arr[2]);
                    }
                    if (arr[3].equalsIgnoreCase("xoa")) {
                        deleteData(arr[0]);// goi ham xoa
                    }
                    if (arr[3].equalsIgnoreCase("suadl")) {
                        updateData(arr[0], arr[1], arr[2]);//goi ham sua
                    }
                }

                String students = null;
                String result = "";
                try {
                    students = xemData();// gan ham xemdata cho bien sv
                } catch (Exception e) {
                    result = "DBError";
                    System.out.println("Loi ket noi database: " + e);
                }

                if ((null == students || students.isEmpty())
                        && !result.equals("DBError")) {
                    result = "OK";
                } else if ((null != students && !students.isEmpty())
                        && !result.equals("DBError")) {
                    result = students;
                }
                System.out.print(result);
                Thread.sleep(1000);
                dos.writeUTF(result);// gui du lieu xuong sever
                dos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tao conet den csdl 
    public void ConnectData() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://localhost:49431;databaseName=QuanLyDiemSV2";
            String user = "sa";
            String Password = "369369";
            con = DriverManager.getConnection(URL, user, Password);
            stm = con.createStatement();
        } catch (Exception e) {
            System.out.println("khong nap duoc driver" + e);
        }
    }

    //nhap du lieu vao csdl
    public boolean insertData(String masv, String tensv, String diem) throws Exception {
        ConnectData();
        sql = "INSERT INTO BangDiem(MaSV,TenSV,dltm) VALUES('" + masv + "','" + tensv + "','" + diem + "')";
        int row = 0;
        row = stm.executeUpdate(sql);
        System.out.println("so row insert vao: " + row + "\n");
        con.close();
        return true;
    }

    public String xemData() throws Exception {
        ConnectData();
        sql = "select * from BangDiem";
        rs = stm.executeQuery(sql);
        StringBuilder students = new StringBuilder();

        if (!rs.next()) {
            return "";
        }
        while (rs.next()) {
            String sCode = rs.getString("MaSV");
            String sName = rs.getString("TenSV");
            String sScore = rs.getString("dltm");

            if (sCode == null) {
                sCode = "";
            }
            if (sName == null) {
                sName = "";
            }
            if (sScore == null) {
                sCode = "";
            }
            String student = sCode.trim() + "," + sName.trim() + "," + sScore.trim() + ";";
            students.append(student);
        }
        System.out.print(students.toString());
        con.close();
        return students.toString();
    }

    public boolean deleteData(String masv) throws Exception {
        ConnectData();
        sql = "DELETE FROM BangDiem WHERE MaSV='" + masv + "'";
        int row = stm.executeUpdate(sql);
        System.out.println("so row xoa: " + row);
        con.close();
        return true;
    }

    public boolean updateData(String masv, String tensv, String diem) throws Exception {
        ConnectData();
        //sua ten sv va diem sv khi biet masv
        sql = "UPDATE BangDiem set TenSV = '" + tensv + "',dltm='" + diem + "' where MaSV='" + masv + "'";
        //sql = "UPDATE BangDiem set dltm = '" + diem + "' where MaSV='" + masv + "'";
        int row = stm.executeUpdate(sql);
        System.out.println("update number row: " + row);
        con.close();
        return true;
    }
}
