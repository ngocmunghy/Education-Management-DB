import java.sql.*;
import java.util.*;
import java.text.*;

//java -cp .:/usr/share/java/mysql-connector-java.jar test
//CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'user_password';
//GRANT ALL PRIVILEGES ON database_name.* TO 'database_user'@'localhost';

class Menu {
    void showMenu() {
	System.out.println("=== Quan ly giao duc ===\n");
	System.out.println("1. Quan ly mon hoc");
	System.out.println("2. Quan ly giao vien");
	System.out.println("3. Quan ly sinh vien");
	System.out.println("4. Quan ly lop");
	System.out.println("5. Quan ly diem");
	System.out.println("Chon mot lenh (an phim q de thoat): ");
    }
}

class test {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/menu";

    static final String USER = "ngocmunghy";
    static final String PASS = "ngocmung321";
    
    public static void main(String args[])
	throws java.io.IOException {
	
	char choice;
	Menu obj = new Menu();

	while (true) {
	    obj.showMenu();
	    choice = (char) System.in.read();
	    switch(choice) {
	    case '1': System.out.println("Quan ly mon hoc\n");
		menu1();
		break;
	    case '2': System.out.println("Quan ly giao vien\n");
		menu2();
		break;
	    case '3': System.out.println("Quan ly sinh vien\n");
		menu3();
		break;
	    case '4': System.out.println("Quan ly lop\n");
		menu4();
		break;
	    case'5':  System.out.println("Quan ly diem\n");
		menu5();
		break;
	    case 'q': System.out.println("Cam on ban da su dung.\n");
		return;
	    }
	}
    }

    public static void menu1() {
	Scanner scan = new Scanner(System.in);
	while(true) {
	    System.out.println("a. Them mon hoc moi");
	    System.out.println("b. Sua thong tin mon hoc");
	    System.out.println("c. In danh sach mon hoc\n");
	    System.out.println("Moi ban nhap lua chon (nhan q de thoat): ");
	    char choice = scan.next().charAt(0);
	    switch(choice) {
	    case 'a': c11(); break;
	    case 'b': c12(); break;
	    case 'c': c13(); break;
	    case 'q': return;
	    }
	}
    }

    public static void menu2() {
	Scanner scan = new Scanner(System.in);
	while(true) {
	    System.out.println("a. Them ho so giao vien");
	    System.out.println("b. Sua thong tin giao vien");
	    System.out.println("c. In danh sach giao vien");
	    System.out.println("d. Tim kiem giao vien\n");
	    System.out.println("Moi ban nhap lua chon (nhan q de thoat): ");
	    char choice = scan.next().charAt(0);
	    switch(choice) {
	    case 'a': c21(); break;
	    case 'b': c22(); break;
	    case 'c': c23(); break;
	    case 'd': c24(); break;
	    case 'q': return;
	    }
	}
    }

    public static void menu3() {
       Scanner scan = new Scanner(System.in);
	while(true) {
	    System.out.println("a. Them ho so sinh vien");
	    System.out.println("b. Sua thong tin sinh vien");
	    System.out.println("c. Tim kiem sinh vien\n");
	    System.out.println("Moi ban nhap lua chon (nhan q de thoat): ");
	    char choice = scan.next().charAt(0);
	    switch(choice) {
	    case 'a': c31(); break;
	    case 'b': c32(); break;
	    case 'c': c33(); break;
	    case 'q': return;
	    }
	}
    }

    public static void menu4() {
       Scanner scan = new Scanner(System.in);
	while(true) {
	    System.out.println("a. Tao lop moi");
	    System.out.println("b. Sua doi thong tin lop");
	    System.out.println("c. Bo sung sinh vien vao lop");
	    System.out.println("d. Loai bo sinh vien ra khoi lop");
	    System.out.println("e. Huy lop");
	    System.out.println("f. In danh sach lop\n");
	    System.out.println("Moi ban nhap lua chon (nhan q de thoat): ");
	    char choice = scan.next().charAt(0);
	    switch(choice) {
	    case 'a': c41(); break;
	    case 'b': c42(); break;
	    case 'c': c43(); break;
	    case 'd': c44(); break;
	    case 'e': c45(); break;
	    case 'f': c46(); break;
	    case 'q': return;
	    }
	}
    }

    public static void menu5() {
       Scanner scan = new Scanner(System.in);
	while(true) {
	    System.out.println("a. Nhap diem");
	    System.out.println("b. Sua diem");
	    System.out.println("c. In bang diem cho lop");
	    System.out.println("d. In bang diem cho sinh vien\n");
	    System.out.println("Moi ban nhap lua chon (nhan q de thoat): ");
	    char choice = scan.next().charAt(0);
	    switch(choice) {
	    case 'a': c51(); break;
	    case 'b': c52(); break;
	    case 'c': c53(); break;
	    case 'd': c54(); break;
	    case 'q': return;
	    }
	}
    }

    public static void c11() {

	Connection conn = null;
	Statement stmt = null;
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma mon hoc: ");
	String MaMH = scan.nextLine();
	System.out.println("Nhap ten mon hoc: ");
	String TenMH = scan.nextLine();
	System.out.println("Nhap so tin chi mon hoc: ");
	int SoTC = scan.nextInt();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Inserting records into the table...");
	    stmt = conn.createStatement();
      
	    String sql = "INSERT INTO MonHoc VALUES ('"+ MaMH +"','" + TenMH +"', "+ SoTC+")";
	    stmt.executeUpdate(sql);
	    System.out.println("Inserted records into the table...");

	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }
    public static void c12(){
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma so mon hoc ban muon thay doi thong tin: ");
	String str = scan.nextLine();
	System.out.println("Nhap ten mon hoc: ");
	String TenMH = scan.nextLine();
	System.out.println("Nhap so tin chi: ");
	int SoTC = scan.nextInt();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "UPDATE MonHoc " +
		"SET TenMH = '"+ TenMH + "', SoTC = '"+ SoTC +
		"'WHERE MaMH = '"+ str +"';";
	    stmt.executeUpdate(sql);
	    System.out.println("You've updated successfully.");
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }
    
    public static void c13() {

	Connection conn = null;
	Statement stmt = null;
	
	try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM MonHoc";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()) {
	  String maMH = rs.getString("MaMH");
	  String tenMH = rs.getString("TenMH");
	  int soTC = rs.getInt("SoTC");

	  System.out.print("MaMH: "+maMH);
	  System.out.print(", TenMH: "+tenMH);
	  System.out.println(", SoTC: "+ soTC);
      }
      rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c21() {

	Connection conn = null;
	Statement stmt = null;
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma giao vien: ");
	String MaGV = scan.nextLine();
	System.out.println("Nhap ten ho giao vien: ");
	String HoGV = scan.nextLine();
	System.out.println("Nhap ten giao vien: ");
	String TenGV = scan.nextLine();
	System.out.println("Nhap don vi cong tac: ");
	String DonVi = scan.nextLine();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Inserting records into the table...");
	    stmt = conn.createStatement();
      
	    String sql = "INSERT INTO GiaoVien VALUES ('"+ MaGV +"','" + HoGV +"','"+ TenGV +"','"+DonVi+"')";
	    stmt.executeUpdate(sql);
	    System.out.println("Inserted records into the table...");

	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c22(){
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma so giao vien ban muon thay doi thong tin: ");
	String str = scan.nextLine();
	System.out.println("Nhap ho giao vien: ");
	String HoGV = scan.nextLine();
	System.out.println("Nhap ten giao vien: ");
	String TenGV = scan.nextLine();
	System.out.println("Nhap don vi cong tac: ");
	String DonVi = scan.nextLine();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "UPDATE GiaoVien " +
		"SET HoGV = '"+ HoGV +"', TenGV = '"+ TenGV +"',DonVi: '"+ DonVi +"'WHERE MaGV = '"+ str +"';";
	    stmt.executeUpdate(sql);
	    System.out.println("You've updated successfully.");
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c23() {

	Connection conn = null;
	Statement stmt = null;
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    
	    String sql = "SELECT * FROM GiaoVien";
	    ResultSet rs = stmt.executeQuery(sql);

	    while(rs.next()) {
		String maGV = rs.getString("MaGV");
		String hoGV = rs.getString("HoGV");
		String tenGV = rs.getString("TenGV");
		String donVi = rs.getString("DonVi");

		System.out.print("MaGV: "+maGV);
		System.out.print(", HoGV: "+hoGV);
		System.out.print(", TenGV: "+ tenGV);
		System.out.println(", DonVi: "+ donVi);
	    }
	    rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c24() {
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma giao vien ban muon tim kiem: ");
	String str = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT * FROM GiaoVien WHERE GiaoVien.MaGV = '"+ str + "';";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from result set
	    while(rs.next()){
       
		String maGV = rs.getString("MaGV");
		String hoGV = rs.getString("HoGV");
		String tenGV = rs.getString("TenGV");
		String donVi = rs.getString("DonVi");

		//Display values
		System.out.print("MaGV: " + maGV);
		System.out.print(", HoGV: " + hoGV);
		System.out.print(", TenGV: " + tenGV);
		System.out.println(", DonVi: " + donVi);
	    }
	    rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c31() {

	Connection conn = null;
	Statement stmt = null;
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma sinh vien: ");
	String MaSV = scan.nextLine();
	System.out.println("Nhap ho sinh vien: ");
	String HoSV = scan.nextLine();
	System.out.println("Nhap ten sinh vien: ");
	String TenSV = scan.nextLine();
	System.out.println("Nhap ngay sinh (yyyy-mm-dd): ");
	String NgaySinh = scan.nextLine();
	System.out.println("Nhap noi sinh: ");
	String NoiSinh = scan.nextLine();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Inserting records into the table...");
	    stmt = conn.createStatement();

	    // convert String to Date
	    java.sql.Date sqNgaySinh = java.sql.Date.valueOf(NgaySinh);
      
	    String sql = "INSERT INTO SinhVien VALUES (?,?,?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);

	    //set the parameters
	    ps.setString(1,MaSV);
	    ps.setString(2,HoSV);
	    ps.setString(3,TenSV);
	    ps.setDate(4,sqNgaySinh);
	    ps.setString(5,NoiSinh);
 	    
	    ps.execute();
	    System.out.println("Inserted records into the table...");

	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c32(){
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma sinh vien ban muon thay doi thong tin: ");
	String str = scan.nextLine();
	System.out.println("Nhap ho sinh vien: ");
	String HoSV = scan.nextLine();
	System.out.println("Nhap ten sinh vien: ");
	String TenSV = scan.nextLine();
	System.out.println("Nhap ngay sinh: ");
	String NgaySinh = scan.nextLine();
	System.out.println("Nhap noi sinh: ");
	String NoiSinh = scan.nextLine();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "UPDATE SinhVien " +
		"SET HoSV = '"+ HoSV + "', TenSV = '"+ TenSV +
		"', NgaySinh = '"+ NgaySinh +"', NoiSinh = '"+ NoiSinh +"' WHERE MaSV = '"+ str +"';";
	    stmt.executeUpdate(sql);
	    System.out.println("You've updated successfully.");
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }    

    public static void c33() {
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma sinh vien ban muon tim kiem: ");
	String str = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT * FROM SinhVien WHERE SinhVien.MaSV = '"+ str + "';";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from result set
	    while(rs.next()){
       
		String maSV = rs.getString("MaSV");
		String hoSV = rs.getString("HoSV");
		String tenSV = rs.getString("TenSV");
		String ngaySinh = rs.getString("NgaySinh");
		String noiSinh = rs.getString("NoiSinh");

		//Display values
		System.out.print("MaSV: " + maSV);
		System.out.print(", HoSV: " + hoSV);
		System.out.print(", TenSV: " + tenSV);
		System.out.print(", NgaySinh: " + ngaySinh);
		System.out.println(", NoiSinh: "+ noiSinh);
	    }
	    rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c41() {

	Connection conn = null;
	Statement stmt = null;
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma lop: ");
	String MaLop = scan.nextLine();
	System.out.println("Nhap ma mon hoc: ");
	String MaMH = scan.nextLine();
	System.out.println("Nhap nam hoc: ");
	int NamHoc = scan.nextInt();
	System.out.println("Nhap hoc ky: ");
	int HocKy = scan.nextInt();
	System.out.println("Nhap ma giao vien: ");
	String MaGV = scan.next();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Inserting records into the table...");
	    stmt = conn.createStatement();
      
	    String sql = "INSERT INTO Lop VALUES ('"+ MaLop +"','" + MaMH +"', '"+ NamHoc+"','"+ HocKy +"','"+ MaGV +"');";
	    stmt.executeUpdate(sql);
	    System.out.println("Inserted records into the table...");

	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c42(){
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma lop ban muon thay doi thong tin: ");
	String str = scan.nextLine();
	System.out.println("Nhap nam hoc: ");
	String NamHoc = scan.nextLine();
	System.out.println("Nhap hoc ky: ");
	int HocKy = scan.nextInt();
	System.out.println("Nhap ma giao vien: ");
	String MaGV = scan.next();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "UPDATE Lop " +
		"SET NamHoc = '"+ NamHoc + "', HocKy = '"+ HocKy +
		"', MaGV = '"+ MaGV +"' WHERE MaLop = '"+ str +"';";
	    stmt.executeUpdate(sql);
	    System.out.println("You've updated successfully.");
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c43() {

	Connection conn = null;
	Statement stmt = null;
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma so sinh vien muon bo sung: ");
	String MaSV = scan.nextLine();
	System.out.println("Nhap ma so lop: ");
	String MaLop = scan.nextLine();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Inserting records into the table...");
	    stmt = conn.createStatement();
      
	    String sql = "INSERT INTO SinhVienLop(MaSV, MaLop) VALUES ('"+ MaSV +"','" + MaLop +"');";
	    stmt.executeUpdate(sql);
	    System.out.println("Inserted records into the table...");

	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c44() {
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma so sinh vien muon loai bo: ");
	String MaSV = scan.nextLine();
	System.out.println("Nhap ma lop: ");
	String MaLop = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "DELETE FROM SinhVienLop " +
		"WHERE MaSV = '"+MaSV+ "'AND MaLop = '" + MaLop +"';";
	    stmt.executeUpdate(sql);

	    System.out.println("You've deleted sucessfully.");
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c45() {
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma lop muon huy: ");
	String MaLop = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "DELETE FROM Lop " +
		"WHERE MaLop = '"+MaLop+ "';";
	    stmt.executeUpdate(sql);

	    System.out.println("You've deleted sucessfully.");
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c46() {

	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma lop: ");
	String MaLop = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    
	    String sql = "SELECT MaLop,MaSV FROM SinhVienLop WHERE MaLop = '"+MaLop+"';";
	    ResultSet rs = stmt.executeQuery(sql);

	    System.out.println("\nDanh sach lop "+ MaLop);
	    
	    while(rs.next()) {
		String maLop = rs.getString("MaLop");
		String maSV = rs.getString("MaSV");

		System.out.print(" MaLop: "+ maLop);
		System.out.println(", MaSV: "+ maSV);
	    }
	    rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c52(){
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ma so sinh vien muon sua diem: ");
	String MaSV = scan.nextLine();
	System.out.println("Nhap ma lop: ");
	String MaLop = scan.nextLine();
	System.out.println("Nhap diem: ");
	double Diem = scan.nextDouble();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "UPDATE SinhVienLop SET Diem = '"+ Diem +"'WHERE MaSV = '"+ MaSV +"' AND MaLop = '"+ MaLop +"';";
	    stmt.executeUpdate(sql);
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c51(){
	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ma so sinh vien muon nhap diem: ");
	String MaSV = scan.nextLine();
	System.out.println("Nhap ma lop: ");
	String MaLop = scan.nextLine();
	System.out.println("Nhap diem: ");
	double Diem = scan.nextDouble();
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "UPDATE SinhVienLop SET Diem = '"+ Diem +"'WHERE MaSV = '"+ MaSV +"' AND MaLop = '"+ MaLop +"';";
	    stmt.executeUpdate(sql);
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c53() {

	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma so lop: ");
	String MaLop = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    
	    String sql = "SELECT MaSV,Diem FROM SinhVienLop WHERE MaLop = '"+MaLop+"';";
	    ResultSet rs = stmt.executeQuery(sql);

	    while(rs.next()) {
		String maSV = rs.getString("MaSV");
		String diem = rs.getString("Diem");

		System.out.print("MaSV: "+ maSV);
		System.out.println(", Diem: "+ diem);
	    }
	    rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }

    public static void c54() {

	Connection conn = null;
	Statement stmt = null;

	Scanner scan = new Scanner(System.in);
	System.out.println("Nhap ma so sinh vien: ");
	String MaSV = scan.nextLine();
	
	try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
      
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    
	    String sql = "SELECT MaSV,MaMH,Diem FROM SinhVienLop,Lop WHERE SinhVienLop.MaLop = Lop.MaLop AND MaSV = '"+MaSV+"';";
	    ResultSet rs = stmt.executeQuery(sql);

	    while(rs.next()) {
		String maSV = rs.getString("MaSV");
		String maMH = rs.getString("MaMH");
		double diem = rs.getDouble("Diem");

		System.out.print("MaSV: "+ maSV);
		System.out.print(", MaMH: "+ maMH);
		System.out.println(", Diem: "+ diem);
	    }
	    rs.close();
	}catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }//end finally try
	}//end try
    }
}
