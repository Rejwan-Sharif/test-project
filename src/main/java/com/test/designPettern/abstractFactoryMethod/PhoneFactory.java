package com.test.designPettern.abstractFactoryMethod;



public class PhoneFactory  implements DeviceFactory{

    @Override
      public  Phone createDevice (String name) throws Exception{
        if (name.equalsIgnoreCase("iphone")){
          return   new IPhone();
        }else if(name.equalsIgnoreCase("oppo")){
           return new Oppo();
        }
        throw new RuntimeException("No Phone Found");
    }
}



