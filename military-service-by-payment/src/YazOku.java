
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class YazOku {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Askerlik Bedelli Ücret Öğrenme Programına Hoşgeldiniz...\n");
                
        String bankaAdı;
        String amac ;
        String islem ;
        while(true){
            System.out.println("1) işlem oluşturma\n"
                    + "2) çıkış -1\n"
                    + "3) okuma\n"
                    + "4) Tutar öğren");
            islem = scn.nextLine();
            if(islem.equals("1")){
                System.out.println("Banka adını giriniz");
                bankaAdı = scn.nextLine();
                System.out.println("amacı giriniz");
                amac = scn.nextLine();
                yaz(bankaAdı, amac);
            }else if(islem.equals("-1")){
                break;
            }else if(islem.equals("3")){
                oku();
            }else if(islem.equals("4")){
                System.out.println("Banka adını giriniz");
                bankaAdı = scn.nextLine();
                System.out.println("amacı giriniz");
                amac = scn.nextLine();
                Banka bkod = new Banka(bankaAdı, amac);
                bkod.odeme();
            }
          
            
   
       
            
        }
       
    }
    public static void yaz(String bankaAdı,String amac){
           try(ObjectOutputStream yaz = new ObjectOutputStream(new FileOutputStream("banka.bin"))){
                Banka bk = new Banka(bankaAdı, amac);
                //Banka bk1 = new Banka(bankaAdı, amac);
                yaz.writeObject(bk);
            }catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı");
            }catch (IOException ex) {
            System.out.println("Dosya Açılırken hata meydana geldi");
             }
    }
    public static void oku(){
            try(ObjectInputStream oku = new ObjectInputStream(new FileInputStream("banka.bin"))){
                //Banka bk1 = new Banka(bankaAdI,amac);
                Banka bk = (Banka)oku.readObject();
               // Banka bk1 = (Banka)oku.readObject();
                System.out.println("*************************************");
                System.out.println(bk);
                System.out.println("*************************************");
               // System.out.println(bk1);
            }catch(FileNotFoundException ex){
            System.out.println("Dosya Bulunamadı");
            }catch(IOException ex){
            System.out.println("Dosya Açılırken hata meydana geldi");
            } catch (ClassNotFoundException ex) {
                System.out.println("Sınıf Bulunamadı");
        }
    }
    
}
