package chp11;

import java.util.*;

import java.util.Scanner;

class User{
	private String username;
	private String password;
	private String name;
	private String email;
	public User(){}
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

class LoginException extends Exception{

	public LoginException() {
		super();
	}

	public LoginException(String message) {
		super(message);
	}
}

class RegisterException extends Exception{

	public RegisterException() {
		super();
	}

	public RegisterException(String message) {
		super(message);
	}
	
}

interface UserBiz{
	void login(String username, String password) throws LoginException;
	void register(String username, String password, String password2,
			String name, String email) throws RegisterException;
}

interface UserView{
	void login();
	void register();
}

class UserBizImpl implements UserBiz{
	private Map userMap;
	
	public UserBizImpl(){
		userMap = new HashMap();
		User admin = new User("admin", "admin", "Administrator", "admin@123.com");
		User tom = new User("tom", "cat", "tomcat", "tomcat@cat.com");
		
		userMap.put(admin.getUsername(), admin);
		userMap.put(tom.getUsername(), tom);
	}
	
	public void login(String username, String password) throws LoginException {
		if (!userMap.containsKey(username)){
			throw new LoginException("�û���������");
		}
		User user = (User) userMap.get(username);
		if (!user.getPassword().equals(password)){
			throw new LoginException("�û������벻ƥ�䣡");
		}
	}

	public void register(String username, String password, String password2,
			String name, String email) throws RegisterException {
		if (userMap.containsKey(username)){
			throw new RegisterException("�û����Ѵ���");
		}
		if (!password.equals(password2)){
			throw new RegisterException("�������벻ƥ��");
		}
		User user = new User(username, password, name, email);
		userMap.put(username, user);
	}
	
}

class UserViewImpl implements UserView{
	private UserBiz biz;
	private Scanner sc;
	public UserViewImpl(){
		biz = new UserBizImpl();
		sc = new Scanner(System.in);
	}
	
	public void login(){
		System.out.println("�������û���");
		String username = sc.nextLine();
		System.out.println("����������");
		String password = sc.nextLine();
		try{
			biz.login(username, password);
		}catch(LoginException e){
			System.out.println("��¼����! " + e.getMessage());
			return;
		}
		System.out.println("Login OK");
	}
	
	public void register(){
		System.out.println("�������û���");
		String username = sc.nextLine();
		System.out.println("����������");
		String password = sc.nextLine();
		System.out.println("���ظ�����");
		String password2 = sc.nextLine();
		System.out.println("��������ʵ����");
		String name = sc.nextLine();
		System.out.println("�������������ַ");
		String email = sc.nextLine();
		try{
			biz.register(username, password, password2, name, email);
		}catch(RegisterException e){
			System.out.println("ע����� " + e.getMessage());
			return;
		}
		System.out.println("ע��ɹ�");
	}
}

public class TestException {

	public static void main(String[] args) {
		UserView view = new UserViewImpl();
		
		while(true){
			System.out.println("1 : ��¼");
			System.out.println("2 : ע��");
			System.out.println("����������ѡ��");
			int choice = sc.nextInt();
			
			if (choice == 1){
				view.login();
			}else if (choice == 2){
				view.register();
			}else{
				System.out.println("����������");
			}
		}
	}
	
	

}
