
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Banka implements Serializable{
    
    private String banka ;
    private String amac ;
    public double faiz ;
    public double anapara = 37070.64;
    public Banka(String banka, String amac) {
        this.banka = banka;
        if(banka.equals("garanti")){
           faiz = 1.84;
           
        }
        else if(banka.equals("ING")){
            faiz = 1.54;
        }else if(banka.equals("is bankası ")){
            faiz = 1.50;
        }else if(banka.equals("akbank")){
            faiz = 1.74;
        }else if(banka.equals("ziraat")){
            faiz = 1.75;
        }else if(banka.equals("vakıf")){
            faiz = 1.79;
        }else {
            System.out.println("Türkiye de bedelli için kredi açan bankaların listeleri getiriliyor.Lütfen Bekleyiiniz.");
            try{
               Thread.sleep(3000); 
            }catch(InterruptedException ex){
                System.out.println("Sayaç çalışma sırasında hata meydana geldi");
            }finally{
                String bankaListesi = "ING\n"
                        + "is bankası\n"
                        + "akbank\n"
                        + "ziraat\n"
                        + "vakıf\n";
                System.out.println(bankaListesi);
            }
            
        }
        if(amac.equals("askerlik") || amac.equals("bedelli") || amac.equals("bedelli askerlik")){
             this.amac = amac;
        }else{
            System.out.println("bu kredi için başvuru koşulları ekranınıza getiriliyor Lütfen Bekleyiniz...");
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                System.out.println("amaç Sayacı çalışma sırasında bir hata meydana geldi");
            }finally{
                String amacListesi ="bedelli\n"
                        + "bedelli askerlik\n"
                        + "askerlik";
                System.out.println(amacListesi);
            }
       
        }
       
    }
  

    @Override
    public String toString() {
       return "banka adı : "+banka+"\n"+
               "amac : "+amac;
    }
  public void odeme(){
      System.out.println("Kredi kullanmanız durumunda ödemeneniz gereken tutar : " +(faiz*anapara)+" bin Türklarısıdır.");
  }
  
    
    
}
