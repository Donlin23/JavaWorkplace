package javaNetworkProgramming.URLConnection_7;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:Donlin
 * @Description: 7.3 从web网站下载一个二进制文件并保存到磁盘
 * @Date: Created in 15:42 2018/3/25
 * @Version: 1.0
 */
public class BinarySaver {

    private static String url = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1732096583,3453063905&fm=27&gp=0.jpg";

    public static void main(String[] args) {
        try {
            URL root = new URL(url);
            saveBinaryFile(root);
        } catch (MalformedURLException e) {
            System.err.println(url + " is not a parseable url.");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinaryFile(URL u) throws IOException {
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int contentLength = uc.getContentLength();
        if (contentType.startsWith("text/") || contentLength == -1){
            throw new IOException("This is not a binary file.");
        }

        try(InputStream raw = uc.getInputStream()){
            BufferedInputStream in = new BufferedInputStream(raw);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while(offset < contentLength){
                int bytesRead = in.read(data,offset,data.length - offset);
                if (bytesRead == -1)
                    break;
                offset += bytesRead;
            }

            if (offset != contentLength){
                throw new IOException("Only read " + offset + "bytes; Expected " + contentLength + "bytes.");
            }

            String fileName = u.getFile();
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
            try(FileOutputStream fout = new FileOutputStream(fileName)){
                fout.write(data);
                fout.flush();
            }
        }
    }
}
