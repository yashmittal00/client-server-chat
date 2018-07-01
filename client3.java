// a client that sends data and recieves data
import java.io.*;
import java.net.*;
class client3
{
public static void main(String args[])throws Exception
{
Socket s=new Socket("localhost",3333);
    //socket s3=new Socket("ip address",3333);
   //to send data to the server
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
   //to read data coming from server
DataInputStream din= new DataInputStream(s.getInputStream());
   //to read data from keyboard 
BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
 String str="",str1="";
// repeat as long as exit is not typed at client
while(!str.equals("stop")) 
{
 str=kb.readLine();
dout.writeUTF(str);
dout.flush();
str1=din.readUTF();
System.out.println("Server says:::"+str1);
}
//close connection

dout.close();
s.close();
}
} 