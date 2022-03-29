package BeanConfigDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UserDataReader {
    public UserBean myFactory(){
        File file = new File("BeanConfigDemo\\user_data.xml");
        try(BufferedReader br = new BufferedReader(new FileReader(file));){
        UserBean myBean = new UserBean();
        String st;
        while ((st = br.readLine()) != null)
            if(st.trim().equals("<first_name>")){
                myBean.setFirstName(br.readLine().trim());
                break;
            }
        while ((st = br.readLine()) != null)
            if(st.trim().equals("<last_name>")){
                myBean.setLastName(br.readLine().trim());
                break;
            }
        return myBean;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
