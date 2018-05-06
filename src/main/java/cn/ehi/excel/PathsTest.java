package cn.ehi.excel;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class PathsTest {

    public static void main(String[] args) throws IOException {
//        Files.copy(new FileInputStream("pom.xml"),Paths.get("test.xml"), StandardCopyOption.REPLACE_EXISTING);
//        OutputStream os = new FileOutputStream("test.xml");
//        Files.copy(Paths.get("pom.xml"),os);
//        os.close();
//        print("33");
//        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("pom.xml"));
//        char[] cs = new char[10];
//        int len = 0;
//        while((len = bufferedReader.read(cs))!=-1){
//            System.out.print(String.valueOf(cs,0,len));
//        }
//        bufferedReader.close();
//        Files.walk(Paths.get("/home/leason/code")).forEach(System.out::println);

//        InputStream is = new FileInputStream("pom.xml");
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader reader = new BufferedReader(isr);
//        String data;
//        while((data = reader.readLine()) != null){
//            System.out.println(data);
//        }
//        isr.close();
//        reader.close();
//        is.close();

//        byte[] bs = new byte[]{(byte)233,(byte)153,(byte)179,(byte)233,(byte)153,(byte)179};
//        InputStream is = new ByteArrayInputStream(bs);
//        InputStream bis = new BufferedInputStream(is);
//        InputStreamReader reader = new InputStreamReader(bis);
//        int data;
//        while((data = reader.read())!=-1){
//
//            System.out.println((char)data);
//        }
//        reader.close();
//        bis.close();
//        is.close();

//        Reader reader = new FileReader("test.xml");
//        int data;
//        int bitCount = 0;
//        while((data = reader.read()) != -1){
//            bitCount++;
////            System.out.println(data);
//            System.out.print((char)data);
//        }
//        System.out.println(bitCount);
//        reader.close();

//        Writer writer = new FileWriter("test.xml",true);
//        writer.append("哈哈");
//        writer.flush();
//        writer.close();

        RandomAccessFile raf = new RandomAccessFile("pom.xml","rw");
        FileChannel channel = raf.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        while(channel.read(bf)!=-1){
            bf.flip();
            System.out.println(Charset.forName("UTF-8").decode(bf));
            bf.clear();
        }
        channel.close();
        raf.close();
    }

//    static void print(String arg1,String... arg2){
//        System.out.println(arg1);
//        System.out.println(Arrays.toString(arg2));
//    }
}
