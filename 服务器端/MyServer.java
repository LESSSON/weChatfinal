import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

//import com.sun.xml.internal.bind.v2.runtime.Name;

public class MyServer {
    // 定义ServerSocket的端口号
    private static final int SOCKET_PORT = 50000;

    // 使用ArrayList存储所有的Socket
    // public static ArrayList<ManageClients> socketList = new
    // ArrayList<ManageClients>();
    public static HashMap<Integer, Socket> IdSocket = new HashMap<Integer, Socket>();// 记录ID与用户线程的键值对
    public static Integer i = 0; // 记录客户端数量，同时也是用户的ID
    public static HashMap<String, Integer> sta = new HashMap<String, Integer>();// 记录用户名字与ID的键值对
    public static HashMap<String, String> up = new HashMap<String, String>();// 已注册用户的用户名和密码
    public static int flag = 0;// 判断是否登录成功标志

    public void initMyServer() {
        try {
            // 初始化用户队列
            String[] user = { "fmx", "zxl", "zc", "ll" };
            String[] pass = { "xmf", "lxz", "cz", "ll" };
            // for (i = 0; i <= 3; i++) {
            // up.put(user[i], pass[i]);
            // }
            // 创建一个ServerSocket，用于监听客户端Socket的连接请求
            ServerSocket serverSocket = new ServerSocket(SOCKET_PORT); // 创建一个ServerSocket，用于监听客户端Socket的连接请求
            System.out.println("服务器启动！");
            // 循环监听等待客户端的链接
            while (true) {
                // 当接收到客户端的Socket请求，服务器端也相应的创建一个Socket
                Socket socket = serverSocket.accept();
                // 客户端数量增加，客户端ID加1
                i++;
                // 存储ID与用户线程的键值对
                IdSocket.put(i, socket);
                // 启动新用户线程
                new Thread(new ServerThread(socket, i)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        myServer.initMyServer();
    }

}
