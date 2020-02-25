package jar;

class Address{
    /**
     * 
     * 编写Address类，包括国家、省份、城市、街道、邮编
     */
    String country;
    String province;
    String city;
    String street;
    String zipcode;

    public void setCountry(String country){
        this.country=country;
    }
    public void setProvince(String province){
        this.province=province;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setStreet(String street){
        this.street=street;
    }
    public void setZipcode(String zipcode){
        this.zipcode=zipcode;
    }

    public String getCountry(){
        return this.country;
    }
    public String getProince(){
        return this.province;
    }
    public String getCity(){
        return this.city;
    }
    public String getStreet(){
        return this.street;
    }
    public String getZipcode(){
        return this.zipcode;
    }

    public Address(){
        this("中华人名共和国","北京","北京","天安门街道","100001");
    }
    public Address(String country,String province,String city,String street,String zipcode){
        this.country=country;
        this.province=province;
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }

    public String getInfo(){
        return "国家："+this.country+"、省份："+this.province+"、城市："+this.city+"、街道："+this.street+"、邮编："+this.zipcode;
    }
}

public class Demo007{
    public static void main(String[] args){
        System.out.println(new Address("中国","北京市","北京","天安门街道","100002").getInfo());
    }
}