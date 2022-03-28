package SpringConfigDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("SpringConfigDemo\\data.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file));){
        MyFactory beanFactory = new MyFactory();
        MyBean myBean = beanFactory.createMyBean();
        myBean.setFirstName(br.readLine());
        myBean.setLastName(br.readLine());
        System.out.println(myBean);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}



