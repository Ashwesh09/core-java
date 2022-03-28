package week4;
public class StringSecret {
    public static void main(String[] args) {
        String secretMessage = "Bzwarz!1It9is3java2whzn1you5arz4using3phonzs8during1thz9szssions";
        secretMessage = secretMessage.replace('z', 'e');
        secretMessage = secretMessage.replaceAll("[0-9]", " ");
        secretMessage = secretMessage.replaceFirst("java", "obvious");
        secretMessage = secretMessage.toUpperCase();
        System.out.println(secretMessage);
    }    
}
