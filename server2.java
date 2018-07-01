import java.io.*;
import java.net.*;



class connect1 extends Thread
{  
public void run()
{ 
try
{
//create server socket
ServerSocket ss=new ServerSocket(3333);
//connect it toclient socket
Socket s=ss.accept();
DataInputStream din= new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str="",str1="";
// repeat as long as client does not send null string
while(!str.equals("stop"))
{
str=din.readUTF();
System.out.println("Client1 says:::"+str);//send to client
str1=br.readLine();
dout.writeUTF(str1);
dout.flush();
}
din.close();
s.close();
ss.close();
}
catch(Exception e)
{
System.out.println(e);

}
}} 
  



class connect2 extends Thread
{  
public void run()
{ 
try
{
//create server socket
ServerSocket ss=new ServerSocket(4444);
//connect it toclient socket
Socket s=ss.accept();
DataInputStream din= new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str="",str1="";
// repeat as long as client does not send null string
while(!str.equals("stop"))
{
str=din.readUTF();
System.out.println("Client2 says:::"+str);//send to client
str1=br.readLine();
dout.writeUTF(str1);
dout.flush();
}
din.close();
s.close();
ss.close();
}
catch(Exception e)
{
System.out.println(e);

}
}
} 


class server2
{


public static void main(String args[])throws Exception
{


connect1 t1=new connect1(); 

t1.start();

connect2 t2=new connect2();

t2.start();

}
}
